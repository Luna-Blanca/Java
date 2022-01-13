package DAY_16;

import java.util.ArrayList;

public class 병원관리시스템Test {
    public static void main(String[] args) {
        병원관리시스템 hms = new 병원관리시스템();
        Person person = new Person();

        Person 하얀달 = new Person("White Moon", 24, Animal.PERSON);
        Animal 붉은달 = new Person("Red Moon", 27, Animal.PERSON);
        Dog 허스키 = new Dog("Husky", 7, Animal.DOG);
        Animal 리트리버 = new Dog("Retriever", 7, Animal.DOG);
        Cat 샴 = new Cat("Siamese", 5, Animal.CAT);
        Animal 페르시안 = new Cat("Persian", 9, Animal.CAT);
        하얀달.setAddress("수원시 팔달구 고등동 청호아파트");

        hms.addList(하얀달);
        hms.addList(붉은달);
        hms.addList(허스키);
        hms.addList(리트리버);
        hms.addList(샴);
        hms.addList(페르시안);

        /** 출력 **/
        ArrayList<Animal> mlist = hms.getMedical_card_list();
        System.out.println("list size = " + mlist.size());
        System.out.println("# 진료 기록 목록");
        System.out.printf("%-12s %-5s %-8s %-8s %-30s\n", "NAME", "AGE", "NUMBER", "TYPE", "ADDRESS");
        for (Animal animal : mlist) {
            System.out.printf("%-12s %-5s %-9s", animal.getName(), animal.getAge(), animal.getType());
            if (animal.getType() == 1) {
                System.out.print("PEOPLE");
            } else if (animal.getType() == 2) {
                System.out.print("DOG");
            } else if (animal.getType() == 3) {
                System.out.print("CAT");
            }

            if (animal.getName().equalsIgnoreCase("하얀달")) {
                Person hong = (Person) animal;
                System.out.println("\t" + hong.getName() + "\t");
                System.out.println(hong.getAge() + "\t");
                System.out.println("사람\t");
                System.out.println(hong.getAddress() + "\n");
            }

//            if (animal.getName().equalsIgnoreCase(person.getName())) {
//                System.out.println(person.getAddress());
//            } else {
//                System.out.println();
//            }
        }
    }
}
