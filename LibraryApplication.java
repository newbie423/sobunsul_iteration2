import DataBase.*;
import Instunce.*;

import java.util.*;

/**
 * LibraryApplication를 구현한 시스템 클래스
 * 도서관직원의 요청을 받아 책의 관한 처리를 실행한다.
 *
 * @author (정윤성, 윈파파한, 오번가 수영)
 * @version (2025.11.20)
 */
public class LibraryApplication
{
    private BorrowerDB borrowerDB;
    private BookDB bookDB;
    private LoanDB loanDB;

    /*
     * 생성자는 사용할 각종 데이터 베이스들에 대한 초기화를 진행한다
     * 
     * @param 없음
     */
    public LibraryApplication(){
        this.borrowerDB = new BorrowerDB();
        this.bookDB = new BookDB();
        this.loanDB = new LoanDB();
    }

    /*
     * 이 메소드는 이용자 1명을 등록하는 메소드이다
     * 
     * @param int borrowerID -> 등록할 이용자의 아이디
     * @param String name -> 등록할 이용자의 이름
     * 
     * @return 없음
     */
    public void registerOneBorrower(int borrowerID, String name) {
        if(this.borrowerDB.borrowerIDCheck(borrowerID)){
            System.out.println("이용자 등록 실패 : " + "아이디 " + "\"" + borrowerID + "\"" + "이(가) 이미 존재하여 이용자를 등록에 사용할 수 없습니다");
            return;
        }

        Borrower borrower = new Borrower(borrowerID, name);

        this.borrowerDB.addBorrower(borrower);

        System.out.println("이용자 등록 성공 : " + "\"" + borrower + "\"" + "이(가) 성공적으로 이용자 등록 되었습니다");
    }

    /*
     * 이 메소드는 책 1권을 등록하는 메소드이다
     * 
     * @param int bookID -> 등록할 책의 아이디
     * @param String title -> 등록할 책의 제목
     * @param String author -> 등록할 책의 저자
     * 
     * @return 없음
     */
    public void registerOneBook(int bookID, String title, String author) {
        if(this.bookDB.bookIDCheck(bookID)){
            System.out.println("책 등록 실패 : " + "아이디 " + "\"" + bookID + "\"" + "이(가) 이미 존재하여 이용자를 등록에 사용할 수 없습니다");
            return;
        }

        Book book = new Book(bookID, title, author);

        this.bookDB.addBook(book);

        System.out.println("책 등록 성공 : " + "\"" + book + "\"" + "이(가) 성공적으로 책 등록 되었습니다");
    }

    /*
     * 이 메소드는 이용자가 책 1권을 대출 하는 메소드이다
     * 
     * @param int bookID -> 대출할 책 아이디
     * @param int borrowerID -> 대출하는 이용자
     * 
     * @return 없음
     */
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
            return;
        } else if(borrowerCheck == false) {
            System.out.println(loanBorrower + "는 대출불가");
            return;
        } else {
            System.out.println(loanBook +"와 " + loanBorrower + "은 대출불가");
            return;
        }

        Loan loan = new Loan(loanBorrower, loanBook);
        loanDB.addLoan(loan);

        loanBook.connectLoan(loan);
        loanBorrower.connectLoan(loan);

        System.out.println(loan);
    }

    /*
     * 이 메소드는 이용자가 책 1권을 반납 하는 메소드이다
     * 
     * @param int bookID -> 반납할 책 아이디
     * 
     * @return 없음
     */
    public void returnOneBook(int bookID) {
        Book returnBook = bookDB.findBook(bookID);

        if(returnBook != null) {
            System.out.println("반납할 책 : " + returnBook);
        } else {
            System.out.println("도서관에 수장된 책이 아님");
            return;
        }

        Loan loan = returnBook.findConnectLoan();

        if(loan == null) {
            System.out.println("대출 중인 책이 아님");
            return;
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

    /*
     * 이 메소드는 대출 중인 모든 책을 표시하는 메소드이다
     * 
     * @param 없음
     * 
     * @return 없음
     */
    public void displayBookOnLoan() {
        if(this.bookDB.emptyCheck()){
            System.out.println("책DB에 등록된 책이 없습니다");
            return;
        }

        boolean bookPrinted = false;

        while(true){
            Book book = this.bookDB.getOneBook();

            if(book == null){
                break;
            }

            // 이미 대출이 되어 있다고 한다면 대출 가능 여부가 false가 됨
            if(book.loanAbleCheck() == false){
                bookPrinted = true;
                System.out.println(book);
            }
        }

        if(bookPrinted == false){
            System.out.println("대출 중인 책이 한권도 없습니다");
        }
    }

    /*
     * 이 메소드는 대출 가능한 모든 책을 표시하는 메소드이다
     * 
     * @param 없음
     * 
     * @return 없음
     */
    public void displayBookOffLoan() {
        if(this.bookDB.emptyCheck()){
            System.out.println("책DB에 등록된 책이 없습니다");
            return;
        }

        boolean bookPrinted = false;

        while(true){
            Book book = this.bookDB.getOneBook();

            if(book == null){
                break;
            }

            // 대출이 되어 있지 않다고 한다면 대출 가능 여부가 true가 됨
            if(book.loanAbleCheck()){
                bookPrinted = true;
                System.out.println(book);
            }
        }

        if(bookPrinted == false){
            System.out.println("대출 가능한 책이 한권도 없습니다");
        }
    }
}