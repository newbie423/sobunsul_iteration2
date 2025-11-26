
/**
 * 유스케이스 다이어그램에서 사서 역할을 겸하는 클래스
 * LibraryApplication 클래스를 사용해 책의 관한 처리를 진행한다.
 *
 * @author (정윤성, 니시야스히로, 윈파파한, 오번가수영)
 * @version (2025.11.26)
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
        LA.registerOneBook(104, "소설", "김소설");
        LA.registerOneBook(105, "객체 지향 설계", "김설계");
        LA.registerOneBook(106, "건축", "김건축");
        LA.registerOneBook(107, "요리 레시피", "김요리");
        LA.registerOneBook(108, "동물 백과사전", "김동물");
        LA.registerOneBook(109, "Ruby 프로그래밍", "김루비");
        LA.registerOneBook(110, "Rust 프로그래밍", "김러스트");
        LA.registerOneBook(111, "문화", "김문화");
        System.out.println();

        System.out.println("=== 이용자 등록 예시(예외) ===");
        LA.registerOneBorrower(1, "김철수");
        System.out.println();

        System.out.println("=== 책 등록 예시(예외) ===");
        LA.registerOneBook(103, "철학 기초", "김철학");
        System.out.println();

        System.out.println("=== 대출 예시(정상) ===");
        LA.loanOneBook(101, 1); // 101번 책을 1번 이용자가 대출
        LA.loanOneBook(102, 1);
        System.out.println();

        System.out.println("=== 책 중복 대출 ===");
        LA.loanOneBook(101, 2); // 위에서 이미 대출된 101번 책
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
        LA.returnOneBook(101); // 대출 되지 않음
        System.out.println();

        System.out.println("====== 대출이 1건도 없는 경우 책들 출력 ======");
        System.out.println();

        System.out.println("=== 대출 중인 책 출력(대출이 1건도 없는 경우) ===");
        LA.displayBookOnLoan();
        System.out.println();

        System.out.println("=== 대출 가능 책 출력(대출이 1건도 없는 경우) ===");
        LA.displayBookOffLoan();
        System.out.println();

        System.out.println();

        System.out.println("====== 대출 건수가 있는 경우 책들 출력 ======");
        LA.loanOneBook(101, 1); // 101번 책을 1번 이용자가 대출
        LA.loanOneBook(102, 1);
        System.out.println();

        System.out.println("=== 대출 중인 책 출력(대출 건수가 있는 경우) ===");
        LA.displayBookOnLoan();
        System.out.println();

        System.out.println("=== 대출 가능 책 출력(대출 건수가 있는 경우) ===");
        LA.displayBookOffLoan();
        System.out.println();

        System.out.println();

        System.out.println("=== 이용자 1명이 최대 책권수 까지 대출 예시 ===");
        for(int idx = 103; idx <= 111; idx++){
            LA.loanOneBook(idx, 1);
        }
        System.out.println();
        
        System.out.println();

        System.out.println("======= 모든 책이 대출된 경우 책들 출력 ======");
        LA.loanOneBook(111, 2); // 1번 이용자는 이미 최대 권수 까지 대출을 받았기에 2번 이용자로 대체
        System.out.println();

        System.out.println("=== 대출 중인 책 출력(대출 건수가 있는 경우) ===");
        LA.displayBookOnLoan();
        System.out.println();

        System.out.println("=== 대출 가능 책 출력(대출 건수가 있는 경우) ===");
        LA.displayBookOffLoan();
        System.out.println();
    }
}



