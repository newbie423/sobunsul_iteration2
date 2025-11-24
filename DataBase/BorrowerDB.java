package DataBase;

import java.util.*;

import Instunce.*;

/**
 * BorrowerDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BorrowerDB{
    private TreeSet<Borrower> borrowerDB = new TreeSet<Borrower>(Comparator.comparingInt(Borrower::getBorrowerId));
    
    public BorrowerDB(){}
    
    public void addBorrower(Borrower borrower){ this.borrowerDB.add(borrower); }
    
    public String toString(){
        String string = "";
        
        Iterator<Borrower> it = this.borrowerDB.iterator();
        
        while(it.hasNext()){
            Borrower borrower = it.next();
            
            string += (borrower) + "\n";
        }
        
        return string;
    }
    
    public boolean borrowerIdCheck(int borrowerId){
        Borrower borrower =  this.borrowerDB.ceiling(new Borrower(borrowerId, ""));
        
        if(borrower == null){
            return false;
        }
        
        if(borrower.getBorrowerId() == borrowerId){
            return true;
        }
        
        return false;
    }
    public Borrower findBorrower(int borrowerId){
        Borrower borrower = this.borrowerDB.ceiling(new Borrower(borrowerId, ""));
        
        if(borrower == null){
            return null;
        }
        
        if(borrower.getBorrowerId() == borrowerId){
            return borrower;
        }
        
        return null;
    }
}
