package com.boomi.w2day3.dao;

import com.boomi.w2day3.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    Connection connection;
    public StudentDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boomitraining","root","Omkar@2611");
    }

    public boolean addStudent(int id,String name,int age){
        boolean status = false;
        String query = "insert into student values(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age);

            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow > 0) {
                status = true;
                System.out.println("Status = "+status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "Select * from student";
        Statement statement =connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            students.add(new Student(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)));
        }
        return students;
    }

    public boolean updateStudent(int id,String name,int age){
        boolean status = false;
        String query = "update student set Name=?,Age=? where ID=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setInt(3,id);


            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow > 0) {
                status = true;
                System.out.println("Status = "+status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean deleteStudent(int id){
        boolean status = false;
        String query = "delete from student where ID=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow > 0) {
                status = true;
                System.out.println("Status = "+status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
