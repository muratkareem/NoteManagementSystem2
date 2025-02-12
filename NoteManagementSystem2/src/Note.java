import java.util.Scanner;

public class Note {
    public void NoteInterface(int user_id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add Note");
        System.out.println("2. View Notes");
        System.out.println("3. Edit Note");
        System.out.println("4. Delete Note");
        System.out.println("5. Search Note by ID");
        System.out.println("6. Search Note by Title");
        System.out.println("7. Exit");

        NoteManager noteManage = new NoteManager();

        while (true) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            if(choice == 1) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Enter Note Title: ");
                String content = scanner1.nextLine();

                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Enter Note Content: ");
                String title = scanner2.nextLine();

                noteManage.addNote(user_id, title, content);
            }
            else if(choice == 2) {
                noteManage.viewNotes(user_id);
            }
            else if(choice == 3) {
                System.out.print("Enter Note id: ");
                Scanner scanner1 = new Scanner(System.in);
                int id = scanner1.nextInt();

                System.out.print("Enter content: ");
                Scanner contentScanner = new Scanner(System.in);
                String content = contentScanner.nextLine();

                noteManage.editNote(id, content);
            }
            else if(choice == 4) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Enter Note id: ");
                int id = scanner1.nextInt();
                noteManage.deleteNote(id);
            }
            else if(choice == 5) {
                System.out.print("Enter Note ID: ");
                Scanner scanner1 = new Scanner(System.in);
                int noteId = scanner1.nextInt();
                noteManage.searchNoteById(noteId, user_id);
            }
            else if(choice == 6) {
                System.out.print("Enter Note Title: ");
                Scanner scanner1 = new Scanner(System.in);
                String title = scanner1.nextLine();
                noteManage.searchNoteByTitle(title, user_id);
            }
            else if(choice == 7) {
                break;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }
}