import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Students")
public class StudentList {
    private List<Student> students;

    public StudentList(List<Student> students) {
        this.students = students;
    }

    public StudentList() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
