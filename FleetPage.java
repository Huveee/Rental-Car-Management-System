import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FleetPage {
    private JPanel jp = new JPanel();
    private JFrame jf = new JFrame("Rent-A-Car");
    public FleetPage(){
        
        jf.setSize(800,500);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);








        ImageIcon smallIcon = new ImageIcon("icon.jpg");
        jf.setIconImage(smallIcon.getImage());

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setResizable(false);
        jf.setVisible(true);
    }
}
