import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
/**
 * @author 
 * @version 
 */
public class GUI
{
    
    public static Dimension createSize(int width, int height) {
        Dimension dim = new Dimension();
        dim.setSize(width, height);
        return dim;
    }
    
    // Bezugsobjekte

    // Attribute
    private JFrame frame;
    private JLabel title;
    private JTextField eingabeText;
    private JLabel ausgabeText;
    private JButton übernehmen;
    // Konstruktor
    public GUI()
    {
        this.frame = new JFrame();
        frame.setMinimumSize(createSize(500, 500));
        frame.setVisible(true);
        title = new JLabel();
        title.setText("Vokabeltrainer");
        title.setSize(50, 55);
        title.setLocation(frame.getWidth()/2, 100);
        title.setOpaque(true);
        title.setVisible(true);
        frame.add(title);
        ausgabeText = new JLabel();
        ausgabeText.setLocation(500, 500);
        ausgabeText.setSize(200, 20);
        ausgabeText.setVisible(false);
        ausgabeText.setOpaque(true);
        ausgabeText.setBackground(Color.white);
        ausgabeText.setForeground(Color.red);
        eingabeText = new JTextField("");
        eingabeText.setLocation(30, 60);
        eingabeText.setSize(20, 30);
        eingabeText.setVisible(true);
        eingabeText.setOpaque(true);
        frame.add(ausgabeText);
        frame.add(eingabeText);
        
        
    }

    // Dienste

}
