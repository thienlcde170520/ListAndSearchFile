
package controller;

import Repository.IListAndSearchFileRepository;
import Repository.ListAndSearchFileRepository;
import common.Library;
import view.Menu;


public class ListAndSearchFileManager extends Menu<String>{
    static String[] mc = {"Count Word In File", "Find File by Word", "Exit"};
    IListAndSearchFileRepository ls;
    public ListAndSearchFileManager(){
        super("===== Word Program =====",mc);
        ls = new ListAndSearchFileRepository();
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                ls.countWordInFile();
                break;
            case 2:
                ls.findFileNameByWord();
                break;
            case 3:
                System.out.println("Extting...!!!");
                System.exit(0);
        }
    }
    
}
