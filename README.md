# To-Do App

**Author:** GOKUL T

A simple command-line to-do list application written in Java 17. It lets you add tasks, view them, mark them as done and remove them, all from the terminal. Tasks are kept in memory while the program is running.

## Project Details

| Item | Details |
|------|---------|
| Project name | To-Do App |
| Author | GOKUL T |
| Language | Java 17 |
| Build tool | Maven (optional) |
| Type | Console (command-line) application |
| Dependencies | None (Java standard library only) |
| Main class | `com.example.todo.App` |
| Version | 1.0 |

## Features

- Add a new task with a description
- List all tasks with their status (`[ ]` pending, `[x]` done)
- Mark a task as completed
- Remove a task
- Built-in help and input validation for bad commands or task numbers

## Project Structure

```
todo-app/
├── pom.xml
├── README.md
└── src/main/java/com/example/todo/
    ├── App.java          (entry point, reads and handles user commands)
    ├── Task.java         (model class for a single task)
    └── TaskManager.java  (stores and manages the list of tasks)
```

## Class Overview

**`Task`**
Represents one to-do item. Holds an `id`, a `description` and a `done` flag. Provides `markDone()` and a `toString()` that prints the task like `[x] 1. Buy milk`.

**`TaskManager`**
Holds the list of tasks and generates unique ids. Methods:
- `add(String description)` creates and stores a new task
- `complete(int id)` marks a task as done, returns `false` if not found
- `remove(int id)` deletes a task, returns `false` if not found
- `all()` returns a read-only copy of all tasks

**`App`**
Contains the `main` method. Runs a loop that reads a command from the user, splits it into a command word and an argument, and calls the matching `TaskManager` method.

## Requirements

- JDK 17 or higher
- Maven 3.6+ (only if building with Maven)

## How to Run

### Option 1: With Maven

```
mvn package
java -jar target/todo-app-1.0.jar
```

### Option 2: Without Maven

```
mkdir out
javac -d out src/main/java/com/example/todo/*.java
java -cp out com.example.todo.App
```

## Commands

| Command | Description |
|---------|-------------|
| `add <text>` | Add a new task |
| `list` | Show all tasks |
| `done <id>` | Mark a task as completed |
| `remove <id>` | Delete a task |
| `help` | Show the list of commands |
| `quit` / `exit` | Close the program |

## Sample Session

```
=== To-Do List ===
Commands: add <text> | list | done <id> | remove <id> | help | quit
> add Buy milk
Added: [ ] 1. Buy milk
> add Finish assignment
Added: [ ] 2. Finish assignment
> done 1
Marked done.
> list
[x] 1. Buy milk
[ ] 2. Finish assignment
> remove 2
Removed.
> quit
Goodbye!
```

## Possible Improvements

- Save tasks to a file so they persist between runs
- Add due dates and priorities
- Add unit tests with JUnit

---

Created by **GOKUL T**
