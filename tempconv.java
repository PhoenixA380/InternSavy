package TemperatureConvertor;
import java.util.Scanner;

    public class tempconv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("****Temperature Convertor****");
        System.out.println("Choose from below: ");
        System.out.println("1. Fahrenheit to Celsius\n2. Celsius to Fahrenheit");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter temperature in F");
                int far = sc.nextInt();
                int cel = fartocel(far);
                System.out.println(far + " F is equal to " + cel + " C");
            }
            case 2 -> {
                System.out.println("Enter temperature in C");
                int cel = sc.nextInt();
                int far = celtofar(cel);
                System.out.println(cel + " C is equal to " + far + " F");
            }
            default -> System.out.println("enter a valid option");
        }
        sc.close();
    }

    public static int fartocel(int far) {
        return (int) ((far - 32) * 5.0 / 9.0);
    }

    public static int celtofar(int cel) {
        return (int) ((cel * 9.0 / 5.0) + 32);
    }
}
