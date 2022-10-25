/*
   OECS 195 JAVA Programming I
   Assigment Module #7
   Code Author: Robert Gorz
   ProgramName: PointTester.java
        Manipulates 2D and 3D point coordinates
        using defined points as well as points
        taken from input arguments. Pulls methods
        from class Point3D also created in this assignment
*/

package com.java24hours;

import java.awt.*;

class PointTester {
    public static void main(String[] args) {
        // converts input coordinates to int values
        int a = Integer.valueOf(args[0]);
        int b = Integer.valueOf(args[1]);
        int c = Integer.valueOf(args[2]);
        
        // initializes all point locations
        Point location1 = new Point(11,22);
        Point3D location2 = new Point3D(7,6,64);
        Point3D locationx = new Point3D(a,b,c);
        
        // performs a 2D point move and translation, prints original and new coordinates
        System.out.println("The 2D point is at {" + location1.x
            + ", " + location1.y + ")");
        System.out.println("It's being moved to (4, 13)");
        location1.move(4,13);
        System.out.println("The 2D point is now at (" + location1.x
            + ", " + location1.y + ")");
        System.out.println("It's being moved -10 units on both the x "
            + "and y axes");
        location1.translate(-10,-10);
        System.out.println("The 2D point ends up at (" + location1.x
            + ", " + location1.y + "}\n");
        
        // performs a 3D point move and translation, prints original and new coordinates
        System.out.println("The 3D point is at {" + location2.x
            + ", " + location2.y + ", " + location2.z + ")");
        System.out.println("It's being moved to (10, 22, 71)");
        location2.move(10,22,71);
        System.out.println("The 3D point is now at (" + location2.x
            + ", " + location2.y + ", " + location2.z + ")");
        System.out.println("It's being moved -20 units on the x, y "
                + "and z axes");
        location2.translate(-20,-20,-20);
        System.out.println("The 3D point ends up at (" + location2.x
            + ", " + location2.y + ", " + location2.z + ")\n");
        
        // prints location of new 3D point using input argument values
        System.out.println("A new 3D point has been created and is at (" + locationx.x
            + ", " + locationx.y + ", " + locationx.z + ") using the input arguments\n");
        
        // performs a 3D point translation with pAdd method, prints original and new coordinates
        System.out.println("Original 3D location before pAdd: (" + locationx.x
            + ", " + locationx.y + ", " + locationx.z + ")");
        locationx.pAdd(-1, 1, -1);
        System.out.println("Point location has been added to by (-1, 1, -1) and is now at (" + locationx.x
            + ", " + locationx.y + ", " + locationx.z + ")\n");
        
        // resets point to input argument coordinations
        locationx.move(a,b,c);
        
        // performs a 3D point translation with pSubtract method, prints original and new coordinates
        System.out.println("Original 3D location before pSubtract: (" + locationx.x
            + ", " + locationx.y + ", " + locationx.z + ")");
        locationx.pSubtract(-1, 1, -1);
        System.out.println("Point location has been subtracted from by (-1, 1, -1)"
            + " and is now at (" + locationx.x + ", " + locationx.y + ", "
            + locationx.z + ")");
    }
}