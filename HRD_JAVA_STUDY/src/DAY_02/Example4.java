package DAY_02;

public class Example4 {
    public static void main(String[] args) {
        String str1 = "JAVA";
        String str2 = new String("JAVA");
        String str3 = new String("JAVA");
        System.out.println(str3 == str2);

        System.out.println("동일한가? " + (str1.equals(str2)));
    }
}
