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

class SignInPage extends Page{
    
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");

    SignInPage(){
        super(jf,jp);

        createLabel("Full Name:",265, 115,85,25,jp);

        JTextField nameField = createField(345,115,105,25,jp);

        createLabel("Identification No:",225, 145,105,25,jp);

        JTextField idField = createField(345,145,105,25,jp);

        createLabel("Phone Number:",245,175,115,25,jp);

        JTextField phoneField = createField(345,175,105,25,jp);

        createLabel("Date of Birth:",245, 205,85,25,jp);
            
        JTextField birthField = createField(345,205,105,25,jp);

        createLabel("Email",295,235,85,25,jp);

        JTextField mailField = createField(345,235,105,25,jp);

        createLabel("Password:",275,265,85,25,jp);

        JPasswordField passwordText = createPasswordField(345,265,105,25, jp);

        JButton createAcc = createButton("Create Account",315, 315, 135, 25,jp);

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
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
