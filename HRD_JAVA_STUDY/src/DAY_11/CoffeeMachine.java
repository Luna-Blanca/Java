package DAY_11;

import java.util.Scanner;

public class CoffeeMachine {
    //Field
//	커피자판기의 메뉴는 아메리카노(400), 밀크커피(300), 유자차(200), 우유(200) 이다.
    MenuVO[] menulist;
    MenuVO[] orderlist = new MenuVO[10]; //주문한 메뉴 저장
    int coin, count;
    Scanner scan; // = new Scanner(System.in);

    //Constructor
    //Method

    /**
     * 메뉴를 생성한다.
     */
    public CoffeeMachine() {
        orderlist = new MenuVO[10];
        scan = new Scanner(System.in);
        //하나의 메뉴를  MenuVO 타입의 객체로 생성하고, menulist에 저장
        String[] namelist = {"아메리카노", "밀크커피", "유자차", "우유"};
        int[] pricelist = {400, 300, 200, 200};
        menulist = new MenuVO[namelist.length];

        for (int i = 0; i < namelist.length; i++) {
            MenuVO menu = new MenuVO();
            menu.setName(namelist[i]);
            menu.setPrice(pricelist[i]);

            menulist[i] = menu;
        }

    }

    /**
     * 메뉴를 출력한다.
     */
    public void showMenu() {
        System.out.println("====================================");
        System.out.println("\t평창 휴게소 음료 자판기 ");
        System.out.println("====================================");

        int i = 1;
        for (MenuVO menu : menulist) {
            System.out.print(i + ". " + menu.getName() + "(" + menu.getPrice() + ")\n");
            i++;
        }
        System.out.println("-------------------------------------");
        System.out.println(i + ". 종료");
        System.out.println("====================================");

        coinCheck();
    }


    /**
     * 동전을 입력받아 최저 금액을 체크한다.
     */
    public void coinCheck() {
        System.out.print("동전입력>>");
        coin += scan.nextInt();

        System.out.println("coin--->>" + coin);
        int min_price = menulist[menulist.length - 1].getPrice();
        if (coin >= min_price) {
            //주문가능 메뉴 출력
            showOrderMenu();
        } else {
            //금액 부족
            System.out.println("금액이 부족합니다");
            coinCheck();
        }
    }


    /**
     * 주문 가능 메뉴를 출력한다.
     */
    public void showOrderMenu() {
        if (coin >= 400) {
            System.out.println("주문가능 메뉴---->> [1.아메리카노],[2.밀크커피], [3.유자차],[4.우유]");
        } else if (coin < 400 && coin >= 300) {
            System.out.println("주문가능 메뉴---->> [2.밀크커피], [3.유자차],[4.우유]");
        } else if (coin < 300 && coin >= 200) {
            System.out.println("주문가능 메뉴---->> [3.유자차],[4.우유]");
        }

        orderMenu();
    }

    private void checkMenu(int menu) {
        int menu_price = menulist[menu-1].getPrice();
        if (coin >= menu_price) {
            orderlist[count] = menulist[menu - 1];
            count++;
            orderConfirm();
        } else {
            System.out.println("주문이 가능하지 않습니다. 다른 메뉴를 주문해주세요.");
            orderMenu();
        }
    }

    /**
     * 메뉴를 주문(선택)한다.
     */
    public void orderMenu() {
        System.out.print("메뉴를 선택해주세요(번호)>>");
        int menu = scan.nextInt();

        if (menu >= 1 && menu <= 4) {
            checkMenu(menu);
            //음료선택
            orderlist[count] = menulist[menu - 1];
            count++;
            orderConfirm();
        } else if (menu == 5) {
            quit();
        } else {
            System.out.println("-- 메뉴 준비중입니다. --");
            orderMenu();
        }
    }

    /**
     * 주문을 확인 후 잔돈을 계산한다.
     */
    public void orderConfirm() {
        //주문한 내역을 출력한다
        String tmenu = "";
        int tot_price = 0;

        for (MenuVO omenu : orderlist) {
            if (omenu != null) {
                tmenu += "[" + omenu.getName() + "]";
                tot_price += omenu.getPrice();
            }
        }
        System.out.println("주문한 메뉴는 " + tmenu + "입니다.");


        //잔돈을 계산하고, 최저금액보다 높으면 추가 주문 메시지를 출력
        int change = coin - tot_price;
        int min_price = menulist[menulist.length - 1].getPrice();
        if (change >= min_price) {
            System.out.println("추가 주문을 진행하시겠습니까(Y/N) > ");
            String choice = scan.next();
            if (choice.equals("y")) {
                coin = change;
                orderMenu();
            } else {
                orderFinish(change);
            }

        } else {
            orderFinish(change);
        }
    }


    /**
     * 잔돈 확인 후 추가주문 여부 출력 및 선택 후 음료를 전달한다.
     */
    public void orderFinish(int change) {
        String menu = "";

        for (MenuVO omenu : orderlist) {
            if (omenu != null) {
                menu += "[" + omenu.getName() + "]";
            }
        }
        MenuVO omenu = orderlist[0];
        System.out.println("주문하신 " + menu + "를 드립니다~");
        System.out.println("잔돈은 " + change + "원 입니다.");
        coin = 0;
        quit();
    }

    /**
     * 프로그램 종료
     */
    public void quit() {
        if (coin != 0) System.out.println("동전 반환--->> " + coin);
        System.out.println("-- 프로그램을 종료합니다 --");
        System.exit(0);
    }

}
