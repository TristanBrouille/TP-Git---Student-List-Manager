/**
 * Represents one student.
 */
public class Student {

    private final String id;
    private final String name;

    public Student(String studentId, String name) {
        this.id = studentId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
