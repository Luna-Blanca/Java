package Chapter3;

public class InputDataCheckNaN2 {
    public static void main(String[] args) {
        String userInput = "NaN";
        double val = Double.valueOf(userInput);

        double currentBalance = 10000.0;

        if(Double.isNaN(val)) {
            System.out.println("NaN이 입력되어 처리할 수 없습니다.");
            val = 0.0;
        }

        currentBalance += val;
        System.out.println(currentBalance);
    }
}
