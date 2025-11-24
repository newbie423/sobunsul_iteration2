package Instunce;
import java.util.*;

/**
 * Loan 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Loan
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private Borrower borrower;
    private Book book;
    private Date loanDate;

    /**
     * Loan 클래스의 객체 생성자
     */
    public Loan(Borrower borrower, Book book)
    {
        this.borrower = borrower;
        this.book = book;
        this.loanDate = new Date();
    }

    public Borrower findConnectBorrower() {
        return this.borrower;
    }
    
    public String toString(){
        return "책의 정보 : " + this.book + ",  이용자의 정보 : " + this.borrower;
    }
}