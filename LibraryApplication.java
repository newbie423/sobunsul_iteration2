import DataBase.*;
import Instunce.*;

/**
 * LibraryApplication를 구현한 시스템 클래스
 * 도서관직원의 요청을 받아 책의 관한 처리를 실행한다.
 *
 * @author (정윤성)
 * @version (2025.11.20)
 */
public class LibraryApplication
{
    private BorrowerDB borrowerDB;
    private BookDB bookDB;
    private LoanDB loanDB;
    
    public LibraryApplication(){
        this.borrowerDB = new BorrowerDB();
        this.bookDB = new BookDB();
        this.loanDB = new LoanDB();
    }

}