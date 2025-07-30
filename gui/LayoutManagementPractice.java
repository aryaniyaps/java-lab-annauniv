package gui;

import java.awt.*;
import javax.swing.*;

public class LayoutManagementPractice {
    public LayoutManagementPractice() {
        JFrame frame = new JFrame("Layout Management Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel borderPanel = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        JPanel flowPanel = new JPanel(new FlowLayout());

        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);

        gridPanel.add(new JButton("Button 1"));
        gridPanel.add(new JButton("Button 2"));
        gridPanel.add(new JButton("Button 3"));
        gridPanel.add(new JButton("Button 4"));

        flowPanel.add(new JButton("Flow 1"));
        flowPanel.add(new JButton("Flow 2"));
        flowPanel.add(new JButton("Flow 3"));

        frame.setLayout(new GridLayout(3, 1));
        frame.add(borderPanel);
        frame.add(gridPanel);
        frame.add(flowPanel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LayoutManagementPractice::new);
    }
}