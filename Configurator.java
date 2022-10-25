/*
   OECS 195 JAVA Programming I
   Assigment Module #13
   Code Author: Robert Gorz
   Program Name: Configurator.java
        Loads an existing file from the WorkingDirectory
        Adds a new property and saves the file with the
        new content, prints properties to verify
*/

package com.java24hours;

import java.io.*;
import java.util.*;

public class Configurator {
    
    public Configurator() {
        try {
            // load the properties file from the WorkingDirectory
            File configFile = new File("program.properties");
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            
            // creates new runtime property
            Date current = new Date();
            config.setProperty("runtime", current.toString());
            
            // save the properties file with the new property
            FileOutputStream outStream = new FileOutputStream(configFile);
            config.store(outStream, "Properties settings");
            
            // close the stream and print all properties
            inStream.close();
            config.list(System.out);
            
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Configurator();
    }
}