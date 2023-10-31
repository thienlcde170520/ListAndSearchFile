
package Repository;
import DataAccess.ListAndSearchFileDao;

public class ListAndSearchFileRepository implements IListAndSearchFileRepository{
    
    @Override
    public void countWordInFile() {
        ListAndSearchFileDao.Instance().countWordInFile();
    }

    @Override
    public void findFileNameByWord() {
        ListAndSearchFileDao.Instance().findFileNameByWord();
    }
}
