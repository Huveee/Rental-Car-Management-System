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


class CarSelPage extends Page{
    private int i;
    private Location l;
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<Car> list = new JList<>();
    DefaultListModel<Car> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel brand =createLabel("", 215, 65, 110, 30,jp);
    JLabel carModel =createLabel("", 215, 95, 110, 30,jp);
    JLabel year =createLabel("", 215, 125, 110, 30,jp);
    JLabel color =createLabel("", 215, 155, 110, 30,jp);
    JLabel fuelCons =createLabel("", 215, 185, 250, 30,jp);
    JLabel rental =createLabel("", 215, 215, 330, 30,jp);
    JLabel location =createLabel("", 215, 245, 330, 30,jp);
    CarSelPage(Reservation res,Customer cus,int i, Location l){
        super(jf, jp);
        Color cl = new Color(6, 137, 119);
        this.i=i;
        this.l=l;
        Car ret = new Car(null, null, null, null, null, null, null, false, null);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        Car.getCarList(model,this.l);
        list.getSelectionModel().addListSelectionListener(e ->{
            Car c = list.getSelectedValue();
            brand.setText("Brand: "+c.getBrandName());
            carModel.setText("Model: "+c.getModelName());
            year.setText("Year: "+c.getYear());
            color.setText("Color: "+c.getColor());
            fuelCons.setText("Fuel Consumption(combined): "+c.getFuelConsumption()+" lt");
            rental.setText("The rental rate for this car is $"+ c.getDailyRentalRate()+" a day.");
            location.setText("This car is currently in "+c.getCurrentLocation());
            if(this.l.getLocationName()!=null || i==0){
                ret.setBrandName(c.getBrandName());
                ret.setModelName(c.getModelName());
                ret.setYear(c.getYear());
                ret.setColor(c.getColor());
                ret.setFuelConsumption(c.getFuelConsumption());
                ret.setDailyRentalRate(c.getDailyRentalRate());
                ret.setLicensePlate(c.getLicensePlate());    
                ret.setCurrentLocation(c.getCurrentLocation());
                ret.setIsReserved(c.getIsReserved());     
            }       
        });
        if(i==0){
            JButton selLoc = createButton("Select Location", 265, 325, 180, 40,jp);
            selLoc.setBackground(cl);
            selLoc.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    Reservation res=new Reservation(null,null,ret);
                    LocSelPage locPage = new LocSelPage(res,cus,1,ret);
                }
            });
        }
        else{
        	res.setCar(ret);
            l.setIsLocationAvailable(false);
            l.updateLocation();
            JButton slcLoc = createButton("Select Drop-Off Location", 245, 325, 220, 40, jp);
            slcLoc.setBackground(cl);
            slcLoc.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    DropOffLocPage dLocPage = new DropOffLocPage(res,cus,2,ret);
                }
            });
        }

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}