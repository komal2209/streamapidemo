package work;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// QUESTION
/*
There is a list of employees and map that list based on key city and for that particular city find the value of list of employees
 */

public class Employee {
    String city;
    String name;

    public Employee(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public String toString()
    {
        return "City Name : "+this.city+" Employee Name :"+this.name;
    }

    public static void main(String[] args) {
        List<Employee> ll = new ArrayList<>();
        ll.add(new Employee("Bangalore", "Komal"));
        ll.add(new Employee("Pune", "Sweta"));
        ll.add(new Employee("Kolkata", "Golu"));
        ll.add(new Employee("Bangalore", "Ravi"));
        ll.add(new Employee("Bihar", "Raju"));
        ll.add(new Employee("Bangalore", "Rajiv"));

        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the city name:");
        String ctname=sc.nextLine();



        List<Employee> lls=ll.stream().filter(e->e.city.contains(ctname)).collect(Collectors.toList());
        System.out.println(lls);

    }
}
