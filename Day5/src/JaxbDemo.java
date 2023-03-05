import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JaxbDemo {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Omkar", "Gujar", 23);
        studentToXml(student1);
        Student fromXmlStudent = xmlToStudent();
        System.out.println("First Name = " + fromXmlStudent.getFirstName() + " Last Name = " + fromXmlStudent.getLastName() + " Age = " + fromXmlStudent.getAge());

        List<Student> students = getStudents();
        StudentList studentList = new StudentList(students);
        studentListToXml(studentList);
        StudentList fromXmlStudentList = xmlToStudentList();
        for (Student student : fromXmlStudentList.getStudents()) {
            System.out.println("First Name = " + student.getFirstName() + " Last Name = " + student.getLastName() + " Age = " + student.getAge());
        }
    }

    public static void studentToXml(Student student) {
        final String FILE_NAME = "Student.xml";
        File studentXml = new File(FILE_NAME);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(student, studentXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void studentListToXml(StudentList studentList) {
        final String FILE_NAME = "StudentList.xml";
        File studentListXml = new File(FILE_NAME);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(studentList, studentListXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static StudentList xmlToStudentList() {
        StudentList studentList = null;
        final String FILE_NAME = "StudentList.xml";
        File studentListXml = new File(FILE_NAME);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            studentList = (StudentList) unmarshaller.unmarshal(studentListXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static Student xmlToStudent() {
        Student student = null;
        final String FILE_NAME = "Student.xml";
        File studentXml = new File(FILE_NAME);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            student = (Student) unmarshaller.unmarshal(studentXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static List<Student> getStudents() {
        return IntStream.range(1, 11).mapToObj(rollNumber -> new Student(rollNumber, "Student" + rollNumber, "LastName" + rollNumber, new Random().nextInt(16))).collect(Collectors.toList());
    }
}
