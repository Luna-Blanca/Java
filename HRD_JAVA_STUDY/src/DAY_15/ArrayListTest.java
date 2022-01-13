package DAY_15;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(1);
        list.add("홍길동");
        list.add(100);
        list.add(123.456);
        list.add(new String("자바"));
        System.out.println("list.size = " + list.size());

        for (int i = 0; i < list.size();) {
            System.out.println(list.get(i));
            i++;
        }
        System.out.println();

        // 선언시 문자열 데이터만 저장하도록 선언- <String>
        ArrayList<String> strlist = new ArrayList<String>();
        strlist.add("안녕");
        strlist.add("나는");
        strlist.add("하얀달이야");
        strlist.add("123456");
        strlist.add(1, "너는 하얀달");
        System.out.println("strlist.size = " + strlist.size());
        for (String i : strlist) {
            System.out.print(i + " ");
        }
    }
}
