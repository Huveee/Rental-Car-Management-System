package pagepack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectpack.Car;
import objectpack.Location;

class AppPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    AppPage(){
        super(jf,jp);
        JButton rentCar = createButton("Rent A Car", 325, 125, 120, 30, jp);
        rentCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                Location l = new Location(null, null, null, false, null);
                CarSelPage rentPage = new CarSelPage(0,l);
            }
        });

        JButton selLoc = createButton("Select Location", 325, 175, 120, 30, jp);
        selLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                Car c = new Car(null, null, null, null, null, null, null, false, null);
                LocSelPage locPage = new LocSelPage(0,c);
            }
        });

        JButton delAcc = createButton("Delete Account", 325, 425, 120, 30, jp);
        delAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //TODO:add account deletion here
                JOptionPane.showMessageDialog(null, "You have successfully deleted your account!");
                jf.dispose();
                LaunchPage launchPage = new LaunchPage();
            }
        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}