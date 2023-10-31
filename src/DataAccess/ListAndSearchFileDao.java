
package DataAccess;

import common.Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListAndSearchFileDao {
    
    public String path;
    public String  word;
    Library l;
    
    public ListAndSearchFileDao() {
        this.path = path;
        this.word = word;
        l = new Library();
    }
    private static ListAndSearchFileDao instance = null;
    public static ListAndSearchFileDao Instance() {
        if (instance == null) {
            synchronized (ListAndSearchFileDao.class) {
                if (instance == null) {
                    instance = new ListAndSearchFileDao();
                }
            }
        }
        return instance;
    }
    
    public void countWordInFile() {
        path = l.checkInputPathFile("Enter Path: ");
        word = l.getString("Enter Word: ");
        int count = countWordInFile(path, word);
        System.out.println("Count: " + count);
    }
    
    public int countWordInFile(String path, String word) {
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public void findFileNameByWord() {
        path = l.getString("Enter Path: ");
        word = l.getString("Enter Word: ");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }
    
    
}
