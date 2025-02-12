import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Note Management System");
        while (true){
            System.out.println("Enter your username");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();

            System.out.println("Enter your password");
            Scanner scanner1 = new Scanner(System.in);
            String password = scanner1.nextLine();

            Logger logger = new Logger();
            if(username.equals("admin") && password.equals("admin")){
                AdminInterface admin = new AdminInterface();
                admin.AdminInterface();
            }
            else if(logger.LogAuth(username, password)){
                System.out.println("Logged in");
                int id = logger.getId(username);

                Note note = new Note();
                note.NoteInterface(id);
            }
        }
    }
}
