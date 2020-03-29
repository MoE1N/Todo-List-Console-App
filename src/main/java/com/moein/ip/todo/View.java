package com.moein.ip.todo;

import com.moein.ip.utils.ConsoleControl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

    public static void printUndoneTasks(ArrayList<Task> tasks) {

        // Print the list objects in tabular format.
        System.out.println("=================================" +
                " TODO LIST " +
                "=================================");
        Render.singleLineSeparator();
        System.out.printf(ConsoleControl.GREEN_BOLD +
                "%2s %10s %30s %20s", "ID", "TITLE", "PROJECT", "DEADLINE" +
                ConsoleControl.RESET);
        System.out.println();
        Render.singleLineSeparator();
        for (Task task : tasks) {
            System.out.format("%2d %10s %30s %20s",
                    task.getId(), task.getTitle(), task.getProject(), task.getDeadline());
            System.out.println();
        }

    }

    public static void printAllTasks(ArrayList<Task> tasks) {

        // Print the list objects in tabular format.
        System.out.println("=================================" +
                " ALL TASKS " +
                "=================================");
        Render.singleLineSeparator();
        System.out.printf(ConsoleControl.GREEN_BOLD +
                "%2s %10s %30s %20s", "ID", "TITLE", "PROJECT", "DEADLINE" +
                ConsoleControl.RESET);
        System.out.println();
        Render.singleLineSeparator();

        for (Task task : tasks) {

            if (task.isDone()) {
                System.out.print(ConsoleControl.STRIKEDTHROUGH);
            }

            System.out.format("%2d %10s %30s %20s",
                    task.getId(), task.getTitle(), task.getProject(), task.getDeadline());
            System.out.println(ConsoleControl.RESET);
        }

    }


    /**
     * Get the chose of user on what to sort with, through the console input.
     * 1 -> Sort by title | 2 -> Sort by project | 3 -> Sort by Deadline
     *
     * @param tasks
     */
    public static void handelSortingOptions(ArrayList<Task> tasks) {

        Render.sortingOptions();

        String userInput = readUserInput();

        while (!userInput.equalsIgnoreCase("c")) {
            switch (userInput) {
                case "1":
                    printUndoneTasks(Task.getSortedTasks(tasks, Task.TaskSortableBy.title));
                    break;
                case "2":
                    printUndoneTasks(Task.getSortedTasks(tasks, Task.TaskSortableBy.project));
                    break;
                case "3":
                    printUndoneTasks(Task.getSortedTasks(tasks, Task.TaskSortableBy.deadline));
                    break;
                default:
                    Render.invalidInputMsg();
                    Render.sortingOptions();
            }
            userInput = readUserInput();
        }

    }

    public static Task handleNewTask() {

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

    public static void handleTaskEdit(ArrayList<Task> tasks) {

        printAllTasks(tasks);
        Render.editOptions();

        Task task;
        String input = readUserInput();

        Boolean isFound = false;
        while (true) {

            if (input.equalsIgnoreCase("c")) {
                break;
            }


            int finalInput = Integer.parseInt(input);
            try {
                isFound = tasks.stream().anyMatch(taskItem -> taskItem.getId() == finalInput);
            } catch (Exception error) {
            }

            if (isFound) {
                task = tasks.stream().filter(taskItem -> taskItem.getId() == finalInput).findFirst().get();
                editTask(task);
                Render.messageBox("The task has been updated successfully!");
                printAllTasks(tasks);
                Render.editOptions();
                isFound = false;
                input = readUserInput();
                continue;
            }

            Render.taskNotFoundMsg();
            Render.editOptions();
            input = readUserInput();

        }

    }

    private static void editTask(Task task) {
        String input = null;

        System.out.println("=========== EDIT TASK ============");
        System.out.println("Enter a new value and press Enter to update.\n Just hit Enter to keep the current value.");
        Render.singleLineSeparator();

        System.out.println("Title: (" + task.getTitle() + ")");
        input = readUserInput();
        if (!input.equals("")) {
            task.setTitle(input);
        }

        System.out.println("Project: (" + task.getProject() + ")");
        input = readUserInput();
        if (!input.equals("")) {
            task.setProject(input);
        }

        System.out.println("Deadline: (" + task.getDeadline().toString() + ")");
        input = readLocalDateCompatibleOrEmptyString();
        if (!input.equals("")) {
            task.setDeadline(LocalDate.parse(input));
        }

        String status = task.isDone() == false ? "Todo" : "Done";
        System.out.println("Status: (" + status + ")   Enter 't' to toggle or just Enter to keep the current status.");
        input = readUserInput();
        if (!input.equals("")){
            task.toggleStatus();
        }

    }

    public static String readUserInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


    private static Boolean isLocalDateCompatible(String dateString) {

        try {
            LocalDate.parse(dateString);
            return true;
        } catch (Exception error) {

        }
        return false;
    }

    private static String readLocalDateCompatibleUserInput() {

        String input = null;


        do {
            input = readUserInput();
            if (isLocalDateCompatible(input)) {
                return input;
            }
            System.out.println(ConsoleControl.RED + "INVALID DATE FORMAT! TRY AGAIN...\n" + ConsoleControl.RESET);
            System.out.println("Enter The Deadline in YYYY-MM-DD Format:  (Example: 2020-04-01)");
            input = null;

        } while (input == null);

        return null;
    }

    private static String readLocalDateCompatibleOrEmptyString() {

        String input = null;

        do {
            input = readUserInput();
            if (input.equals(""))
                return "";
            if (isLocalDateCompatible(input))
                return input;

            System.out.println(ConsoleControl.RED + "INVALID DATE FORMAT! TRY AGAIN...\n" + ConsoleControl.RESET);
            System.out.println("Enter The Deadline in YYYY-MM-DD Format:  (Example: 2020-04-01)");
            System.out.println("Or just press Enter to continue with the current value.");
            input = null;

        } while (input == null);

        return null;
    }


}
