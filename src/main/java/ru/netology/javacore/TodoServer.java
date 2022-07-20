package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {

        System.out.println("Starting server at " + port + "...");
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String json = in.readLine();
                Gson gson = new Gson();
                TypeTask typeTask = gson.fromJson(json, TypeTask.class);
                switch (typeTask.type) {
                    case ("ADD"):
                        todos.addTask(typeTask.task);
                        break;
                    case ("REMOVE"):
                        todos.removeTask(typeTask.task);
                        break;
                }
                out.println(todos.getAllTasks());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}