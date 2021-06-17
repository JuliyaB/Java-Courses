package task_4.task_4_2;

public class Candy extends Sweets {

    private String color;

    public Candy(String name, double weight, double price, String color) {
        super(name, weight, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
