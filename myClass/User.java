package myClass;


/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (PBL#1 9팀)
 * @version (2025.09.25)
 */
public class User extends DB_Element {
    private String name;
    private Integer stID;

    /**
     * User 클래스의 객체 생성자
     */
    public User(String name, Integer stID) {
        this.name = name;
        this.stID = stID;
    }

    /**
     * getID 메소드 - 이용자 ID를 반환
     *
     * @return 이용자 ID
     */
    public String getID() {
        return Integer.toString(stID);
    }

    /**
     * toString 메소드 - 이용자 정보를 문자열로 반환
     *
     * @return 이용자 정보
     */
    public String toString() {
        return "[" + stID + "] " + name;
    }
}