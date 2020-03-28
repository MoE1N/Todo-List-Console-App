package com.moein.ip.todo;

import com.moein.ip.utils.ConsoleControl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

        public static void printAllTasks(ArrayList<Task> tasks) {

        // Print the list objects in tabular format.
            System.out.println("=================================" +
                    " TODO LIST " +
                    "=================================");
            Render.singleLineSeparator();
        System.out.printf(ConsoleControl.GREEN_BOLD +
                "%10s %30s %20s", "TITLE", "PROJECT", "DEADLINE"  +
                ConsoleControl.RESET);
        System.out.println();
        Render.singleLineSeparator();
        for(Task task: tasks){
            System.out.format("%10s %30s %20s",
                    task.getTitle(), task.getProject(), task.getDeadline());
            System.out.println();
        }
            Render.sortingOptions();

        }

    /**
     * Get the chose of user on what to sort with, through the console input.
     *   1 -> Sort by title | 2 -> Sort by project | 3 -> Sort by Deadline
     * @param tasks
     */
    public static void handelSortingOptions( ArrayList<Task> tasks){

        String userInput = readUserInput();

        while (!userInput.equalsIgnoreCase("c")){
            switch (userInput){
                case "1":
                    printAllTasks( Task.getSortedTasks(tasks, Task.TaskSortableBy.title ) );
                    break;
                case "2":
                    printAllTasks( Task.getSortedTasks(tasks, Task.TaskSortableBy.project) );
                    break;
                case "3":
                    printAllTasks( Task.getSortedTasks(tasks, Task.TaskSortableBy.deadline) );
                    break;
                default:
                    Render.invalidInputMsg();
                    Render.sortingOptions();
            }
            userInput = readUserInput();
        }

    }

    public static Task handleNewTask(){

        String title;
        String project;
        String deadline;

        System.out.println("======== ADD A NEW TASK ==========");
        System.out.println("----------------------------------");
        System.out.println("Enter Your Task Title:");
        title = readUserInput();

        System.out.println("----------------------------------");
        System.out.println("Enter Associated Project:");
        project = readUserInput();

        System.out.println("----------------------------------");
        System.out.println("Enter The Deadline in YYYY-MM-DD Format:  (Example: 2020-04-01)");
        deadline = readLocalDateCompatibleUserInput();

        return new Task(title, project, deadline);

    }

    public static String readUserInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static String readLocalDateCompatibleUserInput() {

        LocalDate input = null;

        do {
            try{
                input = LocalDate.parse(readUserInput());
                return input.toString();
            } catch (Exception error){
                System.out.println( ConsoleControl.RED + "INVALID DATE FORMAT! TRY AGAIN...\n" + ConsoleControl.RESET );
                System.out.println("Enter The Deadline in YYYY-MM-DD Format:  (Example: 2020-04-01)");
            }
        } while (input == null);

        return null;
    }


}
