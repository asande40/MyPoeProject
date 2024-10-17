/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Task {
    private String developerName;
    private String developerSurname;
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskDescriptions = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    

   

    private void collectDeveloperInfo() {
        developerName = JOptionPane.showInputDialog(null, "Enter the developer's first name:");
        developerSurname = JOptionPane.showInputDialog(null, "Enter the developer's surname:");
    }

    private int getTaskCount() {
        String input = JOptionPane.showInputDialog(null, "How many tasks do you wish to add? (starting from 0):");
        int taskCount;
        try {
            taskCount = Integer.parseInt(input);
            if (taskCount < 0) {
                JOptionPane.showMessageDialog(null, "Please enter a non-negative number.");
                return 0; // Return 0 to exit the run method
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
            return 0; // Return 0 to exit the run method
        }
        return taskCount;
    }

    private void collectTasks(int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            String taskName = JOptionPane.showInputDialog(null, "Enter task name " + (i + 1) + ":");
            String taskDescription = JOptionPane.showInputDialog(null, "Enter task description (less than 50 words):");

            if (isValidTaskDescription(taskDescription)) {
                String taskID = generateTaskID(taskName, i);
                String status = selectTaskStatus();
                storeTaskDetails(taskName, taskDescription, taskID, status);
            } else {
                JOptionPane.showMessageDialog(null, "Task description must be less than 50 words. Please try again.");
                i--; // Decrement to repeat this task entry
            }
        }
    }

    private boolean isValidTaskDescription(String description) {
        return description != null && description.trim().split("\\s+").length <= 50;
    }

    private String generateTaskID(String taskName, int taskNumber) {
        return taskName.substring(0, 2).toUpperCase() + ":" + (taskNumber + 1) + ":" + developerName.substring(developerName.length() - 3).toUpperCase();
    }

    private String selectTaskStatus() {
        String[] statusOptions = {"Doing", "To Do", "Done"};
        int statusChoice = JOptionPane.showOptionDialog(
            null,
            "Select the status for the task:",
            "Task Status",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            statusOptions,
            statusOptions[0] // default option
        );
        return statusOptions[statusChoice];
    }

    private void storeTaskDetails(String taskName, String taskDescription, String taskID, String status) {
        taskNames.add(taskName);
        taskDescriptions.add(taskDescription);
        taskIDs.add(taskID);
        taskStatuses.add(status);
    }

    private void displayTaskSummary(int taskCount) {
        StringBuilder message = new StringBuilder("Task Summary:\n\n");
        message.append("Developer: ").append(developerName).append(" ").append(developerSurname).append("\n");
        message.append("Number of tasks: ").append(taskCount).append("\n\n");

        for (int i = 0; i < taskCount; i++) {
            message.append("Task Name: ").append(taskNames.get(i)).append("\n");
            message.append("Task Description: ").append(taskDescriptions.get(i)).append("\n");
            message.append("Task ID: ").append(taskIDs.get(i)).append("\n");
            message.append("Status: ").append(taskStatuses.get(i)).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, message.toString(), "Task Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
  
       

