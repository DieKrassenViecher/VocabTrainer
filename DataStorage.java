import java.util.*;
import java.io.*;

/**
 * @author 
 * @version 
 */
public class DataStorage
{
    // Bezugsobjekte
    
    // Attribute
    File storageFile;

    // Konstruktor
    public DataStorage()
    {
        storageFile = new File("vokabeln.txt");
        if(!storageFile.exists()) {
            try {
                storageFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Dienste
    public void save(String content) {
        try {
            FileWriter fw = new FileWriter(storageFile);
            fw.write(content);
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
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
