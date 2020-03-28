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
//                    tasks.add(View.handleNewTask());
//                      Render.taskCreatedMsg();
                    break;
                case "3":
//                    showBarsByReviewerAndProtein();
                    break;
                case "4":
                    isQuit = true;
                    System.out.println("<< Handle Saving Backup ... >>");
                    break;
                default:
                    Render.invalidInputMsg();
            }

        }
    }
//
//    private void showBarsWithSort() {
//        view.showAllSubMenu();
//        String input = view.getUserInput();
//
//        switch (input) {
//            case "1": // sort by protein
//                view.showAllBars(manager.sortByProtein());
//                break;
//            case "2": // Sort by fett
//                view.showAllBars(manager.sortByFett());
//                break;
//            case "3":
//                view.showName(manager.getProductNames());
//                break;
//            case "4":
//                view.showAllBars(manager.getListOfProducts());
//                break;
//            default:
//                view.errorMessage();
//        }
//    }
//
//

}
