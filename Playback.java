/*
   OECS 195 JAVA Programming I
   Assigment Module #11
   Code Author: Robert Gorz
   ProgramName: Playback.java
        Creates a grid layout UI output
        Sets up several rows with different
        elements and spacing parameters
*/

package com.java24hours;

import javax.swing.*;
import java.awt.*;

public class Playback extends JFrame {
    
    // set up panels in row format to insert into the overall UI grid
    JPanel r1 = new JPanel();
    JPanel r2 = new JPanel();
    JPanel r3 = new JPanel();
    JPanel r4 = new JPanel();
    JPanel r5 = new JPanel();
    
    // initialize all UI components
    JCheckBox enable = new JCheckBox("Enable Buttons");
    JButton play, stop, pause;
    JLabel pageLabel = new JLabel("WEB Page Address: ", JLabel.CENTER);
    JTextField pageAddress = new JTextField(20);
        
    public Playback() {
        
        // initialize UI settings
        super("RG Playback");
        setLookAndFeel();
        
        play = new JButton("Play");
        stop = new JButton("Stop");
        pause = new JButton("Pause");
        
        setSize(450, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // set up colors for buttons and border
        play.setBackground(Color.GREEN);
        stop.setBackground(Color.RED);
        pause.setBackground(Color.YELLOW);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
        
        // set layout parameters for overall grid and each row
        GridLayout grid1 = new GridLayout(5, 3, 5, 5);
        GridLayout grid2 = new GridLayout(1, 3, 5, 5);
        setLayout(grid1);
        
        // set up row 1 components
        r1.setLayout(grid2);
        r1.add(new JLabel());
        r1.add(enable);
        r1.add(new JLabel());
        add(r1);
        
        // set up row 2 components
        r2.setLayout(grid2);
        r2.add(new JLabel());
        r2.add(play);
        r2.add(new JLabel());
        add(r2);
        
        // set up row 3 components
        r3.setLayout(grid2);
        r3.add(stop);
        r3.add(new JLabel());
        r3.add(pause);
        add(r3);
        
        // set up row 4 components
        r4.setLayout(grid2);
        r4.add(new JLabel());
        r4.add(pageLabel);
        r4.add(new JLabel());
        add(r4);
        
        // set up row 5 components
        r5.setLayout(grid2);
        r5.add(new JLabel());
        r5.add(pageAddress);
        r5.add(new JLabel());
        add(r5);
        
        setVisible(true);
    }
    
    // class to specify the UI visual theme
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    // main class to run the UI
    public static void main(String[] arguments) {
        Playback frame = new Playback();
    }
}