package pagepack;

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


public class LaunchPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    public LaunchPage(){
        super(jf,jp);

        createLabel("Welcome, if you don't already have an account sign in first!", 215,105 , 395, 30,jp);

        createLabel("Email:", 295, 175, 85, 30,jp);

        JTextField mailField = createField(345, 175, 125, 30,jp);

        createLabel("Password:", 275, 235, 85, 30, jp);

        JPasswordField passwordText = createPasswordField(345,235,125,30, jp);

        JButton signIn = createButton("Sign In", 325, 425, 120, 30, jp);

        JButton logIn = createButton("Log In", 325, 385, 120, 30, jp);

        JLabel failedLogin = createLabel("", 215, 465, 380, 20, jp);
        
        //When user presses Sign In button
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                SignInPage signInPage = new SignInPage();
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
                try {
                    File accFile = new File("accounts.csv");
                    Scanner accScanner = new Scanner(accFile);
                    accScanner.nextLine();
                    while(accScanner.hasNext()) {
                        String accLine = accScanner.nextLine();
                        String[] accAttr = accLine.split(",");
                        if(mail.equals(accAttr[1]) && password.equals(accAttr[2])){
                            jf.dispose();
                            AppPage appPage = new AppPage();
                        }
                    }
                    accScanner.close();
                    failedLogin.setText("The password and email address you have entered don't match!");
                } 
                catch (FileNotFoundException t) {
                    System.out.println("An error occurred.");
                    t.printStackTrace();
                }
            }
        });

        ImageIcon image = new ImageIcon("imgpack\\carkeys.jpg");
        JLabel imagLabel = new JLabel("",image,JLabel.CENTER);
        imagLabel.setBounds(0, 0, 800, 500);
        jp.add(imagLabel);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}