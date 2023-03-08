package com.boomi.w2day1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentList {
    public static Student getStudentById(int id)
    {
        List<Student> studentList = getStudentList();
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext())
        {
            Student student = iterator.next();
            if (student.getId() == id)
            {
                return student;
            }
        }
        return null;
    }
    public static List<Student> getStudentList(){
        return IntStream.range(1,11)
                .mapToObj(id -> new Student(id,"Student"+id,new Random().nextInt(20)))
                .collect(Collectors.toList());
    }
}
