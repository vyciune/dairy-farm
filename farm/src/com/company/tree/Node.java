package com.company.tree;

import com.company.entity.Cow;

public class Node {

    private final Cow cow;
    private Node child;     // left
    private Node sibling;   // right
    private Node parent;
    private Node previous;

    public Node(Cow cow, Node parent) {
        this.cow = cow;
        this.parent = parent;
    }

    public Cow getCow() {
        return cow;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }

    public Node getParent() {
        return parent;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getId() {
        return this.cow.getCowId();
    }
}
