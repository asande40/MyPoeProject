/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class POE {

    public static void main(String[] args) {
     Login login=new Login();
    
     Scanner input = new Scanner(System.in);
     
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
    System.out.print(login.returnLoginStatus(login.loginUser(user, pass)));
    
    
   
}
   
    
}