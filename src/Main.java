import java.io.IOException;
import java.util.Scanner;

/**
 * Command-line interface for the student manager application.
 */
public class Main {

    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student List Manager");
        System.out.println("Type 'help' to show commands.");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+", 3);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "help":
                    printHelp();
                    break;

                case "list":
                    service.printList();
                    break;

                case "add":
                    if (parts.length < 3) {
                        System.out.println("Usage: add <id> <name>");
                        break;
                    }
                    if (service.addStudent(parts[1], parts[2])) {
                        System.out.println("Student '" + parts[2] + "' added.");
                    } else {
                        System.out.println("A student with id '" + parts[1] + "' already exists.");
                    }
                    break;

                case "remove":
                    if (parts.length < 2) {
                        System.out.println("Usage: remove <id>");
                        break;
                    }
                    if (service.removeStudent(parts[1])) {
                        System.out.println("Student with id '" + parts[1] + "' removed.");
                    } else {
                        System.out.println("No student found with id '" + parts[1] + "'.");
                    }
                    break;
            }
        }
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  list");
        System.out.println("  add <id> <name>");
        System.out.println("  remove <id>");
        System.out.println("  export <format> <file_path>  (formats: csv, json)");
        System.out.println("  help");
        System.out.println("  quit");
    }
}
