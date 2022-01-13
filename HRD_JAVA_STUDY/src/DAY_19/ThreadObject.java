package DAY_19;

public class ThreadObject extends Thread {
//    public void test() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i = " + i);
//        }
//    }

    String name;

    public ThreadObject() {

    }

    public ThreadObject(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(" -- > " + name + " START");

//        for (int i = 0; i < 5; i++) {
//            System.out.println(name + "이 달린다. " + i);
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + "이 달린다. " + i);
                sleep(800);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" -- > " + name + " END");
    }
}
