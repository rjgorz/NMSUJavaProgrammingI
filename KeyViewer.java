/*
   OECS 195 JAVA Programming I
   Assigment Module #12
   Code Author: Robert Gorz
   ProgramName: KeyViewer.java
        Builds UI that receives user input
        and can enable/disable input until checkbox
        is selected
        Modifies background color of text field
        based on which key is typed
*/

package com.java24hours;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyViewer extends JFrame implements KeyListener, ItemListener {
    // initialize UI components
    JTextField keyText = new JTextField(80);
    JLabel keyLabel = new JLabel("Press any key in the text field.");
    JCheckBox ckbx = new JCheckBox("Enable Color Change");
    
    public KeyViewer() {
        // sets up UI settings and layout, add components
        super("KeyViewer");
        setLookAndFeel();
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // listeners
        keyText.addKeyListener(this);
        ckbx.addItemListener(this);
        // initially sets text field as disabled and gray
        keyText.setEnabled(false);
        keyText.setBackground(Color.GRAY);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add(keyLabel, BorderLayout.NORTH);
        add(keyText, BorderLayout.CENTER);
        add(ckbx, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    // key text listener
    @Override
    public void keyTyped(KeyEvent input) {
        char key = input.getKeyChar();
        keyLabel.setText("You pressed " + key);
        switch (key) {
            // sets background color to yellow when x key is pressed
            case 'x':
            case 'X':
                keyText.setBackground(Color.YELLOW);
                break;
            // sets background color to blue when y key is pressed
            case 'y':
            case 'Y':
                keyText.setBackground(Color.BLUE);
                break;
            // sets background color to green when any other key is pressed
            default:
                keyText.setBackground(Color.GREEN);
                break;
        }
    }
    
    // key pressed listener
    @Override
    public void keyPressed(KeyEvent txt) {
        // do nothing
    }
    
    // key released listener
    @Override
    public void keyReleased(KeyEvent txt) {
        // do nothing
    }
    
    // item listener to monitor if the checkbox is selected or not
    @Override
    public void itemStateChanged(ItemEvent item) {
        int status = item.getStateChange();
        if (status == ItemEvent.SELECTED) {
            keyText.setEnabled(true);
            keyText.setBackground(Color.WHITE);
        } else {
            keyText.setEnabled(false);
            keyText.setBackground(Color.GRAY);
        }
    }
    
    // method to apply UI appearance
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public static void main(String[] arguments) {
        KeyViewer frame = new KeyViewer();
    }
}