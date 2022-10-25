/*
   OECS 195 JAVA Programming I
   Assigment Module #11
   Code Author: Robert Gorz
   ProgramName: FreeSpacePanel.java
        Constructs UI output to show local
        computer host name and disk space info
*/

package com.java24hours;

import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import static javax.swing.SwingConstants.*;

public class FreeSpacePanel extends JPanel {
    // initializes labels for computer name and disk space
    JLabel spaceLabel = new JLabel("Disc Space: ", JLabel.CENTER);
    JLabel nameLabel = new JLabel("Current Computer: ", JLabel.CENTER);
    JLabel space = new JLabel();
    JLabel name = new JLabel();

    public FreeSpacePanel() {
        // set grid layout for UI
        super();
        GridLayout grid1 = new GridLayout(2, 2);
        setLayout(grid1);
        
        // add labels to UI grid
        add(nameLabel);
        add(name);
        add(spaceLabel);
        add(space);
        
        // gets information for disk space
        try {
            setValue();
        } catch (IOException ioe) {
            space.setText("Error");
        }
        
        // gets information for computer name
        try {
            setName();
        } catch (UnknownHostException exc) {
            name.setText("Error");
        }
    }
    
    private final void setValue() throws IOException {
        // get the current file storage pool
        Path current = Paths.get("");
        FileStore store = Files.getFileStore(current);
        // find the free storage space
        long totalSpace = store.getTotalSpace();
        long freeSpace = store.getUsableSpace();
        // get this as a percentage (with two digits)
        double percent = (double)freeSpace / (double)totalSpace * 100;
        percent = (int)(percent * 100) / (double)100;
        // set the label's text
        space.setText(freeSpace + " free out of " + totalSpace + " ("
            + percent + "%)");
    }
    
    private final void setName() throws UnknownHostException {
        // get the current computer name
        java.net.InetAddress addr = InetAddress.getLocalHost();
        String hostName = addr.getHostName();
        // set the label's text
        name.setText(hostName);
    }
}