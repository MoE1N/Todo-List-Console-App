package com.moein.ip.todo;

import com.moein.ip.utils.ConsoleControl;

import java.util.ArrayList;

public class Activity {

    private boolean isQuit = false;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Activity() {
        tasks.add(new Task("Title3", "ProjectY", "2020-04-04"));
        tasks.add(new Task("Title2", "ProjectX", "2020-04-03"));
        tasks.add(new Task("Title1", "ProjectX", "2020-04-02"));
        tasks.add(new Task("Title5", "ProjectY", "2020-04-05"));
        tasks.add(new Task("Title4", "ProjectX", "2020-04-04"));
    }

    public void run() {
        Render.header();
        while (!isQuit) {
            Render.mainMenu();
            String input = View.readUserInput();

            switch (input) {
                case "1":
                    View.printAllTasks(tasks);
                    View.handelSortingOptions(tasks);
                    break;
                case "2":
                    tasks.add(View.handleNewTask());
                     Render.messageBox("New Task Created Successfully!");
                    break;
                case "3":
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
