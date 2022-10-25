package com.java24hours;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class ColorFrameTimer extends JFrame {
    JButton red, green, blue;
    //assignment
    JButton yellow, flash;
    
    int flashControl = 0;
    
    
    public ColorFrameTimer() {
        super("ColorFrameTimer");
        
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
        
        
       Timer ftimer = new Timer(1000, null);
       ftimer.addActionListener(new ActionListener() {
       @Override
            public void actionPerformed(ActionEvent e) {
                switch (flashControl)
                {
                    case 4:
                        red.doClick();
                        break;
                    case 3:
                        green.doClick();
                        break;
                    case 2:
                        blue.doClick();
                        break;
                    case 1:
                        ColorFrameTimer.this.getContentPane().setBackground(Color.yellow);
                        break;
                    case 0:
                        ftimer.stop();
                }
                if (flashControl > 0)
                    --flashControl;
            }
        });
          
        // begin anonymous inner class
        ActionListener act; //inner class
        act = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

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
               if (event.getSource() == flash) {
                    if (flashControl == 0)
                    {
                        flashControl = 4;
                        ftimer.setRepeats(true);
                        ftimer.start();
                    }
                }
            } //listener
        };
        
        
        // end anonymous inner class
        red.addActionListener(act);
        green.addActionListener(act);
        blue.addActionListener(act);
        yellow.addActionListener(act);
        flash.addActionListener(act);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
        new ColorFrameTimer();
        
       
    }

}
