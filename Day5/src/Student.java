import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Student {
    private int rollNumber;
    private String firstName;
    private String lastName;
    private int age;

    public Student(int rollNumber, String firstName, String lastName, int age) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student() {
    }

    //@XmlTransient //this field will not be part of marshaling
    public int getRollNumber() {
        return rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
