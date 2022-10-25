/*
   OECS 195 JAVA Programming I
   Assigment Module #11
   Code Author: Robert Gorz
   ProgramName: FreeSpaceFrame.java
        Builds UI to display computer host
        name and disk space information using
        FreeSpacePanel constructor
*/

package com.java24hours;

import javax.swing.*;

public class FreeSpaceFrame extends JFrame {
    public FreeSpaceFrame() {
        // set UI layout settings
        super("RG PC Name and Disk Free Space");
        setLookAndFeel();
        setSize(600, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // runs FreeSpacePanel
        FreeSpacePanel freePanel = new FreeSpacePanel();
        add(freePanel);
        setVisible(true);
    }
    
    // sets the UI graphical theme
    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel (
                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public static void main(String[] arguments) {
        FreeSpaceFrame frame = new FreeSpaceFrame();
    }
}