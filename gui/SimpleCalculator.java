package gui;

import javax.swing.*;

public class SimpleCalculator {
    private JFrame frame;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultLabel = new JLabel("Result: ");

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        addButton.addActionListener(e -> calculate('+'));
        subtractButton.addActionListener(e -> calculate('-'));
        multiplyButton.addActionListener(e -> calculate('*'));
        divideButton.addActionListener(e -> calculate('/'));

        JPanel panel = new JPanel();
        panel.add(num1Field);
        panel.add(num2Field);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero");
                        return;
                    }
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}