public class main {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item);
        System.out.println("item's name = " + item.name);

        item = null;
        System.out.println("item's name = " + item.name);
    }
}
