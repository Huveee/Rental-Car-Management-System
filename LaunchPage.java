import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LaunchPage{
    private JPanel jp = new JPanel();
    private JFrame jf = new JFrame("Rent-A-Car");

    public LaunchPage(){

        jf.setSize(800,550);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);


        JLabel label1 = createLabel("Welcome, if you don't already have an account sign in first!", 215,105 , 395, 30);
        jp.add(label1);

        JLabel mailLabel = createLabel("Email:", 295, 175, 85, 30);
        jp.add(mailLabel);

        JTextField mailField = createField(345, 175, 85, 30);
        jp.add(mailField);

        JLabel passwordLabel = createLabel("Password:", 275, 235, 85, 30);
        jp.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(345,235,85,30);
        jp.add(passwordText);

        JButton signIn = new JButton("Sign In");
        signIn.setBounds(325, 425, 120, 30);
        jp.add(signIn);

        JButton logIn = new JButton("Log In");
        logIn.setBounds(325, 385, 120, 30);
        jp.add(logIn);
 
        ImageIcon image = new ImageIcon("carkeys.jpg");
        JLabel imagLabel = new JLabel("",image,JLabel.CENTER);
        imagLabel.setBounds(0, 0, 800, 500);
        jp.add(imagLabel);

        JLabel failedLogin = createLabel("", 215, 465, 380, 20);
        jp.add(failedLogin); 
        
        //When user presses Sign In button
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.print(userField.getText());
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
                System.out.println(mail+" "+password);
                if(mail.equals("Eray") && password.equals("1234")){
                    jf.dispose();
                    AppPage appPage = new AppPage();
                }
                else{
                    failedLogin.setText("The password and email address you have entered don't match!");
                }
            }
        });
        

        ImageIcon smallIcon = new ImageIcon("icon.jpg");
        jf.setIconImage(smallIcon.getImage());

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setResizable(false);
        jf.setVisible(true);
    }
    
    private JLabel createLabel(String text, int x, int y, int width, int height){
        JLabel newLabel = new JLabel(text);
        newLabel.setBounds(x,y,width,height);
        return newLabel;
    }

    private JTextField createField(int x, int y, int width, int height){
        JTextField newField = new JTextField();
        newField.setBounds(x,y,width,height);
        return newField;
    }
}