import java.util.*;
/**
 * @author Thore, Tommy
 * @version 1.0
 */
public class Vokabeln
{
    // Speicher Schema der Vokabeln: deutschwort:fremdwort;deutschwort:fremdwort
    /**
     * Die Liste Dient als Cache für die Vokabeln, würde man bei
     * jedem Vokabel die Datei neu aufrufen, würde das die Effizienz
     * des Programms immenz reduzieren.
     */
    public static List<Vokabeln> loadedWords = new ArrayList<>();
    
    public static DataStorage dataStorage = null;
    
    /**
     * Wird genutzt um das DataStorage Objekt zu initialisieren
     * falls es noch nicht initialisiert ist.
     * @return Das Objekt der Klasse DataStorage
     */
    public static DataStorage getData() {
        if(dataStorage == null) {
            dataStorage = new DataStorage();
        }
        return dataStorage;
    }

    // Attribute
    protected String Fremdwort;
    protected String Deutschwort;
    
    // Konstruktor
    public Vokabeln(String Deutschwort, String Fremdwort)
    {
        this.Fremdwort = Fremdwort;
        this.Deutschwort = Deutschwort;
    }

    /**
     * Lädt alle Wörter aus der Datei vokabeln.txt
     */
    public static void loadWords() {
        /**
         * Zuerst wird der aktuelle Cache geleert.
         */
        loadedWords.clear();
        /**
         * Anschließend wird der Dateiinhalt mit der Methode DataStorage#read
         * ausgelesen und in content gespeichert.
         */
        String content = getData().read();
        /**
         * Der Dateiinhalt wird in die einzelnen Übersetzungen aufgeteilt und im
         * String Array words gespeichert.
         */
        String[] words = content.split(";");
        /**
         * Die For Schleife geht alle Übersetzungen durch und fügt sie zum Cache hinzu.
         */
        for(String word : words) {
            /**
             * Die Übersetzung wird in Deutschwort und Fremdwort aufgeteilt
             * und im String Array splitted gespeichert.
             */
            String[] splitted = word.split(":");
            /**
             * Es wird ein Objekt Vokabeln erstellt mit den Deutschwort und Fremdwort
             * als Parameter und anschließend zum Cache hinzugefügt.
             */
            Vokabeln vok = new Vokabeln(splitted[0], splitted[1]);
            loadedWords.add(vok);
        }
    }
    
    /**
     * Fügt ein Wort zum Cache und zur Datei vokabeln.txt hinzu.
     * @param Vokabeln Vokabel das hinzugefügt werden soll
     */
    public static void addWord(Vokabeln vok) {
        loadedWords.add(vok);
        getData().save(getData().read() + ";" + vok.Deutschwort + ":" + vok.Fremdwort);
    }

}
