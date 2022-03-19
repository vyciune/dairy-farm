package com.company;

import com.company.tree.Tree;
import com.company.util.Util;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        var tree = new Tree(0); //root node();

        while (true) {

            try {

            Util.printAvailableCommands();

            var command = scanner.nextInt();
            scanner.reset();

                switch (command) {
                    case 1:
                        System.out.println("Enter parentCowId, childCowId and childNickName separated by empty space");
                        var parentCowId = scanner.nextInt();
                        var childCowId = scanner.nextInt();
                        var nickName = scanner.nextLine().stripLeading();
                        tree.insert(parentCowId, childCowId, nickName);
                        break;
                    case 2:
                        System.out.println("Enter cowId to remove the cow from the farm");
                        var cowId = scanner.nextInt();
                        tree.deleteById(cowId);
                        break;
                    case 3:
                        tree.print();
                        break;
                    default:
                        System.out.println("Choose one of the available command");
                }
            } catch (Exception e) {
                System.out.println("ERROR - " + e.getMessage());
                System.out.println("press enter to continue");
                if(scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
    }
}
