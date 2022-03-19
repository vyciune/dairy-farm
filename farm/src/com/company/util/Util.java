package com.company.util;

public class Util {

    public static void printAvailableCommands() {
        System.out.println(
                "\nAvailable commands: \n " +
                        "1. GiveBirth (parentCowId, childCowId, childNickName) \n " +
                        "2. EndLifeSpan (cowId) \n " +
                        "3. Print farm data \n "
        );
    }

}
