
/**
 * 유스케이스 다이어그램에서 사서 역할을 겸하는 클래스
 * LibraryApplication 클래스를 사용해 책의 관한 처리를 진행한다.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Librarian
{
    public static void main(String[] args) {
        LibraryApplication LA = new LibraryApplication();

        System.out.println("=== 이용자 등록 예시(정상) ===");
        LA.registerOneBorrower(1, "홍길동");
        LA.registerOneBorrower(2, "김길동");
        LA.registerOneBorrower(3, "고길동");
        System.out.println();

        System.out.println("=== 책 등록 예시(정상) ===");
        LA.registerOneBook(101, "자바 프로그래밍", "김자바");
        LA.registerOneBook(102, "파이썬 프로그래밍", "김파이썬");
        LA.registerOneBook(103, "C++ 프로그래밍", "김씨플");
        LA.registerOneBook(104, "객체 지향 설계", "김설계");
        System.out.println();

        System.out.println("=== 이용자 등록 예시(예외) ===");
        LA.registerOneBorrower(1, "나길동");
        System.out.println();

        System.out.println("=== 이용자 등록 예시(예외) ===");
        LA.registerOneBook(3, "철학 기초", "김철학");
        System.out.println();
        
        System.out.println("=== 대출 예시(정상) ===");
        LA.loanOneBook(101, 1); // 101번 책을 1번 이용자가 대출
        LA.loanOneBook(102, 1);
        System.out.println();
        
        System.out.println("=== 반납 예시(정상) ===");
        LA.returnOneBook(101);
        LA.returnOneBook(102);
        System.out.println();
    
        System.out.println("=== 대출 예시(예외) ===");
        LA.loanOneBook(10000, 1); // 책 아이디 없음
        LA.loanOneBook(101, 10000); // 이용자 아이디 없음
        System.out.println();
        
        System.out.println("=== 반납 예시(예외) ===");
        LA.returnOneBook(10000); // 책 아이디 없음
        LA.returnOneBook(101); // 대출 된적 없음
        System.out.println();
        
        System.out.println("====== 대출이 1건도 없는 경우 ======");
        
        System.out.println("=== 대출 가능 책 출력(대출이 1건도 없는 경우) ===");
        LA.displayBookOnLoan();
        System.out.println();
        
        System.out.println("=== 대출 중인 책 출력(대출이 1건도 없는 경우) ===");
        LA.displayBookOffLoan();
        System.out.println();
        
        System.out.println();
        
        System.out.println("====== 대출 건수가 있는 경우 ======");
        LA.loanOneBook(101, 1); // 101번 책을 1번 이용자가 대출
        LA.loanOneBook(103, 2);
        
        System.out.println("=== 대출 가능 책 출력(대출 건수가 있는 경우) ===");
        LA.displayBookOnLoan();
        System.out.println();
        
        System.out.println("=== 대출 가능 책 출력(대출 건수가 있는 경우) ===");
        
        System.out.println();
        LA.displayBookOffLoan();
        System.out.println();
    }
}












