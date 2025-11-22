package Instunce;

/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book{
    int bookId;
    String title = null;
    String author = null;
    
    Loan loan = null;
    
    public Book(int bookId, String title, String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    
    public int getBookId(){ return this.bookId; }
    
    public boolean loanAbleCheck(){
        return this.loan == null;
    }
    
    public Loan findConnectLoan(){
        return this.loan;
    }
    
    public void connectLoan(Loan loan){
        this.loan = loan;
    }
    public void disconnectLoan(){
        this.loan = null;
    }
    
    public String toString(){
        return this.bookId + " " + this.title + " " + this.author;
    }
}
