package ru.netology.javacore;

import java.util.*;

public class Todos {

    private ArrayList<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public void removeTask(String task) {
        this.tasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(this.tasks);
        for (String task : this.tasks) {
            stringBuilder.append(task);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Todos{" +
                "Tasks=" + tasks +
                '}';
    }
}