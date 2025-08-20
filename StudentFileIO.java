import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int rollNo;
    private String name;
    private String department;
    private double cgpa;

    public Student(int rollNo, String name, String department, double cgpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + department + " - " + cgpa;
    }
}

public class StudentFileIO {

    private static final String INPUT_FILE = "students.txt";
    private static final String SERIALIZED_FILE = "students.dat";
    private static final String IT_FILE = "IT_students.txt";
    private static final String LOG_FILE = "operations.log";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // (a) Read students.txt and store in ArrayList<Student>
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int rollNo = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String dept = parts[2].trim();
                double cgpa = Double.parseDouble(parts[3].trim());
                students.add(new Student(rollNo, name, dept, cgpa));
            }
            log("Read students from " + INPUT_FILE);
        } catch (IOException e) {
            log("Error reading " + INPUT_FILE + ": " + e.getMessage());
        }

        // (c) Serialize ArrayList<Student> into students.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE))) {
            oos.writeObject(students);
            log("Serialized student list into " + SERIALIZED_FILE);
        } catch (IOException e) {
            log("Error serializing students: " + e.getMessage());
        }

        // (d) Deserialize and display students
        List<Student> deserializedStudents = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZED_FILE))) {
            deserializedStudents = (List<Student>) ois.readObject();
            log("Deserialized student list from " + SERIALIZED_FILE);
        } catch (IOException | ClassNotFoundException e) {
            log("Error deserializing students: " + e.getMessage());
        }

        System.out.println("Deserialized Students:");
        if (deserializedStudents != null) {
            for (Student s : deserializedStudents) {
                System.out.println(s);
            }
        }

        // (e) Write IT students into IT_students.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(IT_FILE))) {
            for (Student s : students) {
                if ("IT".equalsIgnoreCase(s.getDepartment())) {
                    bw.write(s.toString());
                    bw.newLine();
                }
            }
            log("Wrote IT department students into " + IT_FILE);
        } catch (IOException e) {
            log("Error writing IT students: " + e.getMessage());
        }
    }

    // Logging function using byte stream
    private static void log(String message) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = "[" + timestamp + "] " + message + "\n";

        try (FileOutputStream fos = new FileOutputStream(LOG_FILE, true)) {
            fos.write(logMessage.getBytes());
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}
