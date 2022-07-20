package ru.netology.javacore;

public class TypeTask {

    String type;
    String task;

    public TypeTask(String type, String task) {
        this.type = type;
        this.task = task;
    }

    @Override
    public String toString() {
        return "type = " + type + ", task = " + task;
    }
}
