package com.moein.ip.todo;

import com.moein.ip.utils.ConsoleControl;

import java.util.ArrayList;

public class Render {

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

    public static void header(){
        clearScreen();
        System.out.println( "==================================\n" +
                "== " + ConsoleControl.YELLOW_BOLD + "Welcome to SDA Todo List App" + ConsoleControl.RESET + " ==\n"+
                "==================================");
    }

    public static void mainMenu(){

        System.out.println("=========== MAIN MENU ============\n" +
                "== " + ConsoleControl.YELLOW + "1. Show Task List \n" + ConsoleControl.RESET +
                "== " + ConsoleControl.YELLOW + "2. Add a New Task \n" + ConsoleControl.RESET +
                "== " + ConsoleControl.YELLOW + "3. Edit a Task \n" + ConsoleControl.RESET +
                "== " + ConsoleControl.YELLOW + "4. Quit \n" + ConsoleControl.RESET +
                "==================================\n");

    };

    public static void sortingOptions(){
        singleLineSeparator();
        System.out.println("Choose a sorting option: " +
                ConsoleControl.BLUE_BOLD_BRIGHT +"(1)" + ConsoleControl.RESET + " By Title  " +
                "|  " + ConsoleControl.BLUE_BOLD_BRIGHT + "(2)"+ ConsoleControl.RESET +" By Project  " +
                "|  " + ConsoleControl.BLUE_BOLD_BRIGHT + "(3)"+ ConsoleControl.RESET +" By Deadline");
        singleLineSeparator();
        System.out.println("Enter " +
                ConsoleControl.BLUE_BOLD_BRIGHT +"(c)" + ConsoleControl.RESET + " to continue in the main menu...");
        singleLineSeparator();
    }

    public static void renderTasks(ArrayList<Task> tasks){

        System.out.println();
        for(Task task: tasks){

        }

    }

    public final static void messageBox(String message)
    {
        System.out.println();
        System.out.println(ConsoleControl.BLACK_BACKGROUND);
        System.out.println(ConsoleControl.WHITE_BACKGROUND_BRIGHT);

        System.out.println(ConsoleControl.GREEN + message);

        System.out.println(ConsoleControl.WHITE_BACKGROUND_BRIGHT);
        System.out.println(ConsoleControl.BLACK_BACKGROUND);

        System.out.println(ConsoleControl.RESET);
    }

    public static void invalidInputMsg(){
        System.out.println(ConsoleControl.RED + "Invalid Input!  Please try again." + ConsoleControl.RESET);
    }

    public static void singleLineSeparator(){
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void doubleLineSeparator(){
        System.out.println("=============================================================================\n");
    }

}
