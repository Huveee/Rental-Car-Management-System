package pagepack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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

import objectpack.Location;

public class LocSelPage {
    private int i;
    private JPanel jp = new JPanel();
    private JFrame jf = new JFrame("Rent-A-Car");
    JList<Location> list = new JList<>();
    DefaultListModel<Location> model = new DefaultListModel<>();
    JSplitPane sp =  new JSplitPane();
    JLabel location = createLabel("", 215, 65, 380, 30);
    public LocSelPage(int i){
        this.i =i;
        
        jf.setSize(800,500);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);
        jf.add(sp);

        list.setModel(model);
        sp.setLeftComponent(new JScrollPane(list));
        sp.setRightComponent(jp);
        jp.add(location);
        //TODO:a loop to read the file and add available locations to list
        model.addElement(new Location("Buca","Kzk Mh. 37/12.Sk",05324777003,true, null));
        list.getSelectionModel().addListSelectionListener(e ->{
            Location l = list.getSelectedValue();
            location.setText(l.getLocationName()+" "+l.getAddress()+" "+l.getIsLocationAvailable()+" "+l.getCar()+" "+l.getContactInformation());
        });

        if(this.i==0){//indicates that we got to choose the location first
            JButton selCar = createButton("Selet Car", 325, 265, 120, 30);
            jp.add(selCar);
            selCar.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    jf.dispose();
                    CarSelPage carPage = new CarSelPage(1);
                }
            });
        }
        else{
            JLabel cardNo = createLabel("Card No:", 295, 135, 85, 30);
            jp.add(cardNo);

            JTextField cardField = createField(345, 135, 225, 30);
            jp.add(cardField);

            JLabel exDate = createLabel("Expiration Date:", 255, 175, 125, 30);
            jp.add(exDate);

            JTextField dateField = createField(345, 175, 75, 30);
            jp.add(dateField);

            JLabel cvvLabel = createLabel("CVV:", 305, 215, 35, 30);
            jp.add(cvvLabel);

            JPasswordField cvvText = new JPasswordField();
            cvvText.setBounds(345,215,65,30);
            jp.add(cvvText);
            
            JButton rentCar = createButton("Rent Car", 325, 265, 120, 30);
            jp.add(rentCar);

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

        ImageIcon smallIcon = new ImageIcon("imgpack\\icon.jpg");
        jf.setIconImage(smallIcon.getImage());

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setResizable(false);
        jf.setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height){
        JLabel newLabel = new JLabel(text);
        newLabel.setBounds(x,y,width,height);
        return newLabel;
    }

    private JTextField createField(int x, int y, int width, int height){
        JTextField newField = new JTextField();
        newField.setBounds(x,y,width,height);
        return newField;
    }

    protected JButton createButton(String text, int x,int y,int width, int height){
        JButton newButton = new JButton(text);
        newButton.setBounds(x, y, width, height);
        return newButton;
    }
}