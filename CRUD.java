package CRUD;
import java.util.*;

public class CRUD {
    private static final List<String> items = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("\nCRUD Application Menu:");
            System.out.println("1. Create\n2. Read\n3. Update\n4. Delete\n5.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createItem();
                case 2 -> readItems();
                case 3 -> updateItem();
                case 4 -> deleteItem();
                case 5 -> run = false;
                default -> System.out.println("Invalid Input");
            }
        }
    }

    private static void createItem() {
        System.out.print("Type the line ");
        String newItem = sc.nextLine();
        items.add(newItem);
        System.out.println("Line added successfully.");
    }

    private static void readItems() {
        System.out.println("\nLines in the list:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    private static void updateItem() {
        System.out.print("Mention the index");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 1 && index <= items.size()) {
            System.out.print("Enter the updated Line: ");
            String updatedItem = sc.nextLine();
            items.set(index - 1, updatedItem);
            System.out.println("Line updated successfully.");
        } else {
            System.out.println("Enter a valid index");
        }
    }

    private static void deleteItem() {
        System.out.print("Enter the index of the Line to be delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 1 && index <= items.size()) {
            String deletedItem = items.remove(index - 1);
            System.out.println("Line '" + deletedItem + "' deleted successfully.");
        } else {
            System.out.println("Enter a valid index");
        }
    }
}
