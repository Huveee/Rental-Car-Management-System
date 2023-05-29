package pagepack;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class AdminPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");

    AdminPage(){
        super(jf, jp);

        JButton carFleet = createButton("Manage Car Fleet", 85, 175, 350, 90, jp);
        Color cl = new Color(6, 137, 119);
        carFleet.setBackground(cl);
        
        carFleet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                FleetPage fleetPage = new FleetPage();
            }
        });
        
        JButton reservationPanel = createButton("See Reservations",500 , 175, 350, 90, jp);
        Color cl1 = new Color(242, 181, 121);
        reservationPanel.setBackground(cl1);
        reservationPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                ResHisPage resPage = new ResHisPage(null);
            }
        });

        JButton back = createBackButton(20, 465, 65, 25,jp);        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                LaunchPage launchPage = new LaunchPage();
            }
        });

        ImageIcon image = new ImageIcon("imgpack\\carsbg.jpg");
        JLabel imagLabel = new JLabel("",image,JLabel.CENTER);
        imagLabel.setBounds(11, -5, 910, 520);
        jp.add(imagLabel);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
