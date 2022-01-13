package DAY_06;

public class Example3_switch실습 {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 100);
        int count = 0;
        if (num >= 90) {
            count = 1;
        } else if (89 >= num && num >= 80) {
            count = 2;
        } else if (79 >= num && num >= 70) {
            count = 3;
        } else if (69 >= num) {
            count = 4;
        }

        switch (count) {
            case 1:
                System.out.println("90점 이상입니다.");
                break;
            case 2:
                System.out.println("89 ~ 80점 사이입니다.");
                break;
            case 3:
                System.out.println("79 ~70점 사이입니다.");
                break;
            case 4:
                System.out.println("69 ~ 0점 사이입니다.");
                break;
        }
    }
}
