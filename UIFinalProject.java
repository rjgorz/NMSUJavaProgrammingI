/*
   OECS 195 JAVA Programming I
   Assigment Module #12
   Code Author: Robert Gorz
   ProgramName: UIFinalProject.java
        Creates UI with various components
            (check box, buttons, combo box, text field)
        and implements listeners to modify the UI
        based on user selections
        *DOES NOT INCLUDE THREAD FUNCTIONALITY YET*
*/

package com.java24hours;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIFinalProject extends JFrame implements ItemListener, ActionListener {
    // initialize UI components and set up rows
    JLabel r1 = new JLabel();
    JLabel r2 = new JLabel();
    JLabel r3 = new JLabel();
    JLabel r4 = new JLabel();
    JCheckBox chbx = new JCheckBox("Enable Thread Start", false);
    JLabel selectFunction = new JLabel("Select Function: ");
    JComboBox functions = new JComboBox();
    JButton start, pause, stop;
    JTextField text = new JTextField();
    
    public UIFinalProject() {
        // set up UI settings and initialize buttons
        super("RG - NMSU GUI Project");
        start = new JButton("Start Thread");
        pause = new JButton("Pause Thread");
        stop = new JButton("Stop Thread");
        pause.setBackground(Color.RED);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add listeners
        chbx.addItemListener(this);
        start.addActionListener(this);
        pause.addActionListener(this);
        stop.addActionListener(this);
        
        // set up layout parameters for overall grid and row specifics
        GridLayout grid1 = new GridLayout(4, 1);
        GridLayout grid2 = new GridLayout(1, 1);
        FlowLayout flo = new FlowLayout();
        setLayout(grid1);
        
        // set up row 1
        r1.setLayout(flo);
        r1.add(chbx, JCheckBox.CENTER);
        add(r1);
        
        // set up row 2
        r2.setLayout(flo);
        r2.add(selectFunction);
        // adds selections to ComboBox and disables editing
        functions.addItem("Time");
        functions.addItem("Alphabet");
        functions.addItem("Colors");
        functions.setEditable(false);
        r2.add(functions);
        add(r2);
        
        // set up row 3
        r3.setLayout(flo);
        r3.add(start);
        r3.add(pause);
        r3.add(stop);
        add(r3);
        
        // set up row 4
        r4.setLayout(grid2);
        text.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
        r4.add(text);
        add(r4);
        
        // initializes which components are enabled/disabled
        chbx.setEnabled(true);
        functions.setEnabled(true);
        start.setEnabled(false);
        pause.setEnabled(false);
        stop.setEnabled(false);
        
        setVisible(true);
    }

    // item listener for Check Box to enable/disable buttons
    @Override
    public void itemStateChanged(ItemEvent item) {
        int status = item.getStateChange();
        if (status == ItemEvent.SELECTED) {
            start.setEnabled(true);
        } else {
            start.setEnabled(false);
            pause.setEnabled(false);
            stop.setEnabled(false);
            text.setText(null);
        }
    }
    
    // action listener for buttons
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        // modifies UI when the start button is clicked
        if (command.equals("Start Thread")) {
            start.setBackground(Color.GREEN);
            start.setText("Running");
            start.setEnabled(false);
            pause.setEnabled(true);
            stop.setEnabled(true);
            stop.setBackground(Color.GRAY);
            functions.setEnabled(false);
            chbx.setEnabled(false);
        }
        // modifies UI when the pause button is clicked
        if (command.equals("Pause Thread")) {
            pause.setBackground(Color.YELLOW);
            pause.setText("Resume Thread");
        }
        // modifies UI when the resume button is clicked
        // only applicable once pause has been clicked
        if (command.equals("Resume Thread")) {
            pause.setBackground(Color.RED);
            pause.setText("Pause Thread");
        }
        // modifies UI when the stop button is clicked
        if (command.equals("Stop Thread")) {
            text.setText(null);
            start.setEnabled(true);
            start.setText("Start Thread");
            start.setBackground(Color.GRAY);
            chbx.setEnabled(true);
            functions.setEnabled(true);
            pause.setText("Pause Thread");
            pause.setBackground(Color.RED);
            pause.setEnabled(false);
        }
    }
       
    public static void main(String[] arguments) {
        UIFinalProject frame = new UIFinalProject();
    }
}