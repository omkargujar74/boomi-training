// Copyright (c) 2023 Boomi, Inc.
package model;

/**
 * @author omkargujar.
 */
public class Student {

    private int _rollNumber;
    private String _firstName;
    private String _lastName;
    private int _age;

    public Student(int rollNumber, String firstName, String lastName, int age) {
        this._rollNumber = rollNumber;
        this._firstName = firstName;
        this._lastName = lastName;
        this._age = age;
    }

    public Student() {
    }

    public int getRollNumber() {
        return _rollNumber;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public int getAge() {
        return _age;
    }

    public void setRollNumber(int rollNumber) {
        this._rollNumber = rollNumber;
    }

    public void setFirstName(String firstName) {
        this._firstName = firstName;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    public void setAge(int age) {
        this._age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNumber=" + _rollNumber + ", firstName='" + _firstName + '\'' + ", lastName='" + _lastName
                + '\'' + ", age=" + _age + '}';
    }
}
