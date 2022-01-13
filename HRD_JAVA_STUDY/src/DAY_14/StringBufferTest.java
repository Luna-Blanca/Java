package DAY_14;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("홍길동");
        sb.append("김철수");

        String namelist = "홍길동" + "김철수";

        System.out.println("sb.length() ------------> " + sb.length());
        System.out.println("sb.capacity() ------------> " + sb.capacity());
        System.out.println("sb ------------>" + sb.toString());
        System.out.println("sb ------------>" + sb);
        System.out.println("namelist ------------>" + namelist);
    }
}
