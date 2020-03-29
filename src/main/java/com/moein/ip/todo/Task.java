package com.moein.ip.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Task {

    private static int nextId = 1;

    private final int id;
    private String title;
    private String project;
    private LocalDate deadline;
    private Boolean isDone = false;

    public Task(String title, String project, String deadline) {
        this.id = nextId++;
        this.title = title;
        this.project = project;
        this.deadline = LocalDate.parse(deadline);
    }


    public static ArrayList<Task> getSortedTasks(ArrayList<Task> tasks, TaskSortableBy sortBy){
        switch (sortBy){
            case title:
                return tasks.stream()
                        .sorted((t1, t2) -> t1.getTitle().compareTo(t2.getTitle()))
                        .collect(Collectors.toCollection(ArrayList::new));

            case project:
                return tasks.stream()
                        .sorted((t1, t2) -> t1.getProject().compareTo(t2.getProject()))
                        .collect(Collectors.toCollection(ArrayList::new));

            case deadline:
                return tasks.stream()
                        .sorted((t1, t2) -> t1.getDeadline().compareTo(t2.getDeadline()))
                        .collect(Collectors.toCollection(ArrayList::new));

            case isDone:
                return tasks.stream()
                        .sorted((t1, t2) -> t1.isDone().compareTo(t2.isDone()))
                        .collect(Collectors.toCollection(ArrayList::new));
        }
        return tasks;
    }

    public enum TaskSortableBy {
        title,
        project,
        deadline,
        isDone
    }

    public int getId() {
        return id;
    }

    void setNextId(int newNextId) {
        nextId = newNextId;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getProject() {
        return project;
    }

    void setProject(String project) {
        this.project = project;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Boolean isDone() {
        return isDone;
    }

    void setDone() {
        isDone = true;
    }

    void setUndone() {
        isDone = false;
    }

    void toggleStatus(){
        isDone = !isDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", project='" + project + '\'' +
                ", deadline=" + deadline +
                ", isDone=" + isDone +
                '}';
    }


}

