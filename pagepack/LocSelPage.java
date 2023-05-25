package pagepack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import objectpack.Location;
import objectpack.Car;

class LocSelPage extends Page{
    private int i;
    private Car c;
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<Location> list = new JList<>();
    DefaultListModel<Location> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel location = createLabel("", 215, 65, 380, 30, jp);
    LocSelPage(int i, Car c){
        super(jf,jp);
        this.i =i;
        this.c = c;
        Location ret = new Location(null, null, null, false, null);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        Location.getLocList(model, this.c);
        list.getSelectionModel().addListSelectionListener(e ->{
            Location l = list.getSelectedValue();
            location.setText(l.getLocationName()+" "+l.getAddress()+" "+l.getIsLocationAvailable()+" "+l.getCar()+" "+l.getContactInformation());
            if(c.getCurrentLocation()!=null || i==0){
                ret.setAddress(l.getAddress());
                ret.setLocationName(l.getLocationName());
                ret.setContactInformation(l.getContactInformation());
                ret.setIsLocationAvailable(l.getIsLocationAvailable());
                ret.setCar(l.getCar());
            }
        });
        if(this.i==0){//indicates that we got to choose the location first
            JButton selCar = createButton("Select Car", 325, 265, 120, 30,jp);
            selCar.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    CarSelPage carPage = new CarSelPage(1,ret);
                }
            });
        }
        else{
            createLabel("Card No:", 295, 135, 85, 30, jp);

            JTextField cardField = createField(345, 135, 225, 30, jp);

            createLabel("Expiration Date:", 255, 175, 125, 30, jp);

            JTextField dateField = createField(345, 175, 75, 30,jp);

            createLabel("CVV:", 305, 215, 35, 30,jp);

            JPasswordField cvvText = createPasswordField(345,215,65,30,jp);
            
            JButton rentCar = createButton("Rent Car", 325, 265, 120, 30,jp);
            rentCar.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //Payment payment = new Payment(0, null, null)
                    JOptionPane.showMessageDialog(null, "You have successfully rented your car!");
                    jf.dispose();
                    AppPage appPage = new AppPage();
                }
            });
        }

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}