package StudentManagementSystemTask5;
import java.util.*;
import java.io.*;
public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.csv";
    // Adding a student
    public void addStudent(Student s) {
        students.add(s);
    }

    // Removing a student by the roll number
    public void removeStudent(int roll) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == roll) {
                students.remove(i);
                break;
            }
        }
    }

    // Searching the student by the roll number
    public Student searchStudent(int roll) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                return s;
            }
        }
        return null;
    }

    // Displaying all students
    public void displayStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
    
    // Get all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Save all students to CSV
    public void saveToCSV() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            pw.println("roll,name,grade,email,phone"); // header
            for (Student s : students) {
                pw.println(s.getName() + "," + s.getRollNumber() + "," +
                        s.getGrade() + "," + s.getEmail() + "," + s.getPhone());
            }
        }
    }

    // Load students from CSV
    public void loadFromCSV() throws IOException {
        students.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return; 

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int roll = Integer.parseInt(parts[0]);
                    students.add(new Student(parts[1], roll, parts[2], parts[3], parts[4]));
                }
            }
        }
    }
}
