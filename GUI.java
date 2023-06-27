import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
/**
 * @author Thore, Tommy
 * @version 1.0
 */
public class GUI
{
    /**
     * Fenster in form eines JFrame
     */
    private JFrame fenster;
    /**
     * Zeigt die Infos zum Vokabeln üben
     */
    private JLabel ausgabeText;
    /**
     * Eingabefeld zum Vokabeln üben
     */
    private JTextField eingabeText;
    /**
     * Knopf zum bestätigen der Eingabe beim Vokabeln üben
     */
    private JButton übernehmen;
    
    /**
     * Zeigt die Infos zum Vokabeln hinzufügen
     */
    private JLabel ausgabeText2;
    /**
     * Eingabefeld zum Vokabeln hinzufügen
     */
    private JTextField eingabeText2;
    /**
     * Knopf zum bestätigen der Eingabe beim Vokabeln hinzufügen
     */
    private JButton übernehmen2;
    
    /**
     * Attribut zur erstellung neuer Vokabeln
     */
    private Vokabeln creating;
    
    /**
     * Start des Programms, sobald ein Objekt der Klasse GUI erstellt wird
     */
    public GUI()
    {
        /**
         * Zuerst werden alle Vokabeln aus der Datei vokabeln.txt geladen
         */
        Vokabeln.loadWords();
        /**
         * JFrame Objekt erstellen mit dem String Parameter als Titel.
         * 
         * Außerdem wird die Größe des Fensters angepasst, der LayoutManager wird entfernt, 
         * sodass man die Methode setLocation nutzen kann.
         * 
         * Die DefaultCloseOperation wird auf EXIT_ON_CLOSE gesetzt, sodass das Programm stoppt
         * sobald man das Fenster schließt
         */
        fenster = new JFrame ("Vokabel Trainer");
        fenster.setSize (800, 600);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setLayout(null);
        
        /**
         * Die Felder zum Vokabeln üben werden Initialisiert, die Location wird gesetzt
         * und stilistische anpassungen gemacht.
         */
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
        /**
         * Es wird das erste Vokabeln Objekt aus der Liste mit gecachten Vokabeln genommen.
         */
        ausgabeText.setText("Übersetze: " + Vokabeln.loadedWords.get(0).Deutschwort);
        eingabeText = new JTextField();
        eingabeText.setLocation(30, 60);
        eingabeText.setSize(200, 30);
        eingabeText.setVisible(true);
        /**
         * Der ActionListener wird ausgeführt, wenn das TextFeld fokussiert ist
         * und man dann die ENTER Taste drückt.
         */
        eingabeText.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
               /**
                * Anschließend wird die Methode JButton#doClick um einen Knopfdruck zu imitieren.
                */
               übernehmen.doClick();
           }
        });
        übernehmen = new JButton("Übernehmen?");
        übernehmen.setLocation(30, 100);
        übernehmen.setSize(200, 30);
        übernehmen.setVisible(true);
        übernehmen.setEnabled(true);
        /**
         * Der ActionListener des JButton wird ausgeführt sobald man
         * den Knopf drückt oder einen Knopfdruck mit JButton#doClick imitiert.
         */
        übernehmen.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                /**
                 * Zuerst wird überprüft ob bereits ein Vokabel eingegeben wurde
                 * oder nicht.
                 */
                if(übernehmen.getText().equals("Übernehmen?")) /* Die Eingabe muss überprüft werden */ {
                    /**
                     * Es wird überprüft ob der Eingegebene Text mit dem Fremdwort des ersten Vokabel
                     * der gecachten Vokabeln übereinstimmt.
                     */
                    if(Vokabeln.loadedWords.get(0).Fremdwort.equalsIgnoreCase(eingabeText.getText())) /* Eingabe ist korrekt */ {
                        /**
                         * Das InfoFeld zeigt an dass die Eingabe korrekt ist und der
                         * Knopf wechselt zum Text Weiter?.
                         */
                        ausgabeText.setText("Korrekt! :D");
                        ausgabeText.setForeground(Color.green);
                        übernehmen.setText("Weiter?");
                        /**
                         * Außerdem wird das Eingabe Feld geleert, damit man das nicht
                         * selbst tun muss.
                         */
                        eingabeText.setText("");
                    } else /* Eingabe ist nicht korrekt */ {
                        /**
                         * Das InfoFeld zeigt an dass die Eingabe falsch ist und der
                         * Knopf wechselt zum Text Weiter?.
                         */
                        ausgabeText.setText("Leider Falsch: " + Vokabeln.loadedWords.get(0).Fremdwort);
                        ausgabeText.setForeground(Color.red);
                        übernehmen.setText("Weiter?");
                        /**
                         * Außerdem wird das Eingabe Feld geleert, damit man das nicht
                         * selbst tun muss.
                         */
                        eingabeText.setText("");
                    }
                } else if(übernehmen.getText().equals("Weiter?")) /* Das nächste Vokabel muss abgefragt werden */ {
                    /**
                     * Das aktuelle Vokabel wird im Wert vok zwischengespeichert.
                     */
                    final Vokabeln vok = Vokabeln.loadedWords.get(0);
                    /**
                     * Anschließend wird das aktuelle Vokabel aus der Liste der
                     * gecachten Vokabeln entfernt, sodass der Index aller anderen
                     * um 1 absteigt.
                     */
                    Vokabeln.loadedWords.remove(0);
                    /**
                     * Dann wird das Zwischengespeicherte Vokabel als letztes in der Liste
                     * hinzugefügt.
                     */
                    Vokabeln.loadedWords.add(vok);
                    /**
                     * Der Infotext wird angepasst, dass das neue erste Wort angezeigt wird
                     */
                    ausgabeText.setText("Übersetze: " + Vokabeln.loadedWords.get(0).Deutschwort);
                    ausgabeText.setForeground(Color.black);
                    eingabeText.setText("");
                    übernehmen.setText("Übernehmen?");
                }
            }
        });
        
        /**
         * Die Felder zum Vokabeln üben werden Initialisiert, die Location wird gesetzt
         * und stilistische anpassungen gemacht.
         */
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
        /**
         * Der ActionListener wird ausgeführt, wenn das TextFeld fokussiert ist
         * und man dann die ENTER Taste drückt.
         */
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
        /**
         * Der ActionListener des JButton wird ausgeführt sobald man
         * den Knopf drückt oder einen Knopfdruck mit JButton#doClick imitiert.
         */
        übernehmen2.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                /**
                 * Zuerst wird überprüft ob das deutsche Wort eingetragen oder
                 * das Fremdwort eingetragen sein muss.
                 */
                if(übernehmen2.getText().equals("Weiter?")) /* Das Deutsche wurde eingetragen */ {
                    /**
                     * Die Variable zur Erstellung von Vokabeln wird intitialisiert
                     * und das Deutsche Wort als Parameter eingetragen.
                     */
                    creating = new Vokabeln(eingabeText2.getText(), "");
                    /**
                     * Der InfoText wird geändert, dass man das Fremdwort eintragen soll.
                     */
                    ausgabeText2.setText("Gebe nun das Fremdwort für '" + eingabeText2.getText() + "' ein.");
                    eingabeText2.setText("");
                    übernehmen2.setText("Eintragen?");
                } else if(übernehmen2.getText().equals("Eintragen?")) /* Das Fremdwort wurde eingetragen */ {
                    /**
                     * Das Fremdwort (Parameter 2) wird auf den Eingabetext gesetzt.
                     */
                    creating.Fremdwort = eingabeText2.getText();
                    /**
                     * Anschließend wird die Methode Vokabeln#addWord aufgerufen mit dem erstellten
                     * Vokabel als Parameter.
                     * Die Methode fügt das Vokabel zur Datei vokabeln.txt hinzu und lädt den Vokabel Cache neu.
                     */
                    Vokabeln.addWord(creating);
                    /**
                     * Die Felder werden zurückgesetzt, sodass man wieder eine neues Vokabel hinzufügen kann.
                     */
                    ausgabeText2.setText("Erfolgreich. Gebe das Deutsche Wort ein");
                    übernehmen2.setText("Weiter?");
                    eingabeText2.setText("");
                    creating = null;
                }
            }
        });
        
        /**
         * Alle Felder werden zum Fenster hinzugefügt.
         */
        fenster.add(title);
        fenster.add(ausgabeText);
        fenster.add(eingabeText);
        fenster.add(übernehmen);
        fenster.add(title2);
        fenster.add(ausgabeText2);
        fenster.add(eingabeText2);
        fenster.add(übernehmen2);
        /**
         * Zuletzt wird das Fenster sichtbar gemacht.
         */
        fenster.setVisible(true);
    }
}
