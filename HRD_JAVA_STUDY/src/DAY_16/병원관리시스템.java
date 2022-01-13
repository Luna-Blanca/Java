package DAY_16;

import java.util.ArrayList;

public class 병원관리시스템 {
    ArrayList<Animal> medical_card_list;

    public 병원관리시스템() {
        medical_card_list = new ArrayList<Animal>(5);
    }

    public ArrayList<Animal> getMedical_card_list() {
        return medical_card_list;
    }

    public void addList(Animal animal) { // 왜 이 부분 자식 클래스인 person이 아니라 부모 클래스인 animal인가?
        medical_card_list.add(animal);
    }
}
