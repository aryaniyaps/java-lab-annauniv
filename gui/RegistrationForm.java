package gui;

public class RegistrationForm {
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Registration Form");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new java.awt.GridLayout(0, 2));

        // Name
        frame.add(new javax.swing.JLabel("Name:"));
        javax.swing.JTextField nameField = new javax.swing.JTextField();
        frame.add(nameField);

        // Email
        frame.add(new javax.swing.JLabel("Email:"));
        javax.swing.JTextField emailField = new javax.swing.JTextField();
        frame.add(emailField);

        // Phone
        frame.add(new javax.swing.JLabel("Phone:"));
        javax.swing.JTextField phoneField = new javax.swing.JTextField();
        frame.add(phoneField);

        // Gender
        frame.add(new javax.swing.JLabel("Gender:"));
        javax.swing.JPanel genderPanel = new javax.swing.JPanel();
        javax.swing.JRadioButton maleButton = new javax.swing.JRadioButton("Male");
        javax.swing.JRadioButton femaleButton = new javax.swing.JRadioButton("Female");
        javax.swing.ButtonGroup genderGroup = new javax.swing.ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);

        // Hobbies
        frame.add(new javax.swing.JLabel("Hobbies:"));
        javax.swing.JPanel hobbiesPanel = new javax.swing.JPanel();
        javax.swing.JCheckBox readingCheckBox = new javax.swing.JCheckBox("Reading");
        javax.swing.JCheckBox travelingCheckBox = new javax.swing.JCheckBox("Traveling");
        hobbiesPanel.add(readingCheckBox);
        hobbiesPanel.add(travelingCheckBox);
        frame.add(hobbiesPanel);

        // Country
        frame.add(new javax.swing.JLabel("Country:"));
        javax.swing.JComboBox<String> countryComboBox = new javax.swing.JComboBox<>(
                new String[] { "Select", "USA", "Canada", "UK" });
        frame.add(countryComboBox);

        // Submit Button
        javax.swing.JButton submitButton = new javax.swing.JButton("Submit");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            String hobbies = (readingCheckBox.isSelected() ? "Reading " : "")
                    + (travelingCheckBox.isSelected() ? "Traveling" : "");
            String country = (String) countryComboBox.getSelectedItem();

            javax.swing.JOptionPane.showMessageDialog(frame,
                    "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone +
                            "\nGender: " + gender + "\nHobbies: " + hobbies + "\nCountry: " + country);
        });
        frame.add(submitButton);

        frame.setVisible(true);
    }
}