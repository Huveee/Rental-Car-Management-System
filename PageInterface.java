import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

interface PageInterface {
    
    JLabel createLabel(String text, int x, int y, int width, int height);

    JTextField createField(int x, int y, int width, int height);
    
    JButton createButton(String text, int x,int y,int width, int height);

}
