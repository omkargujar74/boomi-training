import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomSetTest {
    public static void main(String[] args) {
        Set<Student> set = new CustomSet<>();
        Student student1 = new Student(1, "Student1");
        Student student2 = new Student(2, "Student2");
        Student student3 = new Student(3, "Student3");
        Student student4 = new Student(4, "Student4");

        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student1);
        set.add(student4);
        set.add(student2);


        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        set.remove(student1);
        System.out.println("is Set contains Student1 = " + set.contains(student1));
        System.out.println("After Deletion.......");
        System.out.println(set);
        set.clear();


    }

    public static List<Student> getStudents() {
        return IntStream.range(1, 11)
                .mapToObj(rollNumber -> new Student(rollNumber, "Student" + rollNumber))
                .collect(Collectors.toList());
    }
}