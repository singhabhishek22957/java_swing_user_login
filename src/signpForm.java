import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class signpForm {
    public static void main(String[] args) {
        DbConnection dbUser = new DbConnection();
        JFrame frame = new JFrame("User Signup");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelTitle = new JLabel("Signup Form");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitle.setBounds(200, 20, 200, 30);
        frame.add(labelTitle);

        // name
        JLabel l_name = new JLabel("Name:");
        l_name.setBounds(50, 80, 100, 30);
        frame.add(l_name);

        JTextField textName = new JTextField();
        textName.setBounds(150, 80, 200, 30);
        frame.add(textName);
    // Email
        JLabel l_email = new JLabel("Email:");
        l_email.setBounds(50, 130, 100, 30);
        frame.add(l_email);

        JTextField textEmail = new JTextField();
        textEmail.setBounds(150, 130, 200, 30);
        frame.add(textEmail);

        // age
        JLabel l_age = new JLabel("Age:");
        l_age.setBounds(50, 180, 100, 30);
        frame.add(l_age);

        JTextField textAge = new JTextField();
        textAge.setBounds(150, 180, 200, 30);
        frame.add(textAge);

        // password
        JLabel l_password = new JLabel("Password:");
        l_password.setBounds(50, 230, 100, 30);
        frame.add(l_password);

        JTextField textPasword = new JTextField();
        textPasword.setBounds(150, 230, 200, 30);
        frame.add(textPasword);

        // confrompassword
        JLabel lCPassword = new JLabel("Confirm Password:");
        lCPassword.setBounds(50, 280, 130, 30);
        frame.add(lCPassword);

        JTextField c_password = new JTextField();
        c_password.setBounds(160, 280, 200, 30);
        frame.add(c_password);

        JButton submit_btn = new JButton("Signup");
        submit_btn.setBounds(220, 400, 80, 30);
        frame.add(submit_btn);

        JLabel status_text = new JLabel("");
        status_text.setBounds(220, 330, 400, 100);
        frame.add(status_text);


        submit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                int age = Integer.parseInt(textAge.getText());
                String email = textEmail.getText();
                String password =textPasword.getText();
                String confirmPassword = c_password.getText();


                if(Objects.equals(password, confirmPassword)){
                    if(dbUser.createUser(name,email,age,password)){
                        status_text.setText("User Create Successfully");
                        status_text.setForeground(Color.GREEN);
                        new LoginPage().setVisible(true);
//                        frame.dispose();
                    }else {
                        status_text.setText("Error to signup");
                        status_text.setForeground(Color.RED);
                    }
                }else {
                    status_text.setText("Password is not matched ");
                    status_text.setForeground(Color.RED);
                }
            }
        });


        frame.setVisible(true);



    }
}
