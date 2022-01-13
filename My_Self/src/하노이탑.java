public class 하노이탑 {
    public static int hanoi(int n, char from, char by, char to) {
        System.out.println(from + "에서 " + to + "로 옮기세요.");
        if (n == 1) {
            return 1;
        }
        int count = 0;
        count += hanoi(n - 1, from, to, by);
        count += 1;
        count += hanoi((n - 1), by, from, to);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hanoi(3, 'A', 'B', 'C'));
    }
}