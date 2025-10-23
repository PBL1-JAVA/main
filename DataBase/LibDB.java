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
        Iterator<T> iterator = db.iterator(); // 7장 Iterator (p423) 참조, db에 저장된 걸렉션에서 요소를 순차 검색할때 사용
        while (iterator.hasNext()) { //7장 Iterator (p423) 참조, hasNext()메소드를 통해 다음 방문할 요소가 있으면 true retrun
            T elem = iterator.next();
            if(elem.getID().equals(id)){ //6장 boolean equals(Object obj) 잠조 (p356), 두 객체의 내용이 같은지 비교하는 메소드
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