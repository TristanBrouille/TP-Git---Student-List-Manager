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

    }

    /**
     * Adds a student if the id is unique.
     *
     * @param studentId unique identifier for the student
     * @param name      student display name
     * @return true if the student was added, false if the id already exists
     */
    public boolean addStudent(String studentId, String name) {
        return false;
    }

    /**
     * Removes a student by id.
     *
     * @param studentId id of the student to remove
     * @return true if the student was found and removed, false otherwise
     */
    public boolean removeStudent(String studentId) {
        return false;
    }
}
