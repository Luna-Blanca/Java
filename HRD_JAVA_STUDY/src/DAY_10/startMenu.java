package DAY_10;

public class startMenu {
    static String[] menu = {"Add List", "Show List", "Set List", "Delete List", "EXIT"};

    public void menu() {
        for (int i = 0; i < menu.length; i++) {
            System.out.print((i + 1) + " . " + menu[i] + "\n");
        }
    }

    public void line() {
        System.out.println("➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖");
    }

    public void printSystem(String message) {
        System.out.print("𝑺𝒀𝑺𝑻𝑬𝑴 : " + message);
    }

    public void printSystemln(String message) {
        System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : " + message);
    }
}
