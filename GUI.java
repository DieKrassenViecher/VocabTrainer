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
    /** Fenster */
    private JFrame fenster;
    /** Anzeigeelement für den Ausgabetext */
    private JLabel ausgabeText;
    /** Anzeigeelement für den Eingabetext */
    private JTextField eingabeText;
    /** Knopf für die Textübernahme */
    private JButton übernehmen;
    
    /** Anzeigeelement für den Ausgabetext */
    private JLabel ausgabeText2;
    /** Anzeigeelement für den Eingabetext */
    private JTextField eingabeText2;
    /** Knopf für die Textübernahme */
    private JButton übernehmen2;
    
    private Vokabeln creating;
    
    // Konstruktor
    public GUI()
    {
        Vokabeln.loadWords();        
        fenster = new JFrame ("Vokabel Trainer");
        fenster.setSize (800, 600);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setLayout(null);
        
        JLabel title = new JLabel();
        title.setLocation(30, 0);
        title.setSize(200, 20);
        title.setVisible(true);
        title.setOpaque(true);
        title.setForeground(Color.black);
        title.setText("Vokabeln üben!");
        ausgabeText = new JLabel();
        ausgabeText.setLocation(30, 30);
        ausgabeText.setSize(200, 20);
        ausgabeText.setVisible(true);
        ausgabeText.setOpaque(true);
        ausgabeText.setBackground(Color.white);
        ausgabeText.setForeground(Color.black);
        ausgabeText.setText("Übersetze: " + Vokabeln.loadedWords.get(0).Deutschwort);
        eingabeText = new JTextField();
        eingabeText.setLocation(30, 60);
        eingabeText.setSize(200, 30);
        eingabeText.setVisible(true);
        eingabeText.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
               übernehmen.doClick();
           }
        });
        übernehmen = new JButton("Übernehmen?");
        übernehmen.setLocation(30, 100);
        übernehmen.setSize(200, 30);
        übernehmen.setVisible(true);
        übernehmen.setEnabled(true);
        übernehmen.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                if(übernehmen.getText().equals("Übernehmen?")) {
                    if(Vokabeln.loadedWords.get(0).Fremdwort.equalsIgnoreCase(eingabeText.getText())) {
                        ausgabeText.setText("Korrekt! :D");
                        ausgabeText.setForeground(Color.green);
                        übernehmen.setText("Weiter?");
                        eingabeText.setText("");
                    } else {
                        ausgabeText.setText("Leider Falsch: " + Vokabeln.loadedWords.get(0).Fremdwort);
                        ausgabeText.setForeground(Color.red);
                        übernehmen.setText("Weiter?");
                        eingabeText.setText("");
                    }
                } else if(übernehmen.getText().equals("Weiter?")) {
                    Vokabeln vok = Vokabeln.loadedWords.get(0);
                    Vokabeln.loadedWords.remove(0);
                    Vokabeln.loadedWords.add(vok);
                    ausgabeText.setText("Übersetze: " + Vokabeln.loadedWords.get(0).Deutschwort);
                    ausgabeText.setForeground(Color.black);
                    eingabeText.setText("");
                    übernehmen.setText("Übernehmen?");
                }
            }
        });
        
        JLabel title2 = new JLabel();
        title2.setLocation(400, 0);
        title2.setSize(200, 20);
        title2.setVisible(true);
        title2.setOpaque(true);
        title2.setForeground(Color.black);
        title2.setText("Neues Wort hinzufügen!");
        ausgabeText2 = new JLabel();
        ausgabeText2.setLocation(400, 30);
        ausgabeText2.setSize(200, 20);
        ausgabeText2.setVisible(true);
        ausgabeText2.setOpaque(true);
        ausgabeText2.setBackground(Color.white);
        ausgabeText2.setForeground(Color.black);
        ausgabeText2.setText("Gebe das Deutsche Wort ein");
        eingabeText2 = new JTextField();
        eingabeText2.setLocation(400, 60);
        eingabeText2.setSize(200, 30);
        eingabeText2.setVisible(true);
        eingabeText2.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
               übernehmen2.doClick();
           }
        });
        übernehmen2 = new JButton("Weiter?");
        übernehmen2.setLocation(400, 100);
        übernehmen2.setSize(200, 30);
        übernehmen2.setVisible(true);
        übernehmen2.setEnabled(true);
        übernehmen2.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                if(übernehmen2.getText().equals("Weiter?")) {
                    creating = new Vokabeln(eingabeText2.getText(), "");
                    ausgabeText2.setText("Gebe nun das Fremdwort für '" + eingabeText2.getText() + "' ein.");
                    eingabeText2.setText("");
                    übernehmen2.setText("Eintragen?");
                } else if(übernehmen2.getText().equals("Eintragen?")) {
                    creating.Fremdwort = eingabeText2.getText();
                    Vokabeln.addWord(creating);
                    ausgabeText2.setText("Erfolgreich. Gebe das Deutsche Wort ein");
                    übernehmen2.setText("Weiter?");
                    eingabeText2.setText("");
                    creating = null;
                }
            }
        });
        
        fenster.add(title);
        fenster.add(ausgabeText);
        fenster.add(eingabeText);
        fenster.add(übernehmen);
        fenster.add(title2);
        fenster.add(ausgabeText2);
        fenster.add(eingabeText2);
        fenster.add(übernehmen2);
        fenster.setVisible(true);
    }

    // Dienste

}
