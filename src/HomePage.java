import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class HomePage extends JFrame {



    public  HomePage(String name , String email , int age){
        setTitle("Home Page of "+name);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Java Swing World dear "+name+",  your age is "+age+ " and email is "+email);
        welcomeLabel.setBounds(50,220,500,100);
        add(welcomeLabel);
        JButton btn = new JButton("Go to login page");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage().setVisible(true);
                disable();
            }
        });


    }


    // main method
//     SwingUtilities.invokeLater(() -> new Frame1().setVisible(true));



}
