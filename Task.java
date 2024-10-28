/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mypoe;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class MyTask {
     static int taskCount = 0; // Keeps track of the number of tasks
    static ArrayList<Task> tasks = new ArrayList<>(); // List to store tasks


  public void displayWelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKaban", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMainMenu() {
        while (true) {
            String choice = JOptionPane.showInputDialog(null, getMenuOptions(), "Select an Option", JOptionPane.QUESTION_MESSAGE);
            if (choice == null) break; // If cancel is clicked
            handleMenuChoice(choice);
        }
    }

    private static String getMenuOptions() {
        return "1. Add a Task\n2. Show Report\n3. Quit";
    }

    private static void handleMenuChoice(String choice) {
        switch (choice) {
            case "1":
                addTasks();
                break;
            case "2":
                showComingSoon();
                break;
            case "3":
                exitProgram();
                break;
            default:
                showErrorMessage("Invalid choice, please try again.");
        }
    }

    private static void addTasks() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to add?"));
        
        for (int i = 0; i < numberOfTasks; i++) {
            Task task = createTask();
            if (task != null) {
                tasks.add(task);
                taskCount++;
            } else {
                i--; // Decrement to retry this task
            }
        }

        displayTaskReport();
    }

    private static Task createTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String developerName = JOptionPane.showInputDialog("Enter Developer Name:");
        String surname = JOptionPane.showInputDialog("Enter Developer Surname:");
        int totalHours = Integer.parseInt(JOptionPane.showInputDialog("How many hours will you spend on this task?"));

        String taskId = generateTaskId(taskName, developerName);
        String taskStatus = getTaskStatus();
        String taskDescription = getTaskDescription();

        if (taskDescription != null) {
            return new Task(taskName, developerName, surname, taskDescription, taskId, taskStatus, totalHours, taskCount);
        }
        return null; // Return null if task description is invalid
    }

    private static String generateTaskId(String taskName, String developerName) {
        return taskName.substring(0, 2) + ":" + taskCount + ":" + developerName.substring(developerName.length() - 3);
    }

    private static String getTaskStatus() {
        String[] statuses = {"Doing", "To Do", "Done"};
        return (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status", 
                                   JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
    }

    private static String getTaskDescription() {
        String taskDescription = JOptionPane.showInputDialog("Task description (max 50 words):");
        if (taskDescription.split(" ").length > 50) {
            showErrorMessage("Description exceeds 50 words! Please try again.");
            return null; // Invalid description
        }
        return taskDescription; // Valid description
    }

    private static void displayTaskReport() {
        StringBuilder report = new StringBuilder("Tasks Added:\n");
        int totalHours = 0;
        for (Task task : tasks) {
            report.append(task.toString()).append("\n");
            totalHours += task.hours;
        }
        report.append("Total Hours: ").append(totalHours);
        JOptionPane.showMessageDialog(null, report.toString(), "Tasks Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showComingSoon() {
        JOptionPane.showMessageDialog(null, "Coming soon", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void exitProgram() {
        JOptionPane.showMessageDialog(null, "You have chosen to quit", "Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

class Task {
    String taskName;
    String developerName;
    String surname;
    String description;
    String taskId;
    String status;
    int hours;
    int taskNumber;

    Task(String taskName, String developerName, String surname, String description, String taskId, String status, int hours, int taskNumber) {
        this.taskName = taskName;
        this.developerName = developerName;
        this.surname = surname;
        this.description = description;
        this.taskId = taskId;
        this.status = status;
        this.hours = hours;
        this.taskNumber = taskNumber;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + "\n" +
               "Task Name: " + taskName + "\n" +
               "Developer: " + developerName + " " + surname + "\n" +
               "Description: " + description + "\n" +
               "Status: " + status + "\n" +
               "Hours: " + hours;
    }
}
