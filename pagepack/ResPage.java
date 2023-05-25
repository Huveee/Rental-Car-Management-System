package pagepack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import objectpack.Reservation;

class ResPage extends Page{
    static JPanel jp = new JPanel();
    static JFrame jf = new JFrame("Rent-A-Car");
    JList<String> list = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    JLabel reserve = createLabel("", 215, 65, 380, 30, jp);
    ResPage(){
        super(jf,jp);
        list.setModel(model);
        list.setBounds(100, 100, 200, 100);
        Reservation.getReservationsHistory(model);
        jp.add(list);

        list.getSelectionModel().addListSelectionListener(e ->{
            reserve.setText(list.getSelectedValue());
        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
