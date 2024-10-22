*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mypoe;

/**
 *
 * @author RC_Student_lab
 */
public class MyLogin {
      private String name,lname,username,Password,developerName,developerSurname;
    
    
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
      return "Both username and password are correcttly formatted "+"\n";
     }
    void print(){
        System.out.println(name+"\n"+lname+"\n"+username+"\n"+Password);
    }
    
    boolean loginUser(String username , String Password){
        return username.equals(this.username) && Password.equals(this.Password);
    }
    
    public String returnLoginStatus(boolean login){
      
        if (login){
            return "Welcome"+" "+ name +" "+lname+" "+"it is great to see you again";
            
        }
        return "Username or Password is incorrect";
    }
    
   
}

