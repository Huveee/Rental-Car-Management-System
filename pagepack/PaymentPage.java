package pagepack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectpack.Customer;
import objectpack.Payment;
import objectpack.Reservation;

class PaymentPage extends Page {
    
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Make payment");
    

    PaymentPage(Reservation res,Customer cus){
        super(jf,jp);

        JLabel cardNoLabel = new JLabel("Card No:");
        cardNoLabel.setBounds(265, 115,85,25);
        jp.add(cardNoLabel);

        JTextField cardNoField = new JTextField();
        cardNoField.setBounds(345,115,115,25);
        jp.add(cardNoField);

        JLabel expDateLabel = new JLabel("Expiration Date:");
        expDateLabel.setBounds(225, 145, 105, 25);
        jp.add(expDateLabel);

        JTextField expDateField = new JTextField();
        expDateField.setBounds(345, 175, 115, 25);
        jp.add(expDateField);

        createLabel("CVV:", 265, 175, 85, 25, jp);
        
        JTextField cvvField = createPasswordField(345, 145, 115, 25, jp);


        JButton createAcc = new JButton("Make Payment");
        createAcc.setBounds(315, 315, 135, 25);
        jp.add(createAcc);

        createAcc.addActionListener(new ActionListener() {
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
                        
                        newPay.addToDocument(newPay);
                        res.addToDocument(res);
                        
                        LaunchPage launchP = new LaunchPage();                    	
                    }   
                    else if(!newPay.isCardNoValid(newPay))
                        JOptionPane.showMessageDialog(null, "Please enter a valid card number!(16 digits)");
                    else if(!newPay.isExpDateValid(newPay))
                        JOptionPane.showMessageDialog(null, "Please enter a valid expiration date!(Ex: 16/03)");
                    else if(!newPay.isCVCValid(newPay))
                        JOptionPane.showMessageDialog(null, "Please enter a valid CVV number!(3 digits)");
                
                }
                else{
                    System.out.println("Please do not leave blank spaces");

                }
            }
            
        });
        
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        
    }
}
