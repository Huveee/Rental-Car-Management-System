package pagepack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class AdminPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");

    AdminPage(){
        super(jf, jp);


        JButton carFleet = createButton("Manage Car Fleet", 150, 150, 130, 90, jp);
        carFleet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                FleetPage fleetPage = new FleetPage();
            }
        });

        JButton reservationPanel = createButton("See Reservations",300 , 150, 130, 90, jp);
        reservationPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                ResPage resPage = new ResPage();
            }
        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
