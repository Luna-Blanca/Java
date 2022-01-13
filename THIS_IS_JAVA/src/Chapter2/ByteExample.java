package Chapter2;

public class ByteExample {
    public static void main(String[] args) {
        byte var1 = -128;
        byte var2 = -30;
        byte var3 = 30;
        byte var4 = 127;

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println();

        byte var5 = 125;
        int var6 = 125;
        for(int i=0; i<5; i++) {
            var5++;
            var6++;
            System.out.println("var5 = " + var5 + "\t" + "var6 = " + var6);
        }
    }
}
