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

import objectpack.Car;
import objectpack.Customer;
import objectpack.Location;

class AppPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    AppPage(Customer cus){
        super(jf,jp);

        JButton selCar = createButton("Select Car", 350, 115, 200, 45, jp);
        Color cl = new Color(6, 137, 119);
        selCar.setBackground(cl);
        selCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                Location l = new Location(null, null, null, false);
                CarSelPage carPage = new CarSelPage(null,cus,0,l);
            }
        });

        JButton selLoc = createButton("Select Location", 350, 175, 200, 45, jp);
        Color cl1 = new Color(242, 181, 121);
        selLoc.setBackground(cl1);
        selLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                Car c = new Car(null, null, null, null, null, null, null, false, null);
                LocSelPage locPage = new LocSelPage(null,cus,0,c);
            }
        });

        JButton history = createButton("Your Reservation History", 350, 235, 200, 45, jp);
        history.setBackground(cl);
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                ResHisPage resPage=  new ResHisPage(cus.getIdNumber());
            }
        });


        JButton delAcc = createButton("Delete Account", 350, 425, 200, 45, jp);
        delAcc.setBackground(cl1);
        delAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cus.deleteAccount();
                JOptionPane.showMessageDialog(null, "You have successfully deleted your account!");
                jf.dispose();
                LaunchPage launchPage = new LaunchPage();
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

        ImageIcon image = new ImageIcon("imgpack\\carsbg.jpg");
        JLabel imagLabel = new JLabel("",image,JLabel.CENTER);
        imagLabel.setBounds(12, 0, 910, 520);
        jp.add(imagLabel);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}