package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee implements IEmployee {
    private String name;
    private long empId;
    private String position;
    private List<IEmployee> subordinates = new ArrayList<>();

    public Employee(String name, long empId, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }

    public void addSubordinates(IEmployee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinates(IEmployee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("position: " + position + "\n\tName : " + name + " empID: " + empId);
        for (IEmployee employee : subordinates) {
            employee.showEmployeeDetails();
        }
    }
}
