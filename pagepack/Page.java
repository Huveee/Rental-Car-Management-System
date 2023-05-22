package pagepack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Page {

    public Page(JFrame jf, JPanel jp){
        jf.setSize(800,550);
        jf.setLocation(500,200);
        jf.add(jp);
        jp.setLayout(null);
        ImageIcon smallIcon = new ImageIcon("imgpack\\icon.jpg");
        jf.setIconImage(smallIcon.getImage());
    }
    
    JLabel createLabel(String text, int x, int y, int width, int height, JPanel jp){
        JLabel newLabel = new JLabel(text);
        newLabel.setBounds(x,y,width,height);
        jp.add(newLabel);
        return newLabel;
    }

    JTextField createField(int x, int y, int width, int height, JPanel jp){
        JTextField newField = new JTextField();
        newField.setBounds(x,y,width,height);
        jp.add(newField);
        return newField;
    }

    JButton createButton(String text, int x,int y,int width, int height, JPanel jp){
        JButton newButton = new JButton(text);
        newButton.setBounds(x, y, width, height);
        jp.add(newButton);
        return newButton;
    }

    JPasswordField createPasswordField(int x,int y,int width, int height, JPanel jp){
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(x,y,width,height);
        jp.add(passwordText);
        return passwordText;
    }
}
