package StudentManagementSystemTask5;
import java.io.Serializable;
public class Student implements Serializable{
    private String name;
    private int rollNumber;
    private String grade;
    private String email;
    private String phoneNumber;

    //Constructor to initialize the member variables
    public Student(String name, int rollNumber, String grade, String email, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //getters and setters methods for the member variables
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phoneNumber; }
    public void setPhone(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return rollNumber + " - " + name + " (" + grade + ")";
    }
}
