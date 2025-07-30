package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListApplication {
    private JFrame frame;
    private JTextField taskInput;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoListApplication() {
        frame = new JFrame("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        taskInput = new JTextField();
        frame.add(taskInput, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");
        JButton clearButton = new JButton("Clear Tasks");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskInput.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to remove.");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoListApplication();
            }
        });
    }
}