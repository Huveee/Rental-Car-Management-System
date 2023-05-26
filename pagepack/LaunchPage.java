package pagepack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import objectpack.Customer;


public class LaunchPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    public LaunchPage(){
        super(jf,jp);

        createLabel("Welcome, if you don't already have an account sign up first!", 145,85 , 405, 45,jp);;

        createLabel("Email:", 195, 145, 85, 30,jp);

        JTextField mailField = createField(195, 175, 165, 30,jp);

        createLabel("Password:", 195, 205, 85, 30, jp);

        JPasswordField passwordText = createPasswordField(195,235,125,30, jp);

        JButton logIn = createButton("Log In", 195, 315, 150, 45, jp);
        Color c1 = new Color(6, 137, 119);
        logIn.setBackground(c1);

        JButton signUp = createButton("Sign Up", 195, 375, 150, 45, jp);
        Color c = new Color(242, 181, 121);
        signUp.setBackground(c);
        

        JLabel failedLogin = createLabel("", 85, 465, 420, 20, jp);
        
        //When user presses Sign Up button
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                SignUpPage signUpPage = new SignUpPage();
            }
        });

        //When user presses Log In button
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String mail = mailField.getText();
                String password = passwordText.getText();
                if(mail.equals("admin@rentacar.com")&& password.equals("12345")){
                    jf.dispose();
                    AdminPage adminPage = new AdminPage();
                }
                else if(Customer.doCredentialsMatch(mail, password)){
                    jf.dispose();
                    AppPage appPage = new AppPage();
                }
                else{        
                    failedLogin.setText("The password and email address you have entered don't match!");
                }
            }
        });

        ImageIcon image = new ImageIcon("imgpack\\carkeys3.jpg");
        JLabel imagLabel = new JLabel("",image,JLabel.CENTER);
        imagLabel.setBounds(614, 0, 320, 510);
        imagLabel.setBorder(new LineBorder(Color.DARK_GRAY,12));
        jp.add(imagLabel);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}