package Chapter6;

public class FieldInValueEx {
    public static void main(String[] args) {
        FieldInValue fiv = new FieldInValue();

        System.out.println("byte \t" + fiv.byteField);
        System.out.println("short \t" + fiv.shortField);
        System.out.println("int \t" + fiv.intField);
        System.out.println("long \t" + fiv.longField);
        System.out.println("boolean \t" + fiv.booleanField);
        System.out.println("char \t" + fiv.charField);
        System.out.println("float \t" + fiv.floatField);
        System.out.println("double \t" + fiv.doubleField);
        System.out.println("int[] \t" + fiv.arrField);
        System.out.println("String \t" + fiv.referenceField);
    }
}
