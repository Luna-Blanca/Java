public class C05_기본형타입변환 {
    public static void main(String[] args) {
        int x = 50000;
        long y = x;  //묵시적 형변환

        long x2 = 5;
        int y2 = (int) x2; // 강제 형변환
    }
}
