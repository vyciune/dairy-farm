# dairy-farm
Program representing dairy farm with custom data structure. Tree node contain's reference to child(left), sibling(right), previous and parent node's.
Child note represents if child of the current node.
sibling note represent if there are any node on the current level from the same parent.
previous node is the node, which points to current node.
parent node is the node that is selected as parent used insertion.

# the printing method could look a bit weird, I will explain how this data structure works here:
![tree](https://user-images.githubusercontent.com/45511896/159123366-7437a36d-8e36-41ac-b261-4fa0f354b893.png)

I used a general tree for farm data structure.
<pre>
if you have a tree that looks like this:
          1     
        /   \   
      2       3       
     / \           
    4   5      
the printed out tree will look like this
1
         3
    2
             5
          4   
you can interpret it too look like this, when rotated and added links
        1
       /  
      2
    /   \
   4     3
    \
     5
</pre>
