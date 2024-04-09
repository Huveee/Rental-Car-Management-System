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
import javax.swing.JTextField;

import objectpack.Car;

class FleetPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<Car> list = new JList<>();
    DefaultListModel<Car> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel format = createLabel("Please type in with the given format(CSV).", 241, 20, 270, 15, jp);
    JLabel carName = createLabel("", 160, 135, 400, 30,jp);
    FleetPage(){
        super(jf, jp);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        Car.getCarList(model,null);
        
        JTextField addField = createField(170, 170, 380, 30, jp);
        JButton addCar = createButton("Add Car", 280, 210, 140, 30, jp);
        Color cl = new Color(6, 137, 119);
        addCar.setBackground(cl);
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                String[] carAttr = addField.getText().split(",");
                Car c = new Car(carAttr[0], carAttr[1], carAttr[2], carAttr[3], carAttr[4], carAttr[5], carAttr[6], false, carAttr[7]);
                c.addToCSV();
            }
        });
        JButton removeCar = createButton("Remove Car", 280, 270, 140, 30, jp);
        Color cl1 = new Color(242, 181, 121);
        removeCar.setBackground(cl1);
        JTextField updateField = createField(170, 360, 380, 30, jp);
        JButton updateCar = createButton("Update Car", 280, 400, 140, 30, jp);
        updateCar.setBackground(cl);
        list.getSelectionModel().addListSelectionListener(e ->{
            Car c = list.getSelectedValue();
            carName.setText("Selected Car: "+c.getBrandName()+","+c.getModelName()+","+c.getYear()+","+c.getColor()+","+c.getFuelConsumption()+","+c.getDailyRentalRate()+","+c.getLicensePlate()+","+c.getCurrentLocation());
            updateCar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    String[] carAttr = updateField.getText().split(",");
                    Car fieldCar = new Car(carAttr[0], carAttr[1], carAttr[2], carAttr[3], carAttr[4], carAttr[5], carAttr[6], false,carAttr[7]);
                    fieldCar.updateCar();
                }
            });
    
            removeCar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    c.removeCar();
                }
            });
        });



        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
