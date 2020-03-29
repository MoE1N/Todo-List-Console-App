package com.moein.ip.todo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Activity {

    private boolean isQuit = false;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Activity() {
        tasks.add(new Task("Title3", "ProjectY", "2020-04-04"));
        tasks.add(new Task("Title2", "ProjectX", "2020-04-03"));
        tasks.add(new Task("Title1", "ProjectX", "2020-04-02"));
        tasks.add(new Task("Title5", "ProjectY", "2020-04-05"));
        tasks.add(new Task("Title4", "ProjectX", "2020-04-04"));
        tasks.get(2).setDone();
        tasks.get(4).setDone();
    }

    public void run() {
        Render.header();
        while (!isQuit) {
            Render.mainMenu();
            String input = View.readUserInput();

            switch (input) {
                case "1":
                    // Render only undone tasks
                    tasks.stream().filter( task -> !task.isDone() ).collect(Collectors.toList());
                    View.printUndoneTasks(tasks);
                    View.handelSortingOptions(tasks);
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
                    Render.messageBox("Good Bye!");
                    break;
                default:
                    Render.invalidInputMsg();
            }

        }
    }



}
