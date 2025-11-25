package Instunce;

import java.util.*;

/**
 * Borrower 클래스는 도서관 이용자의 정보를 담고 있는 객체를 생성하는데 사용되는 클래스 이다.
 *
 * @author (니시 야스히로)
 * @version (2025.11.20)
 */
public class Borrower{
    private int borrowerId;
    private String name = null;
    
    private ArrayList<Loan> loans = null;
    
    /*
     * 생성자는 각종 값들에 대한 초기화를 진행한다
     * 
     * @param 없음
     */
    public Borrower(int borrowerId, String name){
        this.borrowerId = borrowerId;
        this.name = name;
        
        this.loans = new ArrayList<Loan>();
    }
    
    public int getBorrowerId(){ return this.borrowerId; }
    
    // 이용자가 책을 대출 받을 수 있는지 확인하는 메소드이다
    public boolean loanAbleCheck(){
        return this.loans.size() < 10;
    }
    
    // 이용자에게 대출 건수와의 관계를 형성해 주는 메소드이다
    public void connectLoan(Loan loan){
        this.loans.add(loan);
    }
    // 이용자와 임이의 대출 건수와의 관계를 제거해 주는 메소드이다
    public void disconnectLoan(Loan loan){
        this.loans.remove(loan);
    }
    
    public String toString(){
        return this.borrowerId + " " + this.name;
    }
}
