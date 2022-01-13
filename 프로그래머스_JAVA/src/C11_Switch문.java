public class C11_Switch문 {
    public static void main(String[] args) {
        int num;
        do {
            num = (int)(Math.random() * 100);
            System.out.println("랜덤으로 걸린 숫자는 " + num);
        } while ( num != 10);
    }
}
