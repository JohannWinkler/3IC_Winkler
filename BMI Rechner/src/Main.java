import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bmi bmi = new Bmi();
        boolean correctInput = true;

        while (correctInput) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Your height in cm:");
                bmi.setHeight(scanner.nextDouble());
                System.out.println("Your weight in kg:");
                bmi.setWeight(scanner.nextDouble());
                System.out.println("\nInput Value: Height: " + bmi.getHeight() + "cm, Weight: " + bmi.getWeight() + "kg");
                correctInput = false;
            } catch (Exception e) {
                bmi.invalidValueException();
            }
        }

        System.out.println(bmi.calculateBmi());
    }
}