import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for student management operations.
 * Handles in-memory student operations (list, add, remove, export).
 */
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    /**
     * Prints all students to stdout.
     */
    public void printList() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }

    /**
     * Adds a student if the id is unique.
     *
     * @param studentId unique identifier for the student
     * @param name      student display name
     * @return true if the student was added, false if the id already exists
     */
    public boolean addStudent(String studentId, String name) {
        if (findById(studentId) != null) {
            return false;
        }
        students.add(new Student(studentId, name));
        return true;
    }

    /**
     * Removes a student by id.
     *
     * @param studentId id of the student to remove
     * @return true if the student was found and removed, false otherwise
     */
    public boolean removeStudent(String studentId) {
        Student student = findById(studentId);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }

    /**
     * Exports students to a CSV file.
     *
     * @param filePath output path for the CSV file
     * @throws IOException if the file cannot be written
     */
    public void exportStudentsCsv(String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("id,name");
            for (Student student : students) {
                writer.println(student.getStudentId() + "," + student.getName());
            }
        }
    }

    /**
     * Exports students to a JSON file.
     *
     * @param filePath output path for the JSON file
     * @throws IOException if the file cannot be written
     */
    public void exportStudentsJson(String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("[");
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                writer.print("  { \"id\": \"" + s.getStudentId()
                        + "\", \"name\": \"" + s.getName() + "\" }");
                if (i < students.size() - 1) {
                    writer.println(",");
                } else {
                    writer.println();
                }
            }
            writer.println("]");
        }
    }

    /**
     * Finds a student by id.
     *
     * @param studentId id to search for
     * @return the matching Student if found, otherwise null
     */
    private Student findById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
