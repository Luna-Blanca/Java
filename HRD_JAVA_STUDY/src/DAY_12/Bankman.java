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
        System.out.println("πΊππΊπ»π¬π΄ : κ³ κ°μ λ³΄");
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
                System.out.println("μ΄λ¦μ μμ±ν΄μ£ΌμΈμ.");
                break;
            case 2:
                System.out.println("κ³μ’λ²νΈλ₯Ό μμ±ν΄μ£ΌμΈμ.");
                break;
            case 3:
                System.out.println("λΉλ°λ²νΈλ₯Ό μμ±ν΄μ£ΌμΈμ.");
                break;
            case 4:
                System.out.println("κΈμ‘μ΄ λΉ μ Έμμ΅λλ€.");
                System.out.print("κΈμ‘μ μλ ₯ν΄μ£ΌμΈμ. > ");
                break;
            default:
                System.out.println("λ©λ΄λ₯Ό μ€λΉ μ€μλλ€.");
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
                System.out.println("μ λ³΄κ° μΌμΉνμ§ μμ΅λλ€.");
            }
        }

        if (account_check) {
            if (change >= paper.getMoney()) {
                // μΆκΈ μ§ν
                int money = change - paper.getMoney();
                System.out.println("μμ²­νμ  κΈμ‘ " + paper.getMoney() + "μμ΄ μΆκΈλμμ΅λλ€.");
                System.out.println("μκ³ λ " + money + "μ μλλ€.");
            } else {
                // μμ‘ λΆμ‘±
                System.out.println("μκ³ κ° λΆμ‘±ν©λλ€.");
            }
        } else {
            System.out.println("κ³ κ° μ λ³΄κ° μ‘΄μ¬νμ§ μμ΅λλ€.");
        }
    }
}
