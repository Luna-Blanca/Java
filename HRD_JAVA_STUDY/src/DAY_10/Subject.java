package DAY_10;

public class Subject {
    static final String[] subject = {"C", "C++", "C#", "JAVA", "Python"};
    static final String[] student = new String[10];
    static int[][] scores = new int[student.length][subject.length];
    static int count = 0;

    public static int studentCount() {
        //String[] student = new String[10];
        return student.length;
    }

    public static int subjectCount() {
        //String[] subject = {"C", "C++", "C#", "JAVA", "Python"};
        return subject.length;
    }
}
