package pagepack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import objectpack.Reservation;

class ResPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<String> list = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel reserve = createLabel("", 215, 265, 180, 30, jp);
    ResPage(){
        super(jf,jp);
        jf.add(sp);
        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));      
        sp.setRightComponent(jp);
        Reservation.getReservationsHistory(model);
        list.getSelectionModel().addListSelectionListener(e ->{
            reserve.setText(list.getSelectedValue());
        });
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
