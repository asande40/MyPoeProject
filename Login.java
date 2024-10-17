/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String name,lname,username,Password,developerName,developerSurname;
     private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskDescriptions = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();
    
    public boolean Checkusername(String username){
        
      return username.contains("_") && username.length()<=5;
    }
    public boolean checkPasswordComplexity(String Password){
        String regex="^(?-.*[0-9]"+"(?.*{A-Z])"+"(?-.*[!~@#$%^&*():]).{8,}$";
        boolean flag=false;
        
        //This condition returns true if following conditions are met 
         if (Password.length()>8 && Password.matches(".*[A-Z].*")
            && Password.matches(".*[0-9].*") &&  Password.contains("@"  )||
         Password.contains("#")|| Password.contains("$")|| Password.contains("!")
        || Password.contains("%")|| Password.contains("&")|| Password.contains("*")|| Password.contains("+")
        || Password.contains("~")
        || Password.contains("_")){
             flag=true;
             }
         else{
            return flag;
            
        }
    return flag;
    }
    public String registerUser(String name,String lname,String username,String Password){
        
        if (!Checkusername(username)){
            return"Username not correctly informatted";
        }
        if (!checkPasswordComplexity(Password)){
            return "Password does not meet requirements";
        }
      this.name=name;
      this.lname=lname;
      this.username=username;
      this.Password=Password;
      return "Both username and password are correct"+"\n";
     }
    void print(){
        System.out.println(name+"\n"+lname+"\n"+username+"\n"+Password);
    }
    
    boolean loginUser(String username , String Password){
        return username.equals(this.username) && Password.equals(this.Password);
    }
    
    public String returnLoginStatus(boolean login){
        if (login){
            return " Welcome to KanBan ";
        }
        return "Username or Password is incorrect";
    }
    public void run() {
        collectDeveloperInfo();
        int taskCount = getTaskCount();
        collectTasks(taskCount);
        displayTaskSummary(taskCount);
    }  
    public void collectDeveloperInfo() {
        developerName = JOptionPane.showInputDialog(null, "Enter the developer's first name:");
        developerSurname = JOptionPane.showInputDialog(null, "Enter the developer's surname:");
    }
    public int getTaskCount() {
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
    
    
    public boolean isValidTaskDescription(String description) {
        return description != null && description.trim().split("\\s+").length <= 50;
    }
    
    
    
      public String generateTaskID(String taskName, int taskNumber) {
        return taskName.substring(0, 2).toUpperCase() + ":" + (taskNumber + 1) + ":" + developerName.substring(developerName.length() - 3).toUpperCase();
    }
      
      
       public String selectTaskStatus() {
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
    
       
       
    public void collectTasks(int taskCount) {
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
   public void storeTaskDetails(String taskName, String taskDescription, String taskID, String status) {
        taskNames.add(taskName);
        taskDescriptions.add(taskDescription);
        taskIDs.add(taskID);
        taskStatuses.add(status);
    }

   public void displayTaskSummary(int taskCount) {
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
