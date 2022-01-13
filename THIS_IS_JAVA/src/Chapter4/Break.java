package Chapter4;

public class Break {
    public static void main(String[] args) {
        while(true) {
            int num = (int)(Math.random()*6) + 1;
            System.out.println("이번 주사위의 수는  : " + num);
            /*
            try{
                Thread.sleep(1,500000);
            } catch(InterruptedException e) {}
             */
            if(num == 6) {
                break;
            }
        }
        System.out.println("주사위의 수가 6이 나와 프로그램을 종료합니다.");
    }
}
