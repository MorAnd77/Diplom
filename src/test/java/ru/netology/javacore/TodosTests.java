package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTests {

    @Test
    public void testAddTask() {
        Todos todos = new Todos();
        todos.addTask("Задудонить");
        boolean actual = todos.getAllTasks().contains("Задудонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testRemoveTask() {
        Todos todos = new Todos();
        todos.addTask("Пошалить");
        todos.removeTask("Пошалить");
        boolean actual = todos.getAllTasks().contains("Пошалить");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testGetAllTasks() {
        Todos todos = new Todos();
        String expected = "Задудонить" + " " + "Пошалить" + " " + "Пыхнуть" + " ";
        todos.addTask("Пошалить");
        todos.addTask("Пыхнуть");
        todos.addTask("Задудонить");
        Assertions.assertEquals(expected, todos.getAllTasks());
    }
}