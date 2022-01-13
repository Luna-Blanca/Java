package DAY_19;

public class ThreadTest1 {
    public static void main(String[] args) {
        ThreadObject hong = new ThreadObject("홍길동");
        hong.start();

        ThreadObject kong = new ThreadObject("김철수");
        kong.start();
    }
}
