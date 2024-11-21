/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mypoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class part3 {
    static List<String> developers = new ArrayList<>();
    static List<String> taskNames = new ArrayList<>();
    static List<String> taskIDs = new ArrayList<>();
    static List<Integer> taskDurations = new ArrayList<>();
    static List<String> taskStatuses = new ArrayList<>();
    static List<String> taskDescriptions = new ArrayList<>();
    static int taskCount = 0;

    public static void main(String[] args) {
      
    }

    // ================== Main Menu Methods =====================

    public void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKaban");
    }

     public int showMainMenu() {
        String choice = JOptionPane.showInputDialog(null, "Choose an option:\n1. Add a Task\n2. Show Report\n3. Quit");
        if (choice == null || choice.isEmpty()) return -1;
        return Integer.parseInt(choice);
    }

    public void showInvalidOptionMessage() {
        JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
    }

     public void quitProgram() {
        JOptionPane.showMessageDialog(null, "You have chosen to quit");
    }

    // ================== Task Handling Methods =====================

  public  void addTask() {
        int numTasks = getNumTasksToAdd();
        for (int i = 0; i < numTasks; i++) {
            taskCount++;
            // Collect Task Info
            String taskName = generateTaskName();
            String developerName = getDeveloperName();
            String developerSurname = getDeveloperSurname();
            int taskDuration = getTaskDuration();
            String taskStatus = getTaskStatus();
            String taskDescription = getTaskDescription();

            // Generate Task ID
            String taskID = generateTaskID(taskName, developerSurname);

            // Store Task Data
            storeTaskData(taskName, developerName + " " + developerSurname, taskID, taskDuration, taskStatus, taskDescription);

            // Display Task Summary
            displayTaskSummary(taskName, developerName, developerSurname, taskID, taskStatus, taskDuration, taskDescription);
        }
    }

     public int getNumTasksToAdd() {
        return Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));
    }

     public  String generateTaskName() {
        return "Task " + taskCount;
    }

     public String getDeveloperName() {
        return JOptionPane.showInputDialog("Enter the Developer's First Name:");
    }

    public String getDeveloperSurname() {
        return JOptionPane.showInputDialog("Enter the Developer's Last Name:");
    }

     public int getTaskDuration() {
        return Integer.parseInt(JOptionPane.showInputDialog("How many hours will this task take?"));
    }

     public  String getTaskStatus() {
        return (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Doing", "To Do", "Done"}, "To Do");
    }

    public  String getTaskDescription() {
        return JOptionPane.showInputDialog("Enter a description for the task (less than 50 words):");
    }

    public String generateTaskID(String taskName, String developerSurname) {
        return taskName.substring(0, 2) + ":" + taskCount + ":" + developerSurname.substring(developerSurname.length() - 3);
    }

     public  void storeTaskData(String taskName, String developerName, String taskID, int taskDuration, String taskStatus, String taskDescription) {
        taskNames.add(taskName);
        developers.add(developerName);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
        taskDescriptions.add(taskDescription);
    }

     public  void displayTaskSummary(String taskName, String developerName, String developerSurname, String taskID, String taskStatus, int taskDuration, String taskDescription) {
        JOptionPane.showMessageDialog(null, "Task Added:\n" +
                "Task ID: " + taskID + "\nTask Name: " + taskName + "\nDeveloper: " + developerName + " " + developerSurname +
                "\nStatus: " + taskStatus + "\nDuration: " + taskDuration + " hours\nDescription: " + taskDescription);
    }

    // ================== Report Menu Methods =====================

   public void showReportMenu() {
        String[] options = {
                "1. Populate Task Data Arrays",
                "2. Show Tasks with 'Done' Status",
                "3. Show Longest Duration Task",
                "4. Search Task by Name",
                "5. Search Tasks by Developer",
                "6. Delete a Task",
                "7. Show All Tasks"
        };

        int reportChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1. Populate Arrays\n2. Show Completed Tasks\n3. Longest Duration Task\n4. Search Task by Name\n5. Search Tasks by Developer\n6. Delete a Task\n7. Show All Tasks"));

        switch (reportChoice) {
            case 1:
                populateArrays();
                break;
            case 2:
                showCompletedTasks();
                break;
            case 3:
                showLongestDurationTask();
                break;
            case 4:
                searchTaskByName();
                break;
            case 5:
                searchTasksByDeveloper();
                break;
            case 6:
                deleteTask();
                break;
            case 7:
                showAllTasks();
                break;
            default:
                showInvalidOptionMessage();
                break;
        }
    }

     public void populateArrays() {
        StringBuilder result = new StringBuilder("Task Data Arrays:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            result.append("Task Name: ").append(taskNames.get(i))
                    .append("\nDeveloper: ").append(developers.get(i))
                    .append("\nTask ID: ").append(taskIDs.get(i))
                    .append("\nDuration: ").append(taskDurations.get(i))
                    .append("\nStatus: ").append(taskStatuses.get(i))
                    .append("\nDescription: ").append(taskDescriptions.get(i))
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

     public void showCompletedTasks() {
        StringBuilder result = new StringBuilder("Completed Tasks:\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equals("Done")) {
                result.append("Task Name: ").append(taskNames.get(i))
                        .append("\nDeveloper: ").append(developers.get(i))
                        .append("\nTask ID: ").append(taskIDs.get(i))
                        .append("\nDuration: ").append(taskDurations.get(i))
                        .append("\nStatus: ").append(taskStatuses.get(i))
                        .append("\nDescription: ").append(taskDescriptions.get(i))
                        .append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "No completed tasks found.");
    }

    public void showLongestDurationTask() {
        int maxDuration = 0;
        int maxIndex = -1;
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                maxIndex = i;
            }
        }
        if (maxIndex >= 0) {
            String result = "Longest Duration Task:\n" +
                    "Task Name: " + taskNames.get(maxIndex) +
                    "\nDeveloper: " + developers.get(maxIndex) +
                    "\nTask ID: " + taskIDs.get(maxIndex) +
                    "\nDuration: " + taskDurations.get(maxIndex) + " hours\n" +
                    "Status: " + taskStatuses.get(maxIndex);
            JOptionPane.showMessageDialog(null, result);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found.");
        }
    }

    public void searchTaskByName() {
        String searchName = JOptionPane.showInputDialog("Enter the Task Name to search [Eg Task 1]:");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(searchName)) {
                result.append("Task Name: ").append(taskNames.get(i))
                        .append("\nDeveloper: ").append(developers.get(i))
                        .append("\nTask ID: ").append(taskIDs.get(i))
                        .append("\nDuration: ").append(taskDurations.get(i))
                        .append("\nStatus: ").append(taskStatuses.get(i))
                        .append("\nDescription: ").append(taskDescriptions.get(i))
                        .append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "Task not found.");
    }

     public void searchTasksByDeveloper() {
        String developerSearch = JOptionPane.showInputDialog("Enter the Developer Name and Surname to search:");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerSearch)) {
                result.append("Task Name: ").append(taskNames.get(i))
                        .append("\nStatus: ").append(taskStatuses.get(i))
                        .append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "No tasks found for this developer.");
    }

    public void deleteTask() {
        String taskToDelete = JOptionPane.showInputDialog("Enter the Task Name to delete [Eg Task 1]:");
        boolean taskDeleted = false;
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskToDelete)) {
                taskNames.remove(i);
                developers.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                taskDescriptions.remove(i);
                taskDeleted = true;
                break;
            }
        }
        JOptionPane.showMessageDialog(null, taskDeleted ? "Task deleted successfully." : "Task not found.");
    }

     public void showAllTasks() {
        StringBuilder result = new StringBuilder("All Task Details:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            result.append("Task Name: ").append(taskNames.get(i))
                    .append("\nDeveloper: ").append(developers.get(i))
                    .append("\nTask ID: ").append(taskIDs.get(i))
                    .append("\nDuration: ").append(taskDurations.get(i))
                    .append("\nStatus: ").append(taskStatuses.get(i))
                    .append("\nDescription: ").append(taskDescriptions.get(i))
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

}
