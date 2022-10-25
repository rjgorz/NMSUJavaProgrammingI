/*
   OECS 195 JAVA Programming I
   Assigment Module #10
   Code Author: Robert Gorz
   ProgramName: NewColorFrame.java
        Creates a UI output with several buttons
        to change the background color of the window
        Practice with using inner classes
        Utilizes timers to cycle color backgrounds and
        make the buttons disappear and reappear
*/

package com.java24hours;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class NewColorFrame extends JFrame {
    JButton red, green, blue, yellow, flash, visible;
    
    int flashControl = 0;
    int visibleControl = 0;
    
    
    public NewColorFrame() {
        super("NewColorFrame");
        
        // initializes UI settings and creates buttons
        setSize(322, 122);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        red = new JButton("Red");
        add(red);
        green = new JButton("Green");
        add(green);
        blue = new JButton("Blue");
        add(blue);
        yellow = new JButton("Yellow");
        add(yellow);
        flash = new JButton("Flash");
        add(flash);
        visible = new JButton("Visible");
        add(visible);
        
        // timer to control "Flash" button
        // the "1000" value below sets the time interval to 1 second (aka 1000 ms) to switch colors
        Timer ftimer = new Timer(1000, null);
        ftimer.addActionListener(new ActionListener() {
        @Override
            // timer controller for flash, runs through the colors
            // ends when flashControl reaches a value of 0
            public void actionPerformed(ActionEvent e) {
                // switch loop to tell the timer which color is displayed
                // decreases the value of flashControl after each iteration until it reaches 0
                switch (flashControl) {
                    // cases 2-4 set the background color by executing a virtual "click" command on red/green/blue
                    case 4:
                        red.doClick();
                        break;
                    case 3:
                        green.doClick();
                        break;
                    case 2:
                        blue.doClick();
                        break;
                    // case 1 sets the background with hard coding, identical to how physically clicking the button would operate
                    case 1:
                        NewColorFrame.this.getContentPane().setBackground(Color.yellow);
                        break;
                    case 0:
                        ftimer.stop();
                }
                if (flashControl > 0)
                    --flashControl;
            }
        });
        
        Timer vtimer = new Timer(500, null);
        vtimer.addActionListener(new ActionListener() {
        @Override
            // timer controller for visible, makes the buttons disappear and reappear
            // ends when visibleControl reaches a value of 0
            public void actionPerformed(ActionEvent e) {
                // switch loop to tell the timer if the buttons should be visible or not
                // decreases the value of visibleControl after each iteration until it reaches 0
                switch (visibleControl) {
                    case 2:
                        NewColorFrame.this.getContentPane().setVisible(false);
                        break;
                    case 1:
                        NewColorFrame.this.getContentPane().setVisible(true);
                        break;
                    case 0:
                        vtimer.stop();
                }
                if (visibleControl > 0)
                    --visibleControl;
            }
        });

        // begin anonymous inner class
        ActionListener act; // inner class
        act = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // assigns a background color based on which color button is clicked
                if (event.getSource() == red) {
                    getContentPane().setBackground(Color.RED);
                }
                if (event.getSource() == green) {
                    getContentPane().setBackground(Color.GREEN);
                }
                if (event.getSource() == blue) {
                    getContentPane().setBackground(Color.BLUE);
                }
                if (event.getSource() == yellow) {
                    getContentPane().setBackground(Color.YELLOW);
                }
                // when the flash button is clicked, the ftimer is started 
                if (event.getSource() == flash) {
                    if (flashControl == 0) {
                        // initializes flashCounter for switch loop and tells the timer to repeat until stopped
                        flashControl = 4;
                        ftimer.setRepeats(true);
                        ftimer.start();
                    }
                }
                // when the visible button is clicked, the vtimer is started
                if (event.getSource() == visible) {
                    if (visibleControl == 0) {
                        // initializes visibleCounter for switch loop and tells the timer to repeat until stopped
                        visibleControl = 2;
                        vtimer.setRepeats(true);
                        vtimer.start();
                    }
                }
            } // listener
        };
        
        
        // end anonymous inner class
        red.addActionListener(act);
        green.addActionListener(act);
        blue.addActionListener(act);
        yellow.addActionListener(act);
        flash.addActionListener(act);
        visible.addActionListener(act);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
        new NewColorFrame();
    }
}