package com.java24hours;

import java.awt.BorderLayout;
import javax.swing.*;

public class SalutonFrame extends JFrame {
    
    JButton north = new JButton("North");
    JButton east = new JButton("East");
    JButton south = new JButton("South");
    JButton west = new JButton("West");
    
    public SalutonFrame() {
        super("Robert Gorz");
        setLookAndFeel();
        setSize(450, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add(north, BorderLayout.NORTH);
        add(east, BorderLayout.EAST);
        add(south,BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public static void main(String[] arguments) {
        SalutonFrame frame = new SalutonFrame();
    }
}