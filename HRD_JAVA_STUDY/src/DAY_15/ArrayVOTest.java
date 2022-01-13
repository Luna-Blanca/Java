package DAY_15;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayVOTest {

    static ArrayVO vo;
    static ArrayVO vo2 = new ArrayVO();

    public static void main(String[] args) {
        //ArrayVO 객체를 저장하는 ArrayList를 생성
        ArrayList<ArrayVO> list = new ArrayList<ArrayVO>();

        // 1차원 베열로 저장
        String[] namelist = {"MONG", "SONG", "KONG", "LONG", "JONG"};
        int[] agelist = {20, 30, 25, 22, 29};

        for (int i = 0; i < namelist.length; i++) {
            vo = new ArrayVO(namelist[i], agelist[i]);
            list.add(vo);
        }

        System.out.println("namelist[i] & agelist[i]");
        for (int i = 0; i < namelist.length; i++) {
            vo2.setName(namelist[i]);
            vo2.setAge(agelist[i]);
            System.out.println(namelist[i] + "\t" + agelist[i]);
        }
        System.out.println();

        System.out.println("ArrayVO i : list");
        for (ArrayVO i : list) {
            System.out.print(i.getName() + "\t");
            System.out.println(i.getAge() + "\t");
        }
        System.out.println();
        // [hong,30] , [song,20] , [test,25]
//        ArrayVO ar1 = new ArrayVO("MONG", 20);
//        ArrayVO ar2 = new ArrayVO("SONG");
//        ar2.setAge(30);
//
//        ArrayVO ar3 = new ArrayVO(25);
//        ar3.setName("KONG");
//
//        ArrayVO ar4 = new ArrayVO();
//        ar4.setName("LONG");
//        ar4.setAge(22);
//
//        list.add(ar1); list.add(ar2); list.add(ar3); list.add(ar4);
//        System.out.println("size : " + list.size());
//        System.out.println("name    age");
//        System.out.println("------------");

        // KONG 데이터를 TONG으로 변경
        // 내 버전
//        System.out.println("KONG의 데이터를 TONG으로 변경");
//        String[] namelist2 = new String[namelist.length];
//        int[] agelist2 = new int[agelist.length];
//        for (int i = 0; i < namelist.length; i++) {
//            if (namelist[i].equalsIgnoreCase("kong")) {
//                namelist2[i] = "TONG";
//                agelist2[i] = agelist[i];
//            } else {
//                namelist2[i] = namelist[i];
//                agelist2[i] = agelist[i];
//            }
//        }
//
//        int count = 0;
//        for (String i : namelist2) {
//            for (int j = count; j < count + 1; j++) {
//                System.out.println(i + "\t" + agelist2[j]);
//            }
//            count++;
//        }

        // 쌤 버전
//        for (ArrayVO vo : list) {
//            if (vo.getName().equals("KONG")) {
//                vo.setName("TONG");
//            }
//        }
//        for (ArrayVO vo : list) {
//            System.out.println(vo.getName() + "\t" + vo.getAge());
//        }

        // set 메소드 이용
        for (int i = 0; i < list.size(); i++) {
            ArrayVO vo = list.get(i);
            if (vo.getName().equals("KONG")) {
                //vo.setName("TONG"); =
                list.set(i, new ArrayVO("TONG", vo.getAge()));
            }
        }
        for (ArrayVO vo : list) {
            System.out.println(vo.getName() + "\t" + vo.getAge());
        }
        System.out.println();

        Iterator<ArrayVO> it = list.iterator();
        while (it.hasNext()) {
            ArrayVO vo = it.next();
            if (vo.getName().equals("SONG")) {
                it.remove();
            }
        }
        for (ArrayVO vo : list) {
            System.out.println(vo.getName() + "\t" + vo.getAge());
        }
    }
}
