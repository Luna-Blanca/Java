package DAY_17;

import DAY_16.Animal;
import DAY_16.Person;

import java.util.*;

public class ObjestTest2 {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<Object> list = new ArrayList<Object>();
        Person Hong = new Person("홍길동", 30, Animal.PERSON);
        Person Kong = new Person("콩길동", 20, Animal.PERSON);
        Person Long = new Person("롱길동", 27, Animal.PERSON);

        list.add(Hong);
        list.add(Kong);
        list.add(Long);
        map.put("list", list);

        // map에 있는 내용 출력하기
        ArrayList<Object> mlist = (ArrayList<Object>) map.get("list");
        for (Object obj : mlist) {
            Person p = (Person)obj;
            System.out.printf("%-6s %-5s %-9s",p.getName(), p.getAge(), p.getType());
            System.out.println();
        }
    }
}
