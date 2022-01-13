public class C06_산술연산자 {
    public static void main(String[] args) {
        int i1 = -5;
        int i2 = -i1;
        int i3 = -5;
        System.out.println(i2);

        int i4 = ++i3;
        int i5 = i3++;
        System.out.println("++i3 = " + i4);
        System.out.println("++i3 = " + i3);
        System.out.println("i3++ = " + i5);
        System.out.println("++i3 = " + i3);
    }
}
