/*
   OECS 195 JAVA Programming I
   Assigment Last Module
   Code Author: Robert Gorz
   ProgramName: shape1Student.java
        Creates a UI in which a user can click a button
        to draw a shape based on the selected shape, color
        and size
*/

package com.java24hours;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class shape1Student implements ActionListener {
    // initialize variables
    int choice = 0;
    int b = 0;
    String shape;
    String size;
    String color;
    
    // initialize UI components
    JButton drawButton = new JButton("DrawShape");
    JComboBox shapes = new JComboBox();
    JComboBox colors = new JComboBox();
    JComboBox sizes = new JComboBox();
    Drawing draw = new Drawing();
    
    // set up  and apply font for DrawShape button
    Font font = new Font("Book Antiqua", Font.BOLD + Font.ITALIC, 16);
    
    // custom color is a bluish purple
    Color Custom = new Color(0x66, 0x00, 0xFF);
   
    public shape1Student() {
        JFrame frame = new JFrame("RG Draw Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add listeners for button and combo boxes
        drawButton.addActionListener(this);
        shapes.addActionListener(this);
        colors.addActionListener(this);
        sizes.addActionListener(this);
        
        // add components to UI frame
        JPanel panel = new JPanel();
        drawButton.setFont(font);
        panel.add(drawButton);
      
        // add drop down options for shapes
        shapes.addItem("Square");
        shapes.addItem("Rectangle");
        shapes.addItem("Circle");
        shapes.addItem("Ellipse");
        panel.add(shapes);
        shapes.setEditable(false);
        
        // add drop down options for colors
        colors.addItem("Red");
        colors.addItem("Green");
        colors.addItem("Custom");
        panel.add(colors);
        colors.setEditable(false);
        
        // add drop down options for size
        sizes.addItem("Small");
        sizes.addItem("Medium");
        sizes.addItem("Large");
        panel.add(sizes);
        sizes.setEditable(false);
        
        frame.add(panel, "North");
        frame.add(draw);
        frame.setSize(625,500);
        frame.setVisible(true);
        // turns off shape visibility until button is pressed
        draw.setVisible(false);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // listener for button to set visible and redraw to new parameters
        if (e.getSource() == drawButton) {
            draw.setVisible(true);
            draw.repaint();
        }

        // listener for shape combo box, sets value for choice to be used in Drawing class
        shape = (String) shapes.getSelectedItem();
        if (shape == "Square") {
            choice = 1;
        } else if (shape == "Rectangle") {
            choice = 2;
        } else if (shape == "Circle") {
            choice = 3;
        } else if (shape == "Ellipse") {
            choice = 4;
        }
        
        // listeners for color and size combo boxes
        color = (String) colors.getSelectedItem();
        size = (String) sizes.getSelectedItem();
    }    
    
    
    class Drawing extends JComponent {
       
        public void paint(Graphics g2) {
            
            Graphics2D g = (Graphics2D) g2;
            
            // determines shape color based on result from listener
            if (color == "Red") {
                g.setColor(Color.RED);
            } else if (color == "Green") {
                g.setColor(Color.GREEN);
            } else if (color == "Custom") {
                g.setColor(Custom);
            }
            
            // determines shape size based on result from listener
            if (size == "Small") {
            b = 50;
            } else if (size == "Medium") {
            b = 150;
            } else if (size == "Large") {
            b = 250;
            }
            int[] sizes = {50, 100, b, b};
            
            // draws the selected shape based on result from listener
            if (choice == 1) {
                g.fillRect(sizes[0], sizes[1], sizes[2], sizes[3]);
            } else if (choice == 2) {
                g.fillRect(sizes[0], sizes[1], sizes[2] + b, sizes[3]);
            } else if (choice == 3) {
                Ellipse2D.Float myCircle = new Ellipse2D.Float(sizes[0], sizes[1], sizes[2], sizes[3]);
                g.fill(myCircle);
                g.draw(myCircle);
            } else if (choice == 4) {
                Ellipse2D.Float myEllipse = new Ellipse2D.Float(sizes[0], sizes[1], sizes[2] + b/2, sizes[3]);
                g.fill(myEllipse);
                g.draw(myEllipse);
            }
        }
    }
   
   public static void main(String[] args)
   {
      new shape1Student();
   }
}  