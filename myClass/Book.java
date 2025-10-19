package myClass;


/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (PBL#1 9팀)
 * @version (2025.10.23)
 */
public class Book extends DB_Element
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;
    
    /**
     * Book 클래스의 객체 생성자
     */
    public Book(String bookID, String title, String author, String publisher, int year) {
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }
    
    
      /**
     * getID 메소드 - 도서 ID를 반환
     *
     * @return 책ID
     */
    public String getID() {
        return this.bookID;
    }

    /**
     * toString 메소드 - 서지정보 반환
     *
     * @return 서지정보
     */
    public String toString() {
        return "(" + this.bookID + ") " + this.title + ", " + this.author + ", "
                + this.publisher + ", " + this.year;
    }
}