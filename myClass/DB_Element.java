package myClass;


/**
 * DB_Element 클래스
 * 추상 메서드 getID()를 사용했기 때문에 하위 클래스가 고유 식별자가 있어야 함.
 * 
 * @author (PBL#1 9팀)
 * @version (2025.10.23)
 */
public abstract class DB_Element
{   
    /**
     * getID 메소드 - 하위 클래스가 가진 고유 식별자를 문자열로 반환하는 기능
     */
    public abstract String getID();
}