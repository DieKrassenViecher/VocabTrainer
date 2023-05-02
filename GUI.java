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
    
    // Konstruktor
    public GUI()
    {
        this.frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(createSize(500, 500));
        frame.setVisible(true);
        title = new JLabel();
        title.setText("Vokabeltrainer");
        frame.add(title);
        while(true) {
            frame.requestFocusInWindow();
        }
    }

    // Dienste

}
