import java.util.Scanner;

public class AdminInterface {
    public void AdminInterface() {
        System.out.println("Admin Interface");

        System.out.println("1. Add user");
        System.out.println("2. Delete user");
        System.out.println("3. Exit");

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();

        while (true) {
            int choice = input.nextInt();
            if (choice == 1) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter username");
                String username = scanner.nextLine();

                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter password");
                String password = scanner1.nextLine();

                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter email");
                String email = scanner2.nextLine();

                admin.addUser(username, password, email);
            }
            else if (choice == 2) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter username");
                String username = scanner.nextLine();

                admin.deleteUser(username);
            }
            else if (choice == 3) {
                break;
            }
        }
    }
}
