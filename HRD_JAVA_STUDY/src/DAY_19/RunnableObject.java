package DAY_19;

public class RunnableObject implements Runnable {
    String name;

    public RunnableObject() {

    }

    public RunnableObject(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println(" --> " + name + " start");

        for (int i = 0; i < 5; i++) {
            System.out.println(name + "이 달린다.");

        }
    }
}
