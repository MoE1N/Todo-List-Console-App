package com.moein.ip.todo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Activity {

    private boolean isQuit = false;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Activity() {
        tasks = View.dbRestoreHandeler();
    }

    public void run() {
        Render.header();

        while (!isQuit) {
            Render.mainMenu();
            String input = View.readUserInput();

            switch (input) {
                case "1":
                    // Render only undone tasks
                    ArrayList<Task> undoneTasks = (ArrayList<Task>) tasks.stream()
                            .filter(task -> !task.isDone() )
                            .collect(Collectors.toList());
                    View.printUndoneTasks(undoneTasks);
                    break;
                case "2":
                    tasks.add(View.handleNewTask());
                     Render.messageBox("New Task Created Successfully!");
                    break;
                case "3":
                    View.handleTaskEdit(tasks);
                    break;
                case "4":
                    isQuit = true;
                    View.saveBackupHandler(tasks);
                    Render.messageBox("Good Bye!");
                    break;
                default:
                    Render.invalidInputMsg();
            }

        }
    }



}
