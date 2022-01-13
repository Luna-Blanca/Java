package DAY_12;

import java.util.Scanner;

public class Customer {
    AccountPaperVO paper;
    Scanner scan = new Scanner(System.in);

    public void setPaper(AccountPaperVO paper) {
        System.out.print("이름 > ");
        paper.setName(scan.nextLine());
        System.out.print("계좌 > ");
        paper.setNumber(scan.nextLine());
        System.out.print("비밀번호 > ");
        paper.setPassword(scan.nextLine());
        System.out.print("금액 : ");
        paper.setMoney(scan.nextInt());
        scan.nextLine();

        this.paper = paper;
    }

    public AccountPaperVO getPaper() {
        return paper;
    }

    public int answerMoney() {
        scan.nextInt();
        return paper.getMoney();
    }

    public void confirmChange() {

    }
}
