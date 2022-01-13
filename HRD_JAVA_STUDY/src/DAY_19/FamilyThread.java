package DAY_19;

public class FamilyThread extends Thread {
    String name;
    RestRoom restRoom;

    public FamilyThread(String name, RestRoom restRoom) {
        this.name = name;
        this.restRoom = restRoom;
    }

    public void run() {
        System.out.println(name + " --> 퇴장");
        for (int i = 0; i < 5; i++) {
            restRoom.openDoor(name);
        }
        System.out.println(name + " --> 입장");
    }
}
