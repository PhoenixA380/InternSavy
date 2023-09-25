package Calculator;
import java.util.Scanner;

interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}

class BasicCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Cannot divide by zero.");
            return Double.NaN;
        }
    }
}

public class calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new BasicCalculator();

        while (true) {
            System.out.println("\nBasic Calculator Menu:");
            System.out.println("\n1.add\n2.subtract\n3.multiply\n4.divide\n5.Exit");
            System.out.print("Select an option (1-5): ");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Calculator exited.");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            double result;

            switch (choice) {
                case 1 -> {
                    result = calculator.add(num1, num2);
                    System.out.println("Result: " + result);
                }
                case 2 -> {
                    result = calculator.subtract(num1, num2);
                    System.out.println("Result: " + result);
                }
                case 3 -> {
                    result = calculator.multiply(num1, num2);
                    System.out.println("Result: " + result);
                }
                case 4 -> {
                    result = calculator.divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println("Result: " + result);
                    }
                }

                default -> System.out.println("select a valid option");
            }
        }
        sc.close();
    }
}
