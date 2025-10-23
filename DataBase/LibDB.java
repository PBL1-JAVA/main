package DataBase;

import myClass.DB_Element;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * LibDB 클래스
 * ArrayList<t> 사용하여 addElements()로 요소 보관
 * DB_Elements는 getID()로 검색
 * printAllElement()로 전체 출력
 * 
 * @author (PBL#1 9팀)
 * @version (2025.10.23)
 */
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     */
    public LibDB() {
        this.db = new ArrayList<T>();
    }

     /**
     * addElement 메소드 - DB에 요소를 추가
     *
     * @param  element  추가할 객체
     */
    public void addElement(T element) {
        db.add(element);
    }
    
    /**
     * findElement 메소드 - ID로 객체를 검색
     *
     * @param  id  검색할 ID 
     * @return     찾은 객체 또는 null
     */
    public T findElement(String id) {
        Iterator<T> iterator = db.iterator();
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if(elem.getID().equals(id)){
                return elem;
            }
        }
        return null;
    }
    
    /**
     * printAllElement 메소드 - 모든 객체를 출력
     */
    public void printAllElements() {
        for (T s : db) {
            System.out.println(s);
        }
    }
}