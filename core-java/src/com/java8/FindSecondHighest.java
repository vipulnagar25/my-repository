package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Employee {

    public Employee(int emp_id, String emp_name, int emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }

    int emp_id;
    String emp_name;

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    int emp_salary;

}

public class FindSecondHighest {

    public static void main(String[] args) {
        Consumer consumer = (e) -> new Date();
        consumer.accept("sdds");
        Supplier supplier = () -> new Date();
        System.out.println(supplier.get().toString());
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "vipul", 200));
        empList.add(new Employee(2, "kumar", 300));
        empList.add(new Employee(3, "vipul", 400));
        String name = empList.stream().sorted((o1, o2) -> o2.emp_salary - o1.emp_salary).skip(1).limit(2).findFirst().get().getEmp_name();
        System.out.println(name);
        Employee user = new Employee(1, "vipul", 200);
        Consumer<Employee> updateName = u -> u.emp_name = "Roytuts";
        updateName.accept(user);

        System.out.println(user.getEmp_name()); //Roytuts


    }
}
