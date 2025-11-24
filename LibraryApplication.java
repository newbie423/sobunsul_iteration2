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

    public void registerOneBorrower(int borrowerID, String name) {
        
    }
    
    public void registerOneBook(int bookID, String name, String author) {
        
    }
    
    public void loanOneBook(int bookID, int borrowerID) {
        Book loanBook = bookDB.findBook(bookID);
        Borrower loanBorrower = borrowerDB.findBorrower(borrowerID);
        
        if(loanBook != null && loanBorrower != null) {
            System.out.println(loanBook+"와 "+loanBorrower+"이 존재");
        } else {
            System.out.println("책이나 이용자가 존재하지 않음");
            return;
        }
        
        boolean bookCheck = loanBook.loanAbleCheck();
        boolean borrowerCheck = loanBorrower.loanAbleCheck();
        
        if(bookCheck==true && borrowerCheck==true){
            System.out.println("책이나 이용자가 대출가능");
        } else if(bookCheck == false) {
            System.out.println(loanBook + "는 대출불가");
        } else if(borrowerCheck == false) {
            System.out.println(loanBorrower + "는 대출불가");
        } else {
            System.out.println(loanBook +"와 " + loanBorrower + "은 대출불가");
        }
        
        Loan loan = new Loan(loanBorrower, loanBook);
        loanDB.addLoan(loan);
        
        loanBook.connectLoan(loan);
        loanBorrower.connectLoan(loan);
        
        System.out.println(loan);
    }
    
    public void returnOneBook(int bookID) {
        Book returnBook = bookDB.findBook(bookID);
        
        if(returnBook != null) {
            System.out.println("반납할 책 : " + returnBook);
        } else {
            System.out.println("도서관에 수장된 책이 아님");
        }
        
        Loan loan = returnBook.findConnectLoan();
        
        if(loan == null) {
            System.out.println("대출 중인 책이 아님");
        }
        
        Borrower returnBorrower = loan.findConnectBorrower();
        System.out.println("책과 이용자 모두 반납 가능");
        
        returnBook.disconnectLoan();
        returnBorrower.disconnectLoan(loan);
        this.loanDB.deleteLoan(loan);
        
        System.out.println("---반납 성공---");
        System.out.println("대출정보 : " + loan);
        System.out.println("반납된 책 : " + returnBook);
        System.out.println("반납한 이용자 : " + returnBorrower);
    }
    
    public void displayBookOnLoan() {
        
    }
    
    public void displayBookOffLoan() {
        
    }
}