/*
   OECS 195 JAVA Programming I
   Assigment Module #10
   Code Author: Robert Gorz
   ProgramName: KeyViewerButton.java
        Creates a UI output with key recognition
        and two buttons that change color/text as
        they are clicked
        Practice with using inner classes
*/

package com.java24hours;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyViewerButton extends JFrame {
    // creates buttons and text messages to be placed in the UI
    JTextField keyText = new JTextField(80);
    JLabel keyLabel = new JLabel("Press any key in the text field.");
    JButton myButton = new JButton("PressMe");
    JButton anotherButton = new JButton("PressMe2");
    
    public KeyViewerButton() {
        super("KeyViewerButton");
        // initializes UI settings
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyText.addKeyListener(new KeyAdapter() {
            // KeyListener recognizes input and displays message/changes appearance of both buttons
            public void keyTyped(KeyEvent input) {
                char key = input.getKeyChar();
                keyLabel.setText("You pressed " + key + " and cleared the buttons");
                myButton.setBackground(Color.blue);
                myButton.setText("PressMe");
                anotherButton.setBackground(Color.blue);
                anotherButton.setText("PressMe2");
            }
        });
        
        // details for button PressMe behavior when clicked
        myButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent bevent) {
              myButton.setBackground(Color.yellow);
              myButton.setText("CLICKED");
              keyLabel.setText("The original PressMe button was clicked");
              // modifies appearance of PressMe2
              anotherButton.setBackground(Color.green);
              anotherButton.setText("PressMe2");
          }      
    });
        // details for button PressMe2 behavior when clicked
        anotherButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent bevent) {
              anotherButton.setBackground(Color.red);
              anotherButton.setText("OUCH!");
              keyLabel.setText("You pressed the PressMe2 button");
              // modifies appearance of PressMe
              myButton.setBackground(Color.green);
              myButton.setText("PressMe");
          }      
    });
        
        // sets the layout of the UI, places buttons, text field and messages
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add(keyLabel, BorderLayout.NORTH);
        add(keyText, BorderLayout.CENTER);
        add(myButton,BorderLayout.SOUTH);
        add(anotherButton, BorderLayout.EAST);
        
        setVisible(true);
    }
    
    public static void main(String[] arguments) {
        new KeyViewerButton();
    }
}
