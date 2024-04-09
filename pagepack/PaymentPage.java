package pagepack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectpack.Customer;
import objectpack.Payment;
import objectpack.Reservation;

class PaymentPage extends Page {
    
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    
    PaymentPage(Reservation res,Customer cus){
        super(jf,jp);

        createLabel("Card No:", 265, 115,115,25, jp);
        JTextField cardNoField = createField(345,115,135,25, jp);
        createLabel("Expiration Date: ", 245, 145, 125, 25, jp);
        JTextField expDateField = createField(345, 145, 75, 25,jp);
        createLabel("CVV:", 295, 175, 85, 25, jp); 
        JTextField cvvField = createPasswordField(345, 175, 45, 25, jp);

        JButton makePay = createButton("Make Payment",295, 315, 145, 35, jp);
        Color cl = new Color(6, 137, 119);
        makePay.setBackground(cl);
        makePay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(cardNoField.getText()!=null && cvvField.getText()!=null && expDateField.getText()!=null ){
                
                    Payment newPay =new Payment(cardNoField.getText(), expDateField.getText(),cvvField.getText());

                    if(newPay.isAllFieldsValid(newPay)) {
                        JOptionPane.showMessageDialog(null, "Payment Successful");
                        jf.dispose();
                        newPay.setpaymentDate();
                        newPay.setpaymentTime();
                        newPay.setCustId(cus.getIdNumber());
                        newPay.setPaymentAmount(res.getCar().getDailyRentalRate());    
                        
                        res.setPayment(newPay);
                        res.setCustId(cus.getIdNumber());
                        
                        newPay.addToDocument();
                        res.addToDocument(res);
                        
                        LaunchPage launchP = new LaunchPage();                    	
                    }   
                    else if(!newPay.isCardNoValid(newPay))
                        JOptionPane.showMessageDialog(null, "Please enter a valid card number!(16 digits)");
                    else if(!newPay.isExpDateValid(newPay))
                        JOptionPane.showMessageDialog(null, "Please enter a valid expiration date!(Ex: 16/03)");
                    else if(!newPay.isCVVValid(newPay))
                        JOptionPane.showMessageDialog(null, "Please enter a valid CVV number!(3 digits)");  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please do not leave blank spaces!");
                }
            }    
        });
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
