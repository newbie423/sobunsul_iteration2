package DataBase;

import java.util.*;

import Instunce.*;

/**
 * BookDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BookDB{
    private TreeSet<Book> bookDB = new TreeSet<Book>(Comparator.comparingInt(Book::getBookId));

    public BookDB(){}

    public void addBook(Book book){ this.bookDB.add(book); }

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

    public boolean emptyCheck(){
        return this.bookDB.isEmpty();
    }

    public TreeSet<Book> getBookDB(){
        return this.bookDB;
    }

    public String toString(){
        String string = "";

        Iterator<Book> it = this.bookDB.iterator();

        while(it.hasNext()){
            Book book = it.next();

            string += (book) + "\n";
        }

        return string;
    }
}
