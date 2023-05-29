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

import objectpack.Car;
import objectpack.Customer;
import objectpack.Location;
import objectpack.Reservation;

public class DropOffLocPage extends Page {
	
    private int i;
    private Car c;
	
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Drop-Off Location");
    
    JList<Location> list = new JList<>();
    DefaultListModel<Location> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel fullAddress = createLabel("", 205, 105, 380, 30, jp);
    JLabel contact = createLabel("", 20, 467, 165, 25, jp);
	public DropOffLocPage(Reservation res,Customer cus,int i,Car c) {
		super(jf, jp);
		
        this.i =i;
        this.c = c;
        Color cl = new Color(6, 137, 119);
        Location ret = new Location(null, null, null, false);
        res.getPickupLocation().setIsLocationAvailable(false);
        res.getPickupLocation().updateLocation();
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
        
        
        res.setDropOffLocation(ret);
        JButton makeRes = createButton("Make Reservation", 325, 265, 120, 30,jp);
        makeRes.setBackground(cl);
        makeRes.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                res.getDropOffLocation().setIsLocationAvailable(false);
                res.getDropOffLocation().updateLocation();
                c.setIsReserved(true);
                c.updateCar();
                jf.dispose();
                ReservationPage resPage=new ReservationPage(res,cus);
            }
        });
        
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
	}
}
