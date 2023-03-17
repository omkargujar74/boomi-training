// Copyright (c) 2023 Boomi, Inc.

import model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author omkargujar.
 */
public class JsonDemo {

    static ObjectMapper _objectMapper = new ObjectMapper();
    static File _studentJson = new File("student.json");

    public static void main(String[] args) {
        objectToJson();
        jsonToObject();
    }

    public static void objectToJson() {
        Student student = new Student(1001, "Omkar", "Gujar", 23);
        List<Student> students = getStudents();
        try {
            String json = _objectMapper.writeValueAsString(student);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            _objectMapper.writeValue(_studentJson, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonToObject() {
        try {
            List<Student> students = _objectMapper.readValue(_studentJson, new TypeReference<List<Student>>() {
            });
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> getStudents() {
        return IntStream.range(1, 11).mapToObj(
                rollNumber -> new Student(rollNumber, "Student" + rollNumber, "LastName" + rollNumber,
                        new Random().nextInt(16))).collect(Collectors.toList());
    }
}
