package com.company.tree;

import com.company.entity.Cow;

public class Tree {

    private final Node root;

    public Tree(int rootId) {
        this.root = new Node(new Cow(0, "rootCow"), null);
    }

    public void insert(int parentId, int childId, String nickName) throws Exception {

        var parentNode = findById(parentId);

        if(parentNode == null) throw new Exception("parent Id not found");

        if (parentNode != null) { //parent not found: bad parent id, or tree empty
            Node child = new Node(new Cow(childId, nickName), parentNode);
            if(parentNode.getChild() != null) { // has a child, need to search for last child
                var lastChildOfParentNode = findLastSibling(parentNode.getChild());
                child.setPrevious(lastChildOfParentNode);
                lastChildOfParentNode.setSibling(child);
            } else {
                child.setPrevious(parentNode);
                parentNode.setChild(child);
            }
        }
    }

    public void deleteById(int id) throws Exception {
        var nodeToDelete = findById(id);

        if(nodeToDelete == null) throw new Exception("parent Id not found");

        var parent = nodeToDelete.getParent();
        var previous = nodeToDelete.getPrevious();

        // if previous link was from father (left link to node)
        if (parent == previous) {

            if(nodeToDelete.getChild() != null) {
                //find last of child of deleted node and set it's sibling to deleted's sibling
                findLastSibling(nodeToDelete.getChild()).setSibling(nodeToDelete.getSibling());
                parent.setChild(nodeToDelete.getChild());
            } else {
                parent.setChild(nodeToDelete.getSibling());
            }

        } else { //if previous of node to delete was sibling
            //find last child of deleted node and set it's deleted node's sibling to last child sibling
            findLastSibling(nodeToDelete.getChild()).setSibling(nodeToDelete.getSibling());
            previous.setSibling(nodeToDelete.getChild());
        }
    }

    // returns node if no child, otherwise returns last child
    private Node findLastSibling(Node node) {
        return node.getSibling() != null ? findLastSibling(node.getSibling()) : node;
    }

    private Node findById(int id) {
        if (this.root != null && this.root.getId() == id) {
            return  this.root;
        }
        //search children first (dfs)
        return findRecursivelyById(this.root, id);
    }

    private Node findRecursivelyById(Node node, int id) {
        Node foundNode = null;

        if (node != null) {
            if(node.getId() == id) {
                return node;
            }
            foundNode = findRecursivelyById(node.getChild(), id);
            if(foundNode != null) {
                return foundNode;
            }

            foundNode = findRecursivelyById(node.getSibling(), id);
        }
        return foundNode;
    }

    public void print() {
        printRecursively(root, 0);
    }

    void printRecursively(Node root, int space)
    {
        if (root == null) {
            return;
        }
        // print all siblings first
        int count = 10;
        space += count;
        printRecursively(root.getSibling(), space);

        System.out.print("\n");
        if(count < space) {
            System.out.print(" ".repeat(space));
        }
        System.out.print(root.getCow().toString() + "\n");

        // print child
        printRecursively(root.getChild(), space);
    }
}
