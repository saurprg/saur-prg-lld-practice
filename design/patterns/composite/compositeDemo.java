package design.patterns.composite;
import java.util.ArrayList;

/**
 * Commons use cases : Nested Structures
 * TreeNode is composite Structure as it stored reference to itself
 * In UI - A UI coponents can be composed of multiple Children UI Components
 * Hierachy of organisation
 */

 abstract class Employee {

    protected long salary;
    protected String name;

    Employee(String name, long salary) {
        this.salary = salary;
        this.name = name;
    }

    abstract long getSalary();
    abstract void showDetails();
 }
class Developer extends Employee {

    Developer(String name, long salary) {
        super(name, salary);
    }

    @Override
    public long getSalary() {
            return salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Name " + name + ",Salary: " + salary);
    }
    
}

class Designer extends Employee {

    Designer(String name, long salary) {
        super(name, salary);
    }

    @Override
    public long getSalary() {
            return salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Name " + name + ",Salary: " + salary);
    }
}

class Manager extends Employee {
    private ArrayList<Employee> subordinates;
    Manager(String name, long salary) {
        super(name, salary);
        this.subordinates = new ArrayList<>();
    }

    @Override
    public long getSalary() {
            return salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Name " + name + ",Salary: " + salary);
        subordinates.forEach(e -> {
            e.showDetails();
        });
    }

    public void addSubordinate(Employee e) {
        this.subordinates.add(e);
    }
}

public class compositeDemo {

    public static void main(String[] args) {
        Developer d1 = new Developer("Saurabh T1", 1000000);
        Developer d2 = new Developer("Saurabh T2", 1000000);

        Designer de = new Designer("Priya Mehta", 50);

        Manager m = new Manager("Ch.,.", 10);
        m.addSubordinate(d1);
        m.addSubordinate(de);

        Manager generalManager = new Manager("GM", 20);
        generalManager.addSubordinate(m);
        generalManager.addSubordinate(d2);

        generalManager.showDetails();

    }
    
}
