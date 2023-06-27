import java.util.*;
import java.io.*;

/**
 * @author Thore, Tommy
 * @version 1.0
 */
public class DataStorage
{
    /**
     * Attribut für die Datei vokabeln.txt
     */
    File storageFile;

    // Konstruktor
    public DataStorage()
    {
        /**
         * Das Attribut wird initialisiert.
         */
        storageFile = new File("vokabeln.txt");
        /**
         * Falls die Datei vokabeln.txt nicht existiert, wird diese erstellt und ein Beispiel Vokabel reingesetzt.
         */
        if(!storageFile.exists()) {
            try {
                storageFile.createNewFile();
                save("Nüsse:Nuts;Gehen:Walk");
            } catch (IOException ex) /* Falls ein Fehler bei der Erstellung der 
                                        Datei passiert wird er in der Konsole ausgegeben */ {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Speichert neuen Inhalt in die Datei vokabeln.txt
     * @param String Der zu speichernde Inhalt
     */
    public void save(String content) {
        try {
            /**
             * Es wird der FileWriter von Java benutzt
             * um den Inhalt in die Datei zu schreiben.
             */
            FileWriter fw = new FileWriter(storageFile);
            fw.write(content);
            /**
             * Durch das close() wird noch ein flush durchgeführt das alle Daten im Buffer wegschreibt.
             * Dadurch werden Resourcen geschont.
             */
            fw.close();
        } catch (Exception ex) /* Falls ein Fehler bei der Erstellung der 
                                  Datei passiert wird er in der Konsole ausgegeben */ {
            ex.printStackTrace();
        }
    }
    
    /**
     * Lädt den Inhalt von vokabeln.txt
     * @return Der Inhalt der Datei als String
     */
    public String read() {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(storageFile))
        {
            int content;
            while ((content = fr.read()) != -1) {
                sb.append((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
