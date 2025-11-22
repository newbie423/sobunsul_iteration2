package Instunce;

import java.util.*;

/**
 * Borrower 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Borrower{
    private int borrowerId;
    private String name = null;
    
    private ArrayList<Loan> loans = null;
    
    public Borrower(int borrowerId, String name){
        this.borrowerId = borrowerId;
        this.name = name;
        
        this.loans = new ArrayList<Loan>();
    }
    
    public int getBorrowerId(){ return this.borrowerId; }
    
    public boolean loanAbleCheck(){
        return this.loans.size() < 10;
    }
    
    public void connectLoan(Loan loan){
        this.loans.add(loan);
    }
    public void disconnectLoan(Loan loan){
        this.loans.remove(loan);
    }
    
    public String toString(){
        return this.borrowerId + " " + this.name;
    }
}
