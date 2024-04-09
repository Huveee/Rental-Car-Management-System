package pagepack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import objectpack.Customer;
import objectpack.Reservation;

class ReservationPage extends Page {
    
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");

    ReservationPage (Reservation res,Customer cus){
        super(jf,jp);

        createLabel("Car Brand-Model: "+res.getCar().getBrandName()+"-"+res.getCar().getModelName(), 285, 95, 240, 25, jp);
        createLabel("Pickup Date: "+res.getPickupDate(), 285, 125, 150, 25, jp);
        createLabel("Pickup Time: "+res.getPickupTime(), 285, 155, 150, 25, jp);  
        createLabel("Drop-Off Date: "+res.getDropOffDate(), 285, 185, 190, 25, jp);
        createLabel("Drop-Off Time: "+res.getDropOffTime(), 285, 215, 150, 25, jp);
        createLabel("Pickup Location: "+res.getPickupLocation().getLocationName()+", "+res.getPickupLocation().getAddress(), 285, 245, 380, 25, jp);
        createLabel("Drop-Off Location: "+res.getDropOffLocation().getLocationName()+", "+res.getDropOffLocation().getAddress(), 285, 275, 380, 25, jp);

        JButton makeRes = createButton("Make Reservation", 325, 325, 220, 45, jp);
        Color cl = new Color(6, 137, 119);
        makeRes.setBackground(cl);
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

