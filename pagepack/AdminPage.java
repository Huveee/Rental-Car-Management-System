package pagepack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPage {
    private JPanel jp = new JPanel();
    private JFrame jf = new JFrame("Rent-A-Car");

    public AdminPage(){
        jf.setSize(800,500);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);




        JButton carFleet = createButton("Manage Car Fleet", 150, 150, 130, 90);
        jp.add(carFleet);

        JButton reservationPanel = createButton("See reservations",300 , 150, 130, 90);
        jp.add(reservationPanel);



        ImageIcon smallIcon = new ImageIcon("imgpack\\icon.jpg");
        jf.setIconImage(smallIcon.getImage());

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setResizable(false);
        jf.setVisible(true);
    }

    private JButton createButton(String text, int x,int y,int width, int height){
        JButton newButton = new JButton(text);
        newButton.setBounds(x, y, width, height);
        return newButton;
    }
}
