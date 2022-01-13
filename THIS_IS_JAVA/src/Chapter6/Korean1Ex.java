package Chapter6;

public class Korean1Ex {
    public static void main(String[] args) {
        Korean1 kr = new Korean1("Luna Blanca", "980223-1192214");
        System.out.println("Korean1_name \t" + kr.name);
        System.out.println("Korean1_ssn \t" + kr.ssn);
        System.out.println(" ");

        Korean1 kr2 = new Korean1("Sole nero", "980721-1273392");
        System.out.println("Korean2_name \t" + kr2.name);
        System.out.println("Korean2_ssn \t" + kr2.ssn);
    }
}
