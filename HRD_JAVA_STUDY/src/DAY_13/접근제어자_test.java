package DAY_13;

public class 접근제어자_test {
    public static void main(String[] args) {
        접근제어자 obj = new 접근제어자();
        InfoObject iobj = new InfoObject();

        iobj.setMoney(100000);
        iobj.setName("Kong");
        obj.name = "Luna Blanca";
        obj.age = 30;

        System.out.println("obj.name = " + obj.name);
        System.out.println("obj.getName() = " + obj.getName());
        System.out.println("obj.age = " + obj.age);
        System.out.println("obj.getAge() = " + obj.getAge());
        System.out.println("obj.address = " + obj.adress);
        System.out.println("obj.getAddress() = " + obj.getAdress());
        System.out.println("obj.getMoney() = " + obj.getMoney());

    }
}
