package pagepack;
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
    JLabel carName = createLabel("", 120, 55, 380, 30,jp);
    FleetPage(){
        super(jf, jp);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        Car.getCarList(model);

        JTextField addField = createField(170, 170, 380, 30, jp);
        JButton addCar = createButton("Add Car", 250, 200, 140, 30, jp);
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                String[] carAttr = addField.getText().split(",");
                Car c = new Car(carAttr[0], carAttr[1], carAttr[2], carAttr[3], carAttr[4], carAttr[5], carAttr[6], false, carAttr[7]);
                c.addToCSV();
            }
        });
        JButton removeCar = createButton("Remove Car", 250, 250, 140, 30, jp);
        JTextField updateField = createField(170, 360, 380, 30, jp);
        JButton updateCar = createButton("Update Car", 250, 400, 140, 30, jp);
        list.getSelectionModel().addListSelectionListener(e ->{
            Car c = list.getSelectedValue();
            carName.setText(c.getBrandName()+" "+c.getModelName()+" "+c.getYear()+" "+c.getColor()+" "+c.getFuelConsumption()+" "+c.getDailyRentalRate()+" "+c.getLicensePlate()+" "+c.getCurrentLocation());
            updateCar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    String[] carAttr = updateField.getText().split(",");
                    Car fieldCar = new Car(carAttr[0], carAttr[1], carAttr[2], carAttr[3], carAttr[4], carAttr[5], carAttr[6], false,carAttr[7]);
                    c.updateCar(fieldCar);
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
