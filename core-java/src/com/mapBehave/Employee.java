package com.mapBehave;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode"+Objects.hash(id, name));
        return Objects.hash(id, name);
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "ram");
        Employee emp1 = new Employee(101, "mar");
        Map<Employee, Integer> map = new HashMap<>();
        map.put(emp, 1);
        map.put(emp1, 2);
        System.out.println(map.size()+"size");
        System.out.println("========================");
        System.out.println(map.get(emp)+"value");
        System.out.println(map.get(emp1)+"value1");
    }

}




