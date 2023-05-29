package pagepack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objectpack.Customer;
import objectpack.Reservation;

class ReservationPage extends Page {
    
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");

    ReservationPage (Reservation res,Customer cus){
        super(jf,jp);

        createLabel("Car Model: "+res.getCar().getBrandName()+" "+res.getCar().getModelName(), 225, 115, 150, 25, jp);
        createLabel("Pickup Date: "+res.getPickupDate(), 225, 145, 150, 25, jp);
        createLabel("Pickup Time: "+res.getPickupTime(), 225, 175, 150, 25, jp);  
        createLabel("Drop-Off Date: "+res.getDropOffDate(), 225, 205, 150, 25, jp);
        createLabel("Drop-Off Time: "+res.getDropOffTime(), 225, 235, 150, 25, jp);
        createLabel("Pickup Location: "+res.getPickupLocation().getLocationName()+", "+res.getPickupLocation().getAddress(), 225, 265, 380, 25, jp);
        createLabel("Drop-Off Location: "+res.getDropOffLocation().getLocationName()+", "+res.getDropOffLocation().getAddress(), 225, 295, 380, 25, jp);

        JButton makeRes = createButton("Make Reservation", 315, 345, 135, 25, jp);
        makeRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                jf.dispose();
                PaymentPage paymentP = new PaymentPage(res,cus);
                
            }
            
        });
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}

