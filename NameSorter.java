/*
   OECS 195 JAVA Programming I
   Assigment Module #5
   Code Author: Robert Gorz
   ProgramName: NameSorter.java
        Displays the original order of
        names in the names[] array then
        sorts them to display an
        alphabetized list
*/

package com.java24hours;

import java.util.*;

class NameSorter {
    public static void main(String [] args) {
        String names [] = { "Glimmer", "Marvel", "Rue", "Clove",
            "Thresh", "FoxFace", "Cato", "Peeta", "Katniss" };
        System.out.println("The original order:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ": " + names [i]);
        }
        System.out.println();
        Arrays.sort(names);
        System.out.println("The new order:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ": " + names [i]);
        }
        System.out.println();
    }
}