package DAY_12;

public class Bankman {
    AccountPaperVO paper;
    AccountPaperVO[] accountList = new AccountPaperVO[3];

    public void createAccountInto() {
        String[] nameList = {"Hong", "Kong", "Gong"};
        String[] numberList = {"3333-01-27893-92", "3333-01-21632-47", "3333-01-22743-33"};
        String[] passwordList = {"4719", "3315", "1234"};
        int[] moneyList = {50000, 37800, 47500};

        for (int i = 0; i < accountList.length; i++) {
            AccountPaperVO account = new AccountPaperVO();
            account.setName(nameList[i]);
            account.setNumber(numberList[i]);
            account.setPassword(passwordList[i]);
            account.setMoney(moneyList[i]);

            accountList[i] = account;
        }
    }

    public void showAccount() {
        System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 고객정보");
        System.out.printf("%-6s %-21s %-14s %-10s", "NAME", "| BANK-ACCOUNT", "| PASSWORD", "| CREDIT");
        System.out.println();
        for (AccountPaperVO i : accountList) {
            System.out.printf("%-7s", i.getName());
            System.out.printf("%-22s", "| " + i.getNumber());
            System.out.printf("%-15s", "| " + i.getPassword());
            System.out.printf("%-10s", "| " + i.getMoney());
            System.out.println();
        }
    }

    public void setAccountPaperVO(AccountPaperVO paper) {
        this.paper = paper;
    }

    public int checkPaper() {
        int check_result = 0;
        if (paper.getName() == null) {
            check_result = 1;
        } else if (paper.getNumber() == null) {
            check_result = 2;
        } else if (paper.getPassword() == null) {
            check_result = 3;
        } else if (paper.getMoney() == 0) {
            check_result = 4;
        } else {
            check_result = 5;
        }
        return check_result;
    }

    public void askInfo(int param) {
        switch (param) {
            case 1:
                System.out.println("이름을 작성해주세요.");
                break;
            case 2:
                System.out.println("계좌번호를 작성해주세요.");
                break;
            case 3:
                System.out.println("비밀번호를 작성해주세요.");
                break;
            case 4:
                System.out.println("금액이 빠져있습니다.");
                System.out.print("금액을 입력해주세요. > ");
                break;
            default:
                System.out.println("메뉴를 준비 중입니다.");
                break;
        }
    }

    public void setAccountPaperMoney(int money) {
        paper.setMoney(money);
    }

    public void changeProcess() {
        boolean account_check = false;
        int change = 0;

        for (AccountPaperVO account : accountList) {
            if (account.getName().equals(paper.getName()) && account.getNumber().equals(paper.getNumber()) && account.getPassword().equals(paper.getPassword())) {
                account_check = true;
                change = account.getMoney();
            } else {
                System.out.println("정보가 일치하지 않습니다.");
            }
        }

        if (account_check) {
            if (change >= paper.getMoney()) {
                // 출금 진행
                int money = change - paper.getMoney();
                System.out.println("요청하신 금액 " + paper.getMoney() + "원이 출금되었습니다.");
                System.out.println("잔고는 " + money + "원 입니다.");
            } else {
                // 잔액 부족
                System.out.println("잔고가 부족합니다.");
            }
        } else {
            System.out.println("고객 정보가 존재하지 않습니다.");
        }
    }
}
