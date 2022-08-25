package com.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Employee {

    public Employee(int emp_id, String emp_name, int emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }

    public int emp_id;
    public String emp_name;

     public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public int emp_salary;

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

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(2);

        int i = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println(i);
        List<Integer> s1 = list.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        System.out.println(s1);
//        Map<String, Integer> result3 = empList.stream().collect(
//                Collectors.toMap(Employee::getEmp_id, Collectors.counting()));
//        System.out.println(result3);

    }
}
