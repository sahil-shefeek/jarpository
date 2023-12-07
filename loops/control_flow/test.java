class Employee {
    String name, phoneNumber, address;
    int age;
    double salary;

    void printSalary() {
        System.out.println("Salary: $" + salary);
    }
}

class Officer extends Employee {
    String specialisation;
}

class Manager extends Employee {
    String department;
}

public class test {
    public static void main(String[] args) {
        Officer officer = new Officer();
        officer.name = "John Doe";
        officer.age = 30;
        officer.phoneNumber = "123-456-7890";
        officer.address = "123 Main St, City";
        officer.salary = 50000.0;
        officer.specialisation = "Finance";

        Manager manager = new Manager();
        manager.name = "Jane Smith";
        manager.age = 35;
        manager.phoneNumber = "987-654-3210";
        manager.address = "456 Park Ave, Town";
        manager.salary = 70000.0;
        manager.department = "Marketing";

        System.out.println("Officer Details:");
        System.out.println("Name: " + officer.name);
        System.out.println("Age: " + officer.age);
        System.out.println("Phone Number: " + officer.phoneNumber);
        System.out.println("Address: " + officer.address);
        officer.printSalary();
        System.out.println("Specialisation: " + officer.specialisation);

        System.out.println("\nManager Details:");
        System.out.println("Name: " + manager.name);
        System.out.println("Age: " + manager.age);
        System.out.println("Phone Number: " + manager.phoneNumber);
        System.out.println("Address: " + manager.address);
        manager.printSalary();
        System.out.println("Department: " + manager.department);
    }
}