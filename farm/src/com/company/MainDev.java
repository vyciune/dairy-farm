package com.company;

import com.company.tree.Tree;

public class MainDev {

    public static void main(String... args) throws Exception {

        /*
                        0
                  /     |     \
                /       |       \
              /         |         \
            1           2           3
          /   \         |           |
        4       5       7       9  10   11
        |               |          /\
        6               8         12  13
                                       \
                                       14
         */

        var tree = new Tree(0); //root node
        tree.insert(0, 1, "nick");
        tree.insert(0, 2, "nick");
        tree.insert(0, 3, "nick");

        tree.insert(1, 4, "nick");
        tree.insert(1, 5, "nick");

        tree.insert(2, 7, "nick");

        tree.insert(3, 9, "nick");
        tree.insert(3, 10, "nick");
        tree.insert(3, 11, "nick");

        tree.insert(4, 6, "nick");

        tree.insert(7, 8, "nick");

        tree.insert(10, 12, "nick");
        tree.insert(10, 13, "nick");

        tree.insert(13, 14, "nick");

        tree.deleteById(10);
        tree.print();

    }
}
