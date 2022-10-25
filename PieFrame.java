/*
   OECS 195 JAVA Programming I
   Assigment Last Module
   Code Author: Robert Gorz
   ProgramName: PieFrame.java
        Uses PiePanel constructor to put
        together a pie chart based on a given
        set of data, uses custom colors
*/

package com.java24hours;

import javax.swing.*;
import java.awt.*;

public class PieFrame extends JFrame {
    // create custom colors
    Color bigRedDog = new Color(0xFF, 0x00, 0x00);
    Color coolCatBlue = new Color(0x66, 0xCC, 0xFF);
    Color parrotPurple = new Color(0x99, 0x33, 0xFF);
    Color highHorseGold = new Color(0xFF, 0xCC, 0x00);
    Color none = new Color(0x66, 0x66, 0x66);
    
    public PieFrame() {
        // initialize UI settings
        super("Companion Animals: Ownership by % of Households");
        setLookAndFeel();
        setSize(470, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create pie chart and add new slices
        PiePanel pie = new PiePanel(5);
        pie.addSlice(bigRedDog, (float) 38.4);
        pie.addSlice(coolCatBlue, (float) 25.4);
        pie.addSlice(parrotPurple, (float) 2.8);
        pie.addSlice(highHorseGold, (float) 0.7);
        pie.addSlice(none, (float) 32.7);
        add(pie);
        setVisible(true);
    }
    
    // look and feel method
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public static void main(String[] args) {
        PieFrame pf = new PieFrame();
    }
}