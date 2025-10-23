import DataBase.LibDB;
import myClass.Book;
import myClass.User;
/**
 * App LibarayManagementSystem을 동작시키는 클래스
 *
 * @author (PBL#1 9팀)
 * @version (2025.10.23)
 */
public class App
{
    public static void main(String[] args) {
        // ① LibraryManagementSystem 객체를 생성
        LibraryManagementSystem libMS = new LibraryManagementSystem();
        
        // ② setUserDB() 메소드에 UserData2025.txt 파일 경로를 전달하여 이용자DB를 설정
        LibDB<User> userDB = libMS.setUserDB("C:\\Temp\\UserData2025.txt"); 
        // ③ printDB(userDB) 메소드를 호출하여 이용자DB를 출력
        System.out.println("----- 이용자 목록 출력 -----");
        libMS.printDB(userDB);
        // ④ setBookDB() 메소드에 BookData2025.txt 파일 경로를 전달하여 책DB를 설정
        LibDB<Book> bookDB = libMS.setBookDB("C:\\Temp\\BookData2025.txt");
        // ⑤ printDB(bookDB) 메소드를 호출하여 도서DB를 출력
        System.out.println("----- 책 목록 출력 -----");
        libMS.printDB(bookDB);
        
        // ⑥ borrowBook(userID, bookID) 메소드를 호출하여 대출 정보를 loanDB에 추가
        libMS.borrowBook("2023320003", "B04");
        libMS.borrowBook("2025320001", "B02");
        libMS.borrowBook("2024320002", "B03");
        
        // ⑦ printLoanList() 메소드를 호출하여 대출 현황을 출력
        libMS.printLoanList();
    }
}