package task_4.task_4_2;

public class Jellybean extends Sweets {

    private String form;

    public Jellybean(String name, double weight, double price, String form) {
        super(name, weight, price);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
