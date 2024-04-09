package pagepack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import objectpack.Location;
import objectpack.Reservation;
import objectpack.Car;
import objectpack.Customer;

class LocSelPage extends Page{
    private int i;
    private Car c;
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<Location> list = new JList<>();
    DefaultListModel<Location> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel fullAddress = createLabel("", 235, 105, 380, 30, jp);
    JLabel contact = createLabel("", 20, 467, 165, 25, jp);
    LocSelPage(Reservation res,Customer cus,int i, Car c){
        super(jf,jp);
        this.i =i;
        this.c = c;
        Color cl = new Color(6, 137, 119);
        Location ret = new Location(null, null, null, false);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        Location.getLocList(model, this.c,i);
        list.getSelectionModel().addListSelectionListener(e ->{
            Location l = list.getSelectedValue();
            fullAddress.setText("Address: "+l.getLocationName()+", "+l.getAddress());
            contact.setText("Contact Us: "+l.getContactInformation());
            if(c.getCurrentLocation()!=null || i==0){
                ret.setAddress(l.getAddress());
                ret.setLocationName(l.getLocationName());
                ret.setContactInformation(l.getContactInformation());
                ret.setIsLocationAvailable(l.getIsLocationAvailable());
            }
        });
        
        if(this.i==0){//indicates that we got to choose the location first
            JButton selCar = createButton("Select Car", 265, 265, 220, 45,jp);
            selCar.setBackground(cl);
            selCar.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    Reservation res=new Reservation(ret,null,null);
                    CarSelPage carPage = new CarSelPage(res,cus,1,ret);
                }
            });
        }
        else if(this.i==1){
            res.setPickupLocation(ret);
            JButton slcLoc = createButton("Select Drop-Off Location", 265, 265, 220, 45, jp);
            slcLoc.setBackground(cl);
            slcLoc.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    DropOffLocPage dLocPage = new DropOffLocPage(res,cus,2,c);
                }
            });
        }
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}