package DataBase;
import Instunce.*;
import java.util.*;

/**
 * BorrowerDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BorrowerDB
{
    private TreeSet<Borrower> borrowerDB;

    public BorrowerDB()
    {
        this.borrowerDB = new TreeSet<Borrower>();
    }

}