package DAY_17;

import java.util.ArrayList;
import java.util.Scanner;

public class ObjectTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();  // 모든 데이터 타입을 저장하는 형태로 정의
        String str1 = new String("하얀달");
        String str2 = new String("붉은달");
        Object str3 = new String("파이썬");
        Object num1 = new Integer(100);
        //Object scan = new Scanner(System.in);

        list.add(str1);  list.add(str2);  list.add(str3);  // 생성은 String으로 되었지만, 데이터가 들어갈 때에는 Object로 들어가기에 형변환 발생
        list.add(num1);  //list.add(scan);

        Object[] olist = list.toArray();
        for (Object obj : olist) {
            System.out.println(obj.toString());
        }
    }
}
