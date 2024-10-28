/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mypoe;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JDialog;

/**
 *
 * @author RC_Student_lab
 */
public class MyPoe{
private static int taskCount = 0; // To keep track of the number of tasks
    private static ArrayList<String> tasks = new ArrayList<>(); // List to store task details
    public static void main(String[] args) {
     MyLogin login=new MyLogin();
    MyTask task = new MyTask();
   
     
    
     Scanner input = new Scanner(System.in);
        JDialog dialog = new JDialog();
        
        dialog.setAlwaysOnTop(true);
     
     System.out.print("Enter your name :");
     String name = input.next();
     System.out.print("Enter your lastname :");
     String lastname = input.next();
     System.out.print("Enter your username :");
     String username = input.next();
     System.out.print("Enter your password :");
     String password = input.next();
     
    System.out.print(login.registerUser(name, lastname, username, password)); 
    
    System.out.println("Enter your login username:");
    String user = input.next();
    System.out.println("Enter your login password :");
    String pass = input.next();
    
    boolean checkLogin = login.loginUser(user, pass);
    System.out.print(login.returnLoginStatus(checkLogin) );
    tester.displayWelcomeMessage();
    tester.showMainMenu();
    dialog.dispose();
     }    
}
