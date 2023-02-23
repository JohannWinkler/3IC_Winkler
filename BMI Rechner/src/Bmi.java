public class Bmi {
    private double weight;
    private double height;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    String calculateBmi() {

        double bmi = (this.weight / (this.height * this.height)) *10000;
        System.out.println("Your bmi is: " + String.format("%.2f", bmi));

        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    void invalidValueException() {
        System.out.println(ANSI_RED + "\nInvalid Input!\n" + ANSI_RESET);
        this.weight = 0;
        this.height = 0;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}