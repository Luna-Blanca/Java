package KeyCap;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
    private String address;
    private String detailAddress;
    private String id;
    private String password;
    private String name;
    private String number;
    private String email;
    private String gender;
    private final ArrayList<Order> orders = new ArrayList<>();


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String emailRegex = "[0-9a-zA-Z]([-.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}";
        if(Pattern.matches(emailRegex, email)) {
            this.email = email;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void deleteOrder() {
        orders.clear();
    }
    public Order getFirstOrder(){
        if(orders.isEmpty())
            return null;
        return orders.get(0);
    }
}
