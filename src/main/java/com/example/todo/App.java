package com.example.todo;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner in = new Scanner(System.in);

        System.out.println("=== To-Do List ===");
        printHelp();

        while (true) {
            System.out.print("> ");
            if (!in.hasNextLine()) break;
            String line = in.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "add" -> {
                    if (arg.isBlank()) System.out.println("Usage: add <description>");
                    else System.out.println("Added: " + manager.add(arg));
                }
                case "list" -> {
                    List<Task> tasks = manager.all();
                    if (tasks.isEmpty()) System.out.println("No tasks yet.");
                    else tasks.forEach(System.out::println);
                }
                case "done" -> handleId(arg, id ->
                        System.out.println(manager.complete(id) ? "Marked done." : "No such task."));
                case "remove" -> handleId(arg, id ->
                        System.out.println(manager.remove(id) ? "Removed." : "No such task."));
                case "help" -> printHelp();
                case "quit", "exit" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Unknown command. Type 'help'.");
            }
        }
    }

    private static void handleId(String arg, java.util.function.IntConsumer action) {
        try {
            action.accept(Integer.parseInt(arg.trim()));
        } catch (NumberFormatException e) {
            System.out.println("Please provide a task number.");
        }
    }

    private static void printHelp() {
        System.out.println("Commands: add <text> | list | done <id> | remove <id> | help | quit");
    }
}
