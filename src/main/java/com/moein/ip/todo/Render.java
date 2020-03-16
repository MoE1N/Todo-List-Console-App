package com.moein.ip.todo;

import com.moein.ip.utils.ConsoleControl;

public class Render {

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

    private static void header(){
        clearScreen();
        System.out.println( "==================================\n" +
                "== " + ConsoleControl.YELLOW_BOLD + "Welcome to SDA Todo List App" + ConsoleControl.RESET + "==\n"+
                "==================================");
    }

    public static void mainMenu(){
        header();
        System.out.println("==================================\n" +
                "== " + ConsoleControl.YELLOW + "1. Show com.todo.Task List \n" + ConsoleControl.RESET +
                "== " + ConsoleControl.YELLOW + "2. Add New com.todo.Task \n" + ConsoleControl.RESET +
                "== " + ConsoleControl.YELLOW + "3. Edit com.todo.Task \n" + ConsoleControl.RESET +
                "== " + ConsoleControl.YELLOW + "4. Quit \n" + ConsoleControl.RESET +
                "==================================\n");
    };

}
