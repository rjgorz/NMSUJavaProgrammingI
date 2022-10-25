/*
   OECS 195 JAVA Programming I
   Assigment Last Module
   Code Author: Robert Gorz
   ProgramName: PiePanel.java
        Constructor class to build slices
        used to create a pie chart
*/

package com.java24hours;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class PiePanel extends JPanel {
    // initialize variables
    private PieSlice[] slice;
    private int current = 0;
    private float totalSize = 0;
    private Color background;
    
    // creates slice array and sets panel background color 
    public PiePanel(int sliceCount) {
        slice = new PieSlice[sliceCount];
        background = getBackground();
    }
    
    // adds a pie slice to the panel
    public void addSlice(Color sColor, float sSize) {
        if (current <= slice.length) {
            slice[current] = new PieSlice(sColor, sSize);
            totalSize += sSize;
            current++;
        }
    }
    
    // method to draw pie slices
    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        int width = getSize().width - 10;
        int height = getSize().height - 15;
        int xInset = 5;
        int yInset = 5;
        if (width < 5) {
            xInset = width;
        }
        if (height < 5) {
            yInset = height;
        }
        comp2D.setColor(background);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
        comp2D.setColor(Color.lightGray);
        Ellipse2D.Float pie = new Ellipse2D.Float(
            xInset, yInset, width, height);
        comp2D.fill(pie);
        
        // handles drawing the arcs of the slices
        float start = 0;
        for (int i = 0; i < slice.length; i++) {
            float extent = slice[i].size * 360F / totalSize;
            comp2D.setColor(slice[i].color);
            Arc2D.Float drawSlice = new Arc2D.Float(
                xInset, yInset, width, height, start, extent,
                Arc2D.Float.PIE);
            start += extent;
            comp2D.fill(drawSlice);
        }
    }
}

// specifies slice color and size
class PieSlice {
    Color color = Color.lightGray;
    float size = 0;
    
    PieSlice(Color pColor, float pSize) {
        color = pColor;
        size = pSize;
    }
}