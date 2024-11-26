import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class desktop {
    private JTextField textField1;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Swing Desktop App");

        // Set frame properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create and add components
        JLabel labelTitle = new JLabel("Login Form");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitle.setBounds(140, 20, 200, 30);
        frame.add(labelTitle);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(50, 80, 100, 30);
        frame.add(labelUsername);

        JTextField textUsername = new JTextField();
        textUsername.setBounds(150, 80, 200, 30);
        frame.add(textUsername);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(50, 130, 100, 30);
        frame.add(labelPassword);

        JPasswordField textPassword = new JPasswordField();
        textPassword.setBounds(150, 130, 200, 30);
        frame.add(textPassword);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 180, 80, 30);
        frame.add(loginButton);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(150, 220, 200, 30);
        frame.add(statusLabel);

        // Add action listener to the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textUsername.getText();
                String password = new String(textPassword.getPassword());
                if ("admin".equals(username) && "password".equals(password)) {
                    statusLabel.setText("Login Successful!");
                    statusLabel.setForeground(Color.GREEN);
                } else {
                    statusLabel.setText("Invalid Credentials");
                    statusLabel.setForeground(Color.RED);
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}

