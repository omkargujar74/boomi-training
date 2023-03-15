// Copyright (c) 2023 Boomi, Inc.

import com.boomi.w2day3.dao.StudentDao;
import com.boomi.w2day3.model.Student;
import com.boomi.w2day3.service.StudentService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @author omkargujar.
 */
public class TestStudentService {

    @Mock
    StudentDao _studentDao;

    @InjectMocks
    StudentService _studentService;

    AutoCloseable _autoCloseable;

    @Before
    public void setup() {
        _autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStudentByID() {
        when(_studentDao.getStudentByID(1001)).thenReturn(new Student(1001, "Omkar", 23));
        Student studentByID = _studentService.getStudentByID(1001);

        assert (studentByID.getName().equals("Omkar"));
        assert (studentByID.getId() == 1001);
        assert (studentByID.getAge() == 23);
    }

    @Test
    public void deleteStudent() {
        when(_studentDao.deleteStudent(1001)).thenReturn(true);

        assertTrue(_studentService.deleteStudent(1001));
    }

    @Test
    public void testGetAllStudents() throws SQLException {
        when(_studentDao.getAllStudents()).thenReturn(new ArrayList<>());
        List<Student> allStudents = _studentService.getAllStudents();
        assert (allStudents.size() == 0);
    }

    @After
    public void releaseMock() throws Exception {
        _autoCloseable.close();
    }
}
