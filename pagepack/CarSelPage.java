package pagepack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
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

import objectpack.Car;


class CarSelPage extends Page{
    private int i;
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<Car> list = new JList<>();
    DefaultListModel<Car> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel carName =createLabel("", 215, 65, 380, 30,jp);
    CarSelPage(int i){
        super(jf, jp);
        this.i=i;
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        Car.getCarList(model);
        list.getSelectionModel().addListSelectionListener(e ->{
            Car c = list.getSelectedValue();
            carName.setText(c.getBrandName()+" "+c.getModelName()+" "+c.getYear()+" "+c.getColor()+" "+c.getFuelConsumption()+" "+c.getDailyRentalRate()+" "+c.getLicensePlate()+" "+c.getCurrentLocation());
        });
        if(i==0){
            JButton selLoc = createButton("Select Location", 325, 265, 120, 30,jp);
            selLoc.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    LocSelPage locPage = new LocSelPage(1);
                }
            });
        }
        else{
            createLabel("Card No:", 295, 135, 85, 30,jp);
    
            JTextField cardField = createField(345, 135, 225, 30,jp);

            createLabel("Expiration Date:", 255, 175, 125, 30,jp);
    
            JTextField dateField = createField(345, 175, 75, 30,jp);
    
            createLabel("CVV:", 305, 215, 35, 30,jp);
    
            JPasswordField cvvText = createPasswordField(345,215,65,30,jp);
    
            JButton rentCar = createButton("Rent Car", 325, 265, 120, 30, jp);
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