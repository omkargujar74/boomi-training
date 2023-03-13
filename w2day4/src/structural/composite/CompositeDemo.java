package structural.composite;

public class CompositeDemo {
    public static void main(String[] args) {
        Employee ceo = new Employee("John", 1001, "CEO");

        Employee headSales = new Employee("Robert", 1002, "Head Sales");

        Employee headMarketing = new Employee("Michel", 1003, "Head Marketing");

        ceo.addSubordinates(headMarketing);
        ceo.addSubordinates(headSales);

        Employee salesExecutive1 = new Employee("Richard", 1005, "Sales");
        Employee salesExecutive2 = new Employee("Rob", 1004, "Sales");
        headSales.addSubordinates(salesExecutive1);
        headSales.addSubordinates(salesExecutive2);

        Employee clerk1 = new Employee("Laura", 1006, "Marketing");
        Employee clerk2 = new Employee("Bob", 1007, "Marketing");
        headMarketing.addSubordinates(clerk2);
        headMarketing.addSubordinates(clerk1);

        ceo.showEmployeeDetails();
        //headMarketing.showEmployeeDetails();
    }
}
