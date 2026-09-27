import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static LinkedList list = new LinkedList();

    public static void main(String[] args) {
        // Data Dummy
        list.insertNode(new Node(10));
        list.insertNode(new Node(20));
        list.insertNode(new Node(30));

        int choice;
        do {
            clearScreen();         
            printMenu();
            System.out.print("Choose menu: ");
            choice = readInt();

            clearScreen();         
            switch (choice) {
                case 1:
                    insertNodeMenu();
                    break;
                case 2:
                    insertAtMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 5:
                    System.out.println("=== LINKED LIST CONTENT ===");
                    list.displayLinkedList();
                    break;
                case 6:
                    System.out.println("Number of nodes: " + list.count());
                    break;
                case 0:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Menu not available.");
            }

            if (choice != 0) {
                pause();          
            }
        } while (choice != 0);
    }

    // Prints the menu options.
    static void printMenu() {
        System.out.println("========================================");
        System.out.println("         LINKED LIST - MAIN MENU        ");
        System.out.println("========================================");
        System.out.println(" 1. Insert node (append at the back)");
        System.out.println(" 2. Insert at index");
        System.out.println(" 3. Delete node");
        System.out.println(" 4. Search node");
        System.out.println(" 5. Display list");
        System.out.println(" 6. Count node");
        System.out.println(" 0. Exit");
        System.out.println("========================================");
    }

    static void insertNodeMenu() {
        System.out.println("=== INSERT NODE ===");
        System.out.print("Enter data: ");
        int data = readInt();
        list.insertNode(new Node(data));
        System.out.println("Data " + data + " added successfully.");
    }

    static void insertAtMenu() {
        System.out.println("=== INSERT AT INDEX ===");
        System.out.print("Enter index: ");
        int index = readInt();
        System.out.print("Enter data : ");
        int data = readInt();
        list.insertAt(index, new Node(data));
    }

    static void deleteMenu() {
        System.out.println("=== DELETE NODE ===");
        System.out.print("Enter data to delete: ");
        int data = readInt();
        list.delete(data);
    }

    static void searchMenu() {
        System.out.println("=== SEARCH NODE ===");
        System.out.print("Enter data to search: ");
        int data = readInt();
        list.searchLinkedList(data);
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause() {
        System.out.print("\nPress Enter to return to the menu...");
        input.nextLine();
    }

    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Input must be a number. Try again: ");
            }
        }
    }
}
