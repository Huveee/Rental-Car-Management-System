package pagepack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        createLabel("Name Surname:",265, 115,85,25,jp);

        JTextField nameField = createField(345,115,105,25,jp);

        createLabel("Identification No:",225, 145,105,25,jp);

        JTextField idField = createField(345,145,105,25,jp);

        createLabel("Phone Number:",245,175,115,25,jp);

        JTextField phoneField = createField(345,175,105,25,jp);

        createLabel("Age:",245, 205,85,25,jp);
            
        JTextField ageField = createField(345,205,105,25,jp);

        createLabel("Email",295,235,85,25,jp);

        JTextField mailField = createField(345,235,105,25,jp);

        createLabel("Password:",275,265,85,25,jp);

        JPasswordField passwordText = createPasswordField(345,265,105,25, jp);

        JButton createAcc = createButton("Create Account",315, 315, 135, 25,jp);

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
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}