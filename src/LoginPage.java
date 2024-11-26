import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
//    JFrame loginFrame = new JFrame("Login");
public  LoginPage(){
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    // Email
    JLabel loginLabel = new JLabel("User Login");
    loginLabel.setBounds(220,30,150,30);
    add(loginLabel);
    // Email
    JLabel lEmail = new JLabel("Email:");
    lEmail.setBounds(50,80,100,30);
    add(lEmail);

    JTextField textEmail = new JTextField("Email");
    textEmail.setBounds(150,80,150,30);
    add(textEmail);

    // password
    JLabel lPassword = new JLabel("Password:");
    lPassword.setBounds(50,130,100,30);
    add(lPassword);

    JTextField textPassword = new JTextField("Password");
    textPassword.setBounds(150,130,150,30);
    add(textPassword);

    // login button
    JButton loginBtn = new JButton("Login");
    loginBtn.setBounds(150,180,100,30);
    add(loginBtn);

    loginBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = textEmail.getText();
            String password = textPassword.getText();
            DbConnection dbLogin = new DbConnection();

            if(dbLogin.loginUser(email,password)){
                new HomePage(dbLogin.getUserName(),dbLogin.getUserEmail(),dbLogin.getUserAge()).setVisible(true);
                dispose();
            }else {
                System.out.println("error to login");
                loginLabel.setText("Error to login Please try again!");
                loginLabel.setForeground(Color.RED);
            }


        }
    });

}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }



}
