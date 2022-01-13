package DAY_19;

public class SyncThreadTest {
    public static void main(String[] args) {
        RestRoom restRoom = new RestRoom();

        FamilyThread tf1 = new FamilyThread("아빠", restRoom);
        FamilyThread tf2 = new FamilyThread("엄마", restRoom);
        FamilyThread tf3 = new FamilyThread("아들", restRoom);
        tf1.start();
        tf2.start();
        tf3.start();
    }
}
