package com.codecool.gladiator.view;

import java.util.Scanner;

/**
 * Basic console view implementation
 */
public class ConsoleView implements Viewable {

    @Override
    public void display(String text) {
        System.out.println(text+"\n");
    }

    @Override
    public int getNumberBetween(int min, int max) {
        // Todo
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number in the range <"+min+","+max+">:");
        int result = scanner.nextInt();
        while (result < min || result > max) {
            System.out.println("Wrong inpute, please again!");
            result = scanner.nextInt();
        }
        return result;
    }

}
