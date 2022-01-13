package DAY_14;

public class StringTest {
    public static void main(String[] args) {
        String pname = "홍길동";
        String rname = new String("홍길동");
        String sname = "홍길동";
        if (pname == sname) {
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
        if (pname.equals(rname)) {
            System.out.println("문자열이 같다");
        } else {
            System.out.println("문자열이 다르다");
        }
        System.out.println();

        String strlist = "홍길동,이순신,공유,김고은";
        String[] namelist = strlist.split(",");
        for (String i : namelist) {
            System.out.println(i);
        }
        String namelist1 = String.join("-", "홍길동", "김고은", "공유");
        System.out.println(namelist1);
        System.out.println();

        String subject = "                자바                       ";
        System.out.println(subject);
        System.out.println();

        String str = String.valueOf(1234);
        System.out.println(str);
        System.out.println();

    }
}
