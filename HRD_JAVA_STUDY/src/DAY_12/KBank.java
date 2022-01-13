package DAY_12;

public class KBank {
    public static void main(String[] args) {
        AccountPaperVO paper = new AccountPaperVO();
        Bankman 직원 = new Bankman();

        직원.createAccountInto();
        직원.showAccount();

        Customer Park = new Customer();
        Park.setPaper(paper);
        직원.setAccountPaperVO(Park.getPaper());
        int check_result = 직원.checkPaper();
        if (check_result != 0) {
            직원.askInfo(check_result);
            직원.setAccountPaperMoney(Park.answerMoney());
            직원.changeProcess();
        }
        직원.setAccountPaperMoney(Park.answerMoney());
    }
}
