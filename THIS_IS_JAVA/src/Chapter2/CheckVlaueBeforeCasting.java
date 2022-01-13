package Chapter2;

public class CheckVlaueBeforeCasting {
    public static void main(String[] args) {
        int i = 128;

        if( (i<Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) {
            System.out.println("변환할 수 없는 타입입니다.");
            System.out.println("다시 한번 확인해주세요.");
        } else {
            byte b = (byte) i;
            System.out.println(b);
        }
    }
}
