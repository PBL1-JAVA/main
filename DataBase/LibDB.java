package DataBase;

import myClass.DB_Element;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author (PBL#1 9팀)
 * @version (2025.10.23)
 */
public class LibDB<T extends DB_Element>
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
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
    public void printAllElement() {
        for (T s : db) {
            System.out.println(s);
        }
    }

    /**
     * getSize 메소드 - DB 크기 반환
     *
     * @return DB에 저장된 요소의 개수
     */
    public int getSize() {
        return db.size();
    }
}