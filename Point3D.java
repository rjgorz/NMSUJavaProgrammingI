/*
   OECS 195 JAVA Programming I
   Assigment Module #7
   Code Author: Robert Gorz
   ProgramName: Point3D.java
        Creates methods in order to initialize
        a point in 3D space and manipulate in
        all three dimensions
*/

package com.java24hours;

import java.awt.*;

public class Point3D extends Point {
    public int z;
    
    // method to create a 3D point
    public Point3D(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }
    
    // method to move a 3D point to a new coordinate
    public void move(int x, int y, int z) {
        this.z = z;
        super.move(x, y);
    }
    
    // method to translate a 3D point by defined values x/y/z
    public void translate(int x, int y, int z) {
        this.z += z;
        super.translate(x, y);
    }
    
    // method to translate new 3D point by defined values a1/a2/a3 using addition
    public void pAdd(int a1, int a2, int a3) {
        this.z += a3;
        super.translate(a1, a2);
    }
    
    // method to translate new 3D point by defined values a1/a2/a3 using subtraction
    public void pSubtract(int a1, int a2, int a3) {
        this.z -= a3;
        super.translate(-a1, -a2);
    }
}