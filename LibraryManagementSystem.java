import DataBase.LibDB;
import myClass.Book;
import myClass.DB_Element;
import myClass.User;
import java.io.FileReader;
import java.util.*;
/**
 * LibraryManagementSystem Book,User데이터 베이스로부터 파일을 읽어 각 객체를 생성하고 대출DB에 대출정보를 저장하는 클래스
 *
 * @author (PBL#1 9팀)
 * @version (2025.10.23)
 */
public class LibraryManagementSystem
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private LibDB<Book> bookDB;
    private LibDB<User> userDB;
    public HashMap<User, Book> loanDB;

    /**
     * LibraryManagementSystem 클래스의 객체 생성자
     */
    public LibraryManagementSystem()
    {
        bookDB = new LibDB<Book>();
        userDB = new LibDB<User>();
        loanDB = new HashMap<User, Book>();
    }

    /**
     * borrowBook 메소드 - 이용자 ID와 책 ID를 받아 대출정보를 저장
     *
     * @param  userID  이용자ID
     * @param  bookID  책ID
     */
    public void borrowBook(String userID, String bookID) {
        Book book= bookDB.findElement(bookID);
        User user = userDB.findElement(userID);

        loanDB.put(user,book);
    }

    /**
     * printDB 메소드 - 전달받은 DB의 모든 요소를 출력한다.
     *
     * @param  db  출력할 DB
     */
    public <T extends DB_Element> void printDB(LibDB<T> db) {
        db.printAllElement();
    }

    /**
     * printLoanList 메소드 - 대출DB에 정보 출력
     *
     */
    public void printLoanList(){
        System.out.println("----- 대출현황 -----");
        Set<User> keys = loanDB.keySet();
        Iterator<User> it = keys.iterator();
        while(it.hasNext()){
            User u = it.next();
            Book b = loanDB.get(u);
            System.out.println(u+"===>"+b);
        }
        System.out.println("-----------------" );
    }

    /**
     * setBookDB 메소드 - BookData2025 파일 위치를 전달받아 파일로부터 책 정보를 읽어 Book 객체를 생성하고 DB에 저장
     *
     * @param  fileName  책 파일 경로
     * @return           책 DB(LibDB<Book>) 객체
     */
    public LibDB<Book> setBookDB(String bookFile) {
        try { // 8장 (p465) 참조
            FileReader fin = new FileReader(bookFile);
            Scanner scan = new Scanner(fin); //2장(p79) 참조
            ArrayList<String> array = new ArrayList<String>();

            while (scan.hasNext()) {
                array.add(scan.nextLine());
            }
            Iterator<String> it = array.iterator();

            while (it.hasNext()) {
                StringTokenizer st = new StringTokenizer(it.next(), "/"); // 6장(p376) 참조
                String bookID = st.nextToken();
                String title = st.nextToken();
                String author = st.nextToken();
                String publisher = st.nextToken();
                int year = Integer.parseInt(st.nextToken());
                bookDB.addElement(new Book(bookID, title, author, publisher, year));
            }
            fin.close();

        } catch (Exception e) {
            System.out.println("오류발생");
        }
        return bookDB;
    }

    /**
     * setUserDB 메소드 - UserData2025 파일 위치를 전달받아 파일로부터 이용자 정보를 읽어 User 객체를 생성하고 DB에 저장
     *
     * @param  fileName  이용자 파일 경로
     * @return           이용자 DB(LibDB<User>) 객체
     */
    public LibDB<User> setUserDB(String userFile){
        try {
            FileReader fin = new FileReader(userFile);
            Scanner scan = new Scanner(fin);
            ArrayList<String> array = new ArrayList<String>();

            while (scan.hasNext()) {
                array.add(scan.nextLine());
            }

            for(int i = 0;i< array.size();i++){
                String s= array.get(i); //7장 (p419) 참조
                StringTokenizer st = new StringTokenizer(s, "/"); // 6장(p376) 참조
                Integer stID = Integer.valueOf(st.nextToken());//6장 (p361) Wrapper클래스 참조
                String name = st.nextToken();
                userDB.addElement(new User(name,stID));
            }
            fin.close();

        } catch (Exception e) {
            System.out.println("오류발생");
        }
        return userDB;
    }
}