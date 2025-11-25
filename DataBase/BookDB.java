package DataBase;

import java.util.*;

import Instunce.*;

/**
 * BookDB 클래스는 Book 클래스로 생성한 객체들을 저장하기 위한 클래스 이다.
 *
 * @author (작성자 이름)
 * @version (2025.11.20)
 */
public class BookDB{
    private TreeSet<Book> bookDB = new TreeSet<Book>(Comparator.comparingInt(Book::getBookId));

    public BookDB(){}

    public void addBook(Book book){ this.bookDB.add(book); }

    // 책의 아이디가 존재하는지 확인하는 메소드이다
    public boolean bookIdCheck(int bookId){
        Book book =  this.bookDB.ceiling(new Book(bookId, "", ""));

        if(book == null){
            return false;
        }

        if(book.getBookId() == bookId){
            return true;
        }

        return false;
    }

    // 아이디에 해당되는 책 객체를 반환하는 메소드이다
    public Book findBook(int bookId){
        Book book = this.bookDB.ceiling(new Book(bookId, "", ""));

        if(book == null){
            return null;
        }

        if(book.getBookId() == bookId){
            return book;
        }

        return null;
    }

    // 책이 없는지 확인하는 메소드이다
    public boolean emptyCheck(){
        return this.bookDB.isEmpty();
    }

    public TreeSet<Book> getBookDB(){
        return this.bookDB;
    }
}
