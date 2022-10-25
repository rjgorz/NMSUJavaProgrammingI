/*
   OECS 195 JAVA Programming I
   Assigment Module #13
   Code Author: Robert Gorz
   Program Name: Configurator.java
        Loads an existing file from the WorkingDirectory
        and displays the current properties
        Modifies the credits property and updates to display
        the new credits value
*/

package com.java24hours;

import java.io.*;
import java.util.*;

public class StudentInfo {
    
    public StudentInfo() {
        try {
            // load the student.properties file and print properties
            File configFile = new File("student.properties");
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            config.list(System.out);
            System.out.println();
            
            // reference loaded in value of credits property and increase by 1
            String creditsProp = config.getProperty("credits");
            int credits = 0;
            try {
                credits = Integer.parseInt(creditsProp);
            } catch (NumberFormatException e) {
                // catches error and exits in case the value of credits is not a valid integer
                System.out.println("Error -- '" + creditsProp + "' is not a valid number of credits.");
                System.exit(0);
            }
            credits = ++credits;
            String creditsNew = Integer.toString(credits);
            
            // save new credits value, close the stream and print all properties again
            config.setProperty("credits", creditsNew);
            inStream.close();
            config.list(System.out);
            
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new StudentInfo();
    }
}