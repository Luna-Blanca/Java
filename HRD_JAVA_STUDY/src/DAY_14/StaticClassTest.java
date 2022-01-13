package DAY_14;

public class StaticClassTest {
    public static void main(String[] args) {
        StaticClass st = new StaticClass();

        System.out.println("st.value===>" + st.value);
        System.out.println("st.number===>" + st.number);
        System.out.println("StaticClass.number===>" + StaticClass.number);
        //System.out.println("StaticClass.value===>" + StaticClass.value);
        System.out.println("----------------------------------");
        System.out.println("st.getValue()--->" + st.getValue());
        System.out.println("st.getNumber()--->" + st.getNumber());
        //System.out.println("StaticClass.getValue()--->" + StaticClass.getValue());
        System.out.println("StaticClass.getNumber()--->" + StaticClass.getNumber());

    }
}
