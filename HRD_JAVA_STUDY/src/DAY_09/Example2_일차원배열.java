package DAY_09;

public class Example2_일차원배열 {
    public static void main(String[] args) {
        String[] strlist = new String[3];
        strlist[0] = "JAVA";
        strlist[1] = "JAVA1";
        strlist[2] = "JAVA2";

        String[] strlist2 = new String[3];
        strlist2[0] = new String("JAVA");
        strlist2[1] = new String("JAVA1");
        strlist2[2] = new String("JAVA2");

        for (int i = 0; i < strlist.length; i++) {
            System.out.println("strlist [" + i + "] = " + strlist[i]);
        }

        System.out.println("---------------------------------------");
        for (int i = 0; i < strlist2.length; i++) {
            System.out.println("strlist2 [" + i + "] = " + strlist2[i]);
        }
        System.out.println("---------------------------------------");
        for (String str2 : strlist2) {
            System.out.println("str2 = " + str2);
        }
    }
}
