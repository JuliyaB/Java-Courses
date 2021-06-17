package task_4.task_4_2;

/**
 * @author Juliya Bondarenko
 */

public class NewYearGift {
    public static void main(String[] args) {

        double sum = 0, weight = 0;

        Candy candy1 = new Candy("Lemon Villa", 5.5, 34.7, "Yellow");
        Candy candy2 = new Candy("Dark night", 15, 60, "Black");
        Candy candy3 = new Candy("Zernushka", 10.8, 78, "White");
        Jellybean jellybean1 = new Jellybean("Niels", 8.65, 20, "Round");
        Jellybean jellybean2 = new Jellybean("Boom note", 8, 65.89, "Oval");
        Jellybean jellybean3 = new Jellybean("Happy day", 17.89, 70, "Square");

        Sweets[] gift = {candy1, candy2, candy3, jellybean1, jellybean2, jellybean3};
        System.out.println("The gift consists of: ");
        for (Sweets sweets : gift) {
            System.out.println(sweets.getName());
            sum += sweets.getPrice();
            weight += sweets.getWeight();
        }
        System.out.println("Total weight: " + weight);
        System.out.println("Total cost: " + sum);
    }
}
