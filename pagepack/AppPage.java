package pagepack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppPage implements PageInterface{
    private JPanel jp = new JPanel();
    private JFrame jf = new JFrame("Rent-A-Car");
    public AppPage(){
        
        jf.setSize(800,500);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);

        JButton rentCar = createButton("Rent A Car", 325, 125, 120, 30);
        jp.add(rentCar);

        rentCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                CarSelPage rentPage = new CarSelPage(0);
            }
        });

        JButton selLoc = createButton("Select Location", 325, 175, 120, 30);
        jp.add(selLoc);

        selLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                LocSelPage locPage = new LocSelPage(0);
            }
        });

        JButton delAcc = createButton("Delete Account", 325, 425, 120, 30);
        jp.add(delAcc);

        delAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //TODO:add account deletion here
                JOptionPane.showMessageDialog(null, "You have successfully deleted your account!");
                jf.dispose();
                LaunchPage launchPage = new LaunchPage();
            }
        });


        ImageIcon smallIcon = new ImageIcon("imgpack\\icon.jpg");
        jf.setIconImage(smallIcon.getImage());

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setResizable(false);
        jf.setVisible(true);
    }

    public JLabel createLabel(String text, int x, int y, int width, int height){
        JLabel newLabel = new JLabel(text);
        newLabel.setBounds(x,y,width,height);
        return newLabel;
    }

    public JTextField createField(int x, int y, int width, int height){
        JTextField newField = new JTextField();
        newField.setBounds(x,y,width,height);
        return newField;
    }

    public JButton createButton(String text, int x,int y,int width, int height){
        JButton newButton = new JButton(text);
        newButton.setBounds(x, y, width, height);
        return newButton;
    }
}
