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
        LibraryManagementSystem libMS = new LibraryManagementSystem();

        LibDB<User> userDB = libMS.setUserDB("C:\\Temp\\UserData2025.txt");
        System.out.println("----- 이용자 목록 출력 -----");
        libMS.printDB(userDB);

        LibDB<Book> bookDB = libMS.setBookDB("C:\\Temp\\BookData2025.txt");
        System.out.println("----- 책 목록 출력 -----");
        libMS.printDB(bookDB);

        libMS.borrowBook("2023320003", "B04");
        libMS.borrowBook("2025320001", "B02");
        libMS.borrowBook("2024320002", "B03");

        libMS.printLoanList();
    }
}