package pagepack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import objectpack.Reservation;

class ResHisPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<String> list = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel car =createLabel("", 175, 115, 150, 25,jp);
    JLabel pickDate =createLabel("", 175, 145, 250, 25,jp);
    JLabel pickTime =createLabel("", 175, 175, 250, 25,jp);
    JLabel dropDate =createLabel("", 175, 205, 250, 25,jp);
    JLabel dropTime =createLabel("", 175, 235, 250, 25,jp);
    JLabel pickLoc =createLabel("", 175, 265, 380, 25,jp);
    JLabel dropLoc =createLabel("", 175, 295, 380, 25,jp);
    JLabel cost =createLabel("", 175, 325, 380, 25,jp);
    JLabel id =createLabel("", 175, 355, 380, 25,jp);
    ResHisPage(String custId){
        super(jf,jp);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));      
        sp.setRightComponent(jp);
        Reservation.getReservationsHistory(model,custId);
        list.getSelectionModel().addListSelectionListener(e ->{
            String[] line = list.getSelectedValue().split(",");
            car.setText("Car Brand: "+line[7]);
            pickDate.setText("Pickup Date: "+line[1]);
            pickTime.setText("Pickup Time: "+line[3]);
            dropDate.setText("Drop-Off Date: "+line[2]);
            dropTime.setText("Drop-Off Time: "+line[4]);
            pickLoc.setText("Pickup Location: "+line[5]);
            dropLoc.setText("Drop-Off Location: "+line[6]);
            cost.setText("Cost: $"+line[8]);
            if(custId ==null){
                id.setText("Customer's Id: "+line[0]);
            }
        });
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
