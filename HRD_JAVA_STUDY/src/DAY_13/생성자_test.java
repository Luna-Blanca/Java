package DAY_13;

public class 생성자_test {
    public static void main(String[] args) {
        생성자 co1 = new 생성자();
        생성자 co2 = new 생성자("하얀달");
        생성자 co3 = new 생성자(24);
        생성자 co4 = new 생성자("검은달", 20);

        System.out.println("생성자 ( )");
        System.out.println("이름 : " + co1.getName());
        System.out.println("나이 : " + co1.getAge());
        System.out.println();
        System.out.println("생성자 ( String name )");
        System.out.println("이름 : " + co2.getName());
        System.out.println("나이 : " + co2.getAge());
        System.out.println();
        System.out.println("생성자 ( int age )");
        System.out.println("이름 : " + co3.getName());
        System.out.println("나이 : " + co3.getAge());
        System.out.println();
        System.out.println("생성자 ( String name, int age )");
        System.out.println("이름 : " + co4.getName());
        System.out.println("나이 : " + co4.getAge());
    }
}
