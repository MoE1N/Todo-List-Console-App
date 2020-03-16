package com.moein.ip.todo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Task {
    private String title;
    private String project;
    private LocalDate deadline;
    private Boolean isDone = false;

    public Task(String title, String project, LocalDate deadline, Boolean isDone) {
        this.title = title;
        this.project = project;
        this.deadline = deadline;
        this.isDone = isDone;
    }

    public ArrayList<Task> getTasks(){

        return new ArrayList<Task>();
    }

    public ArrayList<Task> getSortedTasks(TaskSortableBy sortBy){

        return new ArrayList<Task>();
    }

    private enum TaskSortableBy {
        title,
        project,
        deadline,
        isDone
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }

    public void setUndone() {
        isDone = false;
    }

    @Override
    public String toString() {
        return "com.todo.Task{" +
                "title='" + title + '\'' +
                ", project='" + project + '\'' +
                ", deadline=" + deadline +
                ", isDone=" + isDone +
                '}';
    }


}

