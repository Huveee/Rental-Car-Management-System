package pagepack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import objectpack.Reservation;

class ResPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<String> list = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    ResPage(){
        super(jf,jp);
        list.setModel(model);
        Reservation.getReservationsHistory(model);


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
