import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

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

    public boolean addStudent(String studentId, String name) {
        if (findById(studentId) != null) {
            return false;
        }
        students.add(new Student(studentId, name));
        return true;
    }

    public boolean removeStudent(String studentId) {
        Student std = findById(studentId);
        if (std != null){
            students.remove(std);
            return true;
        }
        return false;
    }

    public void exportStudentsJson(String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("[");
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                writer.print("  { \"id\": \"" + s.getId()
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

    private Student findById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
