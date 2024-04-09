package pagepack;

import java.awt.Color;
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

class SignUpPage extends Page{
    
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");

    SignUpPage(){
        super(jf,jp);

        createLabel("Name Surname:",267, 115,105,25,jp);

        JTextField nameField = createField(375,115,105,25,jp);

        createLabel("Identification No:",265, 145,145,25,jp);

        JTextField idField = createField(375,145,105,25,jp);

        createLabel("Phone Number:",275,175,115,25,jp);

        JTextField phoneField = createField(375,175,85,25,jp);

        createLabel("Age:",345, 205,85,25,jp);
            
        JTextField ageField = createField(375,205,35,25,jp);

        createLabel("Email:",333,235,85,25,jp);

        JTextField mailField = createField(375,235,105,25,jp);

        createLabel("Password:",309,265,85,25,jp);

        JPasswordField passwordText = createPasswordField(375,265,105,25, jp);

        JButton createAcc = createButton("Create Account",325, 325, 135, 55,jp);
        Color cl = new Color(242, 181, 121);
        createAcc.setBackground(cl);

        createAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(nameField.getText()!=null && mailField.getText()!=null && ageField.getText()!=null && idField.getText()!=null && passwordText.getText()!=null && phoneField.getText()!=null){
                    Customer newCust = new Customer(nameField.getText(), mailField.getText() , passwordText.getText(),idField.getText() , Integer.parseInt(ageField.getText()) , phoneField.getText());
                    if(newCust.passwordValidation(newCust) && newCust.toDocument(newCust)){
                        JOptionPane.showMessageDialog(null, "You have successfully created an account!");
                        jf.dispose();
                        LaunchPage launchP = new LaunchPage();
                    }
                    else if(!newCust.userNameValidation(newCust))
                        JOptionPane.showMessageDialog(null, "Please enter a valid user name!(like John Marker)");
                    else if(!newCust.emailValidation(newCust))
                        JOptionPane.showMessageDialog(null, "Please enter a valid email!");
                    else if(!newCust.passwordValidation(newCust))
                        JOptionPane.showMessageDialog(null, "Please enter a valid password!");
                    else if(!newCust.idValidation(newCust))
                        JOptionPane.showMessageDialog(null, "Please enter a id!");
                    else if(!newCust.ageValidation(newCust))
                        JOptionPane.showMessageDialog(null, "Please enter a valid age! (This app is not for people under 18)");
                    else if(!newCust.phoneValidation(newCust))
                        JOptionPane.showMessageDialog(null, "Please enter a valid phone number!");
                    else if(!newCust.toDocument(newCust)){
                        JOptionPane.showMessageDialog(null, "There is already a user with this e-mail or Id Number! You are being redirected to the Log In page!");
                        jf.dispose();
                        LaunchPage launchP = new LaunchPage();
                    }
                }
                else{
                    System.out.println("Error");
                }
            }
            
        });

        JButton back = createButton(20, 465, 65, 25,jp,0);        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                LaunchPage launchPage = new LaunchPage();
            }
        });

        ImageIcon image = new ImageIcon("imgpack\\signupbg.png");
        JLabel imagLabel = new JLabel("",image,JLabel.CENTER);
        imagLabel.setBounds(11, -5, 910, 520);
        jp.add(imagLabel);


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}