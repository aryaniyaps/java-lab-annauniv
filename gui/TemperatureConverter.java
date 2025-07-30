package gui;

public class TemperatureConverter {
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Temperature Converter");
        javax.swing.JPanel panel = new javax.swing.JPanel();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        javax.swing.JTextField inputField = new javax.swing.JTextField(10);
        javax.swing.JComboBox<String> conversionType = new javax.swing.JComboBox<>(
                new String[] { "Celsius to Fahrenheit", "Fahrenheit to Celsius" });
        javax.swing.JButton convertButton = new javax.swing.JButton("Convert");
        javax.swing.JLabel resultLabel = new javax.swing.JLabel("Result: ");

        convertButton.addActionListener(e -> {
            double inputValue = Double.parseDouble(inputField.getText());
            double result;
            if (conversionType.getSelectedItem().equals("Celsius to Fahrenheit")) {
                result = (inputValue * 9 / 5) + 32;
            } else {
                result = (inputValue - 32) * 5 / 9;
            }
            resultLabel.setText("Result: " + result);
        });

        panel.add(inputField);
        panel.add(conversionType);
        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}