package Chapter3;

public class RandomTime {
    public static void main(String[] args) {
        int time = (int) (Math.random() * 12.13);
        int min = (int) (Math.random() * 60.6);

        System.out.println("[현재시간 = " + time + "시 " + min + "분]");
    }
}
