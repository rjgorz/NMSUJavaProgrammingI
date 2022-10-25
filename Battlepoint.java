/*
   OECS 195 JAVA Programming I
   Assigment Module #7
   Code Author: Robert Gorz
   ProgramName: Battlepoint.java
        Gameplay of the Battlepoint method.
        Creates a map with defined targets and runs
        through iterations of taking shots. Displays
        to the player if it was a hit or miss and gives
        a final map with the results shown

*/

package com.java24hours;

import java.awt.*;
import java.util.*;

public class Battlepoint {
    // initializes ArrayLists for targets, misses and hits
    ArrayList<Point> targets = new ArrayList<>();
    ArrayList<Point> misses = new ArrayList<>();
    ArrayList<Point> hits = new ArrayList<>();
    
    public Battlepoint() {
        // create targets to shoot at
        createTargets();
        // display the game map
        showMap();
        // shoot at three points
        shoot(7,4);
        shoot(3,3);
        shoot(9,2);
        // display the game map again to show results
        showMap();
    }
    
    // method to create and show the game map
    public void showMap() {
        System.out.println("\n   1  2  3  4  5  6  7  8  9");
        for (int column = 1; column < 10; column++) {
            for (int row = 1; row < 10; row++) {
                if (row == 1) {
                    System.out.print(column + " ");
                }
                System.out.print(" ");
                Point cell = new Point(row,column);
                if (targets.indexOf(cell) > -1) {
                    // a target is at this position
                    System.out.print("X");
                } else if (misses.indexOf(cell) > -1) {
                    // a missed shot is taken at this position
                    System.out.print("M");
                } else if (hits.indexOf(cell) > -1) {
                    // a shot hits a target
                    System.out.print("H");
                } else {
                    // no target is here
                    System.out.print(".");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // method to create target points and add them to the targets list
    private void createTargets() {
        Point p1 = new Point(5,9);
        targets.add(p1);
        Point p2 = new Point(4,5);
        targets.add(p2);
        Point p3 = new Point(9,2);
        targets.add(p3);
    }
    
    // method for the player to take shots, prints if it is a hit or miss
    private void shoot(int x, int y) {
        Point shot = new Point(x,y);
        System.out.print("Firing at (" + x + "," + y + ") ... ");
        if (targets.indexOf(shot) > -1) {
            System.out.println("You sank my battlepoint!");
            // delete the destroyed target from targets list and adds the shot to the hit list
            targets.remove(shot);
            hits.add(shot);
            // displays when the target is missed and adds the shot to the miss list
        } else {
            System.out.println("miss.");
            misses.add(shot);
        }
    }
    
    public static void main(String[] args) {
        new Battlepoint();
    }
}