package DAY_13;

public class OverloadingObject {
    private double value;
    private int number;

    public void setValue(double value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public double getValue() {
        return value;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber(double number) {
        this.number = (int)number;
    }

    public void setNumber(int x, int y) {
        this.number = x + y;
    }

    public void setNumber(String number) {
        this.number = Integer.parseInt(number);
    }
}
