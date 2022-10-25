/*
   OECS 195 JAVA Programming I
   Assigment Module #7
   Code Author: Robert Gorz
   ProgramName: StringLister.java
        Initializes and adds names to an ArrayList
        Modifies the list to sort in alphabetical and
        reverse alphabetical orders and swaps name locations
*/

package com.java24hours;

import java.util.*;

// initializes a string array of pre-determined names
public class StringLister {
    String [] names = { "Carly", "Sam", "Kiki", "Lulu",
        "Hayden", "Elizabeth", "Kristina", "Molly", "Laura" };
    
    // creates an ArrayList in order to allow the addition of new names input as arguments
    public StringLister(String[] moreNames) {
        ArrayList<String> list = new ArrayList<String>();
        
        // loops to import initial names and input argument names to the ArrayList
        for (int i = 0; i < names.length; i++) {
            list.add(names[i]);
        }
        for (int i = 0; i < moreNames.length; i++) {
            list.add(moreNames[i]);
        }
        
        // sorts the list of names in alphabetical order (A to Z)
        Collections.sort(list);
        for (String name : list) {
            System.out.println(name);
        }
        System.out.println();
        
        // reorders the list of names into reverse alphabetical order (Z to A)
        Collections.reverse(list);
        for (String name : list) {
            System.out.println(name);
        }
        System.out.println();
        
        // swaps the position of elements 0 and 12 in the list (first and last)
        Collections.swap(list, 0, 12);
        for (String name : list) {
            System.out.println(name);
        }
        System.out.println();
        
    }
    public static void main(String[] arguments) {
        StringLister lister = new StringLister(arguments);
    }
}