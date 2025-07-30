package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeManagementSystem {
    private JFrame frame;
    private JTextField nameField, subject1Field, subject2Field, subject3Field;
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentGradeManagementSystem() {
        frame = new JFrame("Student Grade Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Subject 1 Marks:"));
        subject1Field = new JTextField();
        inputPanel.add(subject1Field);

        inputPanel.add(new JLabel("Subject 2 Marks:"));
        subject2Field = new JTextField();
        inputPanel.add(subject2Field);

        inputPanel.add(new JLabel("Subject 3 Marks:"));
        subject3Field = new JTextField();
        inputPanel.add(subject3Field);

        JButton calculateButton = new JButton("Calculate");
        inputPanel.add(calculateButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Table for displaying records
        String[] columnNames = { "Student Name", "Total Marks", "Average", "Grade" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Action Listener for Calculate Button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });

        frame.setVisible(true);
    }

    private void calculateGrades() {
        String name = nameField.getText();
        int marks1 = Integer.parseInt(subject1Field.getText());
        int marks2 = Integer.parseInt(subject2Field.getText());
        int marks3 = Integer.parseInt(subject3Field.getText());

        int totalMarks = marks1 + marks2 + marks3;
        double average = totalMarks / 3.0;
        String grade = calculateGrade(average);

        tableModel.addRow(new Object[] { name, totalMarks, average, grade });

        // Clear input fields
        nameField.setText("");
        subject1Field.setText("");
        subject2Field.setText("");
        subject3Field.setText("");
    }

    private String calculateGrade(double average) {
        if (average >= 90)
            return "A";
        else if (average >= 80)
            return "B";
        else if (average >= 70)
            return "C";
        else if (average >= 60)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGradeManagementSystem::new);
    }
}