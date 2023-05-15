package pagepack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import objectpack.Customer;

public class SignInPage {
    
    private JPanel jp = new JPanel();
    private JFrame jf = new JFrame("Sign in");

    public SignInPage(){

        jf.setSize(800,500);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(265, 115,85,25);
        jp.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(345,115,105,25);
        jp.add(nameField);

        JLabel idLabel = new JLabel("Identification No:");
        idLabel.setBounds(225, 145,105,25);
        jp.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(345,145,105,25);
        jp.add(idField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(245,175,115,25);
        jp.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(345,175,105,25);
        jp.add(phoneField);

        JLabel birthLabel = new JLabel("Date of Birth:");
        birthLabel.setBounds(245, 205,85,25);
        jp.add(birthLabel);
        
        JTextField birthField = new JTextField();
        birthField.setBounds(345,205,105,25);
        jp.add(birthField);

        JLabel mailLabel = new JLabel("Email:");
        mailLabel.setBounds(295,235,85,25);
        jp.add(mailLabel);

        JTextField mailField = new JTextField();
        mailField.setBounds(345,235,105,25);
        jp.add(mailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(275,265,85,25);
        jp.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(345,265,105,25);
        jp.add(passwordText);

        JButton createAcc = new JButton("Create Account");
        createAcc.setBounds(315, 315, 135, 25);
        jp.add(createAcc);

        createAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(nameField.getText()!=null && mailField.getText()!=null && birthField.getText()!=null && idField.getText()!=null && passwordText.getText()!=null && phoneField.getText()!=null){
                    Customer newCust = new Customer(nameField.getText(), mailField.getText() , passwordText.getText(), Integer.parseInt(idField.getText()) , Integer.parseInt(birthField.getText()) , Integer.parseInt(phoneField.getText()));
                    JOptionPane.showMessageDialog(null, "You have successfully created an account!");
                    jf.dispose();
                    LaunchPage launchP = new LaunchPage();
                }
                else{
                    System.out.println("Error");
                }
            }
            
        });


        ImageIcon smallIcon = new ImageIcon("imgpack\\icon.jpg");
        jf.setIconImage(smallIcon.getImage());
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setResizable(false);
        jf.setVisible(true);
    }
}
