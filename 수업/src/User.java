
public class User {
/*
 * User클래스를 만드세요.  변수는  id, password, name,    
                       메소드는 public boolean login(String inputId, String inputPw)
                       생성자는 id만 받는 것, id와 password를 받는것 2개 생성
    User인스턴스 하나에 로그인을 시도하고 결과를 콘솔에 보여주세요.
 * 
 */
    String id;
    String password;
    String name;
    
    
    public User(String id) {
        super();
        this.id = id;
    }

    public User(String id, String password) {
        super();
        this.id = id;
        this.password = password;
    }




    public boolean login(String inputId, String inputPw) {
        if(inputId.equals(id)) {    //아이디는 같다.
            if(inputPw.equals(password)) {  //비밀번호 같다.
                System.out.println("로그인이 통과되었습니다.");
                return true;    //로그인 통과
            }
            else {
                System.out.println("아이디는 같지만 비밀번호가 틀립니다.");
            }
        }
        System.out.println("아이디가 틀렸습니다.");
        return false;
    }
    
}
