import java.util.*;
/**
 * @author 
 * @version 
 */
public class Vokabeln
{
    // [deutschwort|fremdwort];[deutschwort|fremdwort]
    // Bezugsobjekte
    public static List<Vokabeln> loadedWords = new ArrayList<>();
    public static DataStorage dataStorage = null;
    
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

    // Dienste
    public static void loadWords() {
        loadedWords.clear();
        String content = getData().read();
        String[] words = content.split(";");
        for(String word : words) {
            String[] splitted = word.split(":");
            Vokabeln vok = new Vokabeln(splitted[0], splitted[1]);
            loadedWords.add(vok);
        }
    }
    
    public static void addWord(Vokabeln vok) {
        loadedWords.add(vok);
        getData().save(getData().read() + ";" + vok.Deutschwort + ":" + vok.Fremdwort);
    }

}
