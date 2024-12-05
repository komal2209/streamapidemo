package work;

import java.util.*;
import java.util.stream.Collectors;

//durga channel
public class Student implements Comparable<Student> {
    Integer marks;
    String name;

    public Student(Integer marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
    @Override
    public int compareTo(Student o) {
        return this.marks-o.marks;
    }

    public static void main(String[] args) {

        //QUESTION:--2. Calculate the average marks of a list of students objects using Java streams:
        //Person object have name and marks
        List<Student> ll = new ArrayList<>();
        ll.add(new Student(90, "Komal"));
        ll.add(new Student(70, "Sweta"));
        ll.add(new Student(80, "Golu"));
        ll.add(new Student(60, "Ravi"));
        ll.add(new Student(60, "Raju"));
        ll.add(new Student(90, "Rajiv"));


        //sorted different way.
        List<String> list = ll.stream().map(s -> s.name).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).collect(Collectors.toList());
        System.out.println(list);

        System.out.println();
        System.out.println("Before average.");
        List<Integer> lls = ll.stream().mapToInt(s -> s.marks).boxed().collect(Collectors.toList());
        System.out.println(lls);
        System.out.println();
        System.out.println("After average.");

        // why we use OptionalDouble just because of chance of getting empty so in that
        // case optionalDouble will handle exception.
        OptionalDouble StudentList = ll.stream().mapToInt(s -> s.marks).average();
        if (StudentList.isPresent()) System.out.println("Average Marks: " + StudentList.getAsDouble());
        else System.out.println("Average Marks" + 0);


        // QUESTION--  1. Find the longest string in a list of strings using Java streams
        //   input: ["apple", "banana", "cherry", "date", "grapefruit"]

        List<String> lll = List.of("apple", "banana", "cherry", "date", "grape");

        //find the max-length and print the length.

        System.out.println();
        System.out.println("print the length of the strings of the list");
        List<Integer> lengths = lll.stream().mapToInt(String::length).boxed().collect(Collectors.toList());
        System.out.println(lengths);

        System.out.println("maximum length of the string.");
        OptionalInt getMaxLength = lll.stream().mapToInt(String::length).max();
        if (getMaxLength.isPresent()) System.out.println("Max length :" + getMaxLength.getAsInt());
        else System.out.println("empty " + 0);


        //print the max-length with string name
        String maxlengths = lll.stream().max(Comparator.comparingInt(String::length)).get();
        if (!maxlengths.isEmpty()) System.out.println(maxlengths + " (Length: " + maxlengths.length() + ")");
        else System.out.println("No String");
        System.out.println();


        //marks wise ascending or descending

        List<Student> listStud = ll.stream().sorted(Comparator.comparing(Student::getMarks)).collect(Collectors.toList());
        System.out.println("sorted by sorted(Comparator.comparing(Student::getMarks) "+listStud);

        System.out.println();
        System.out.println("sorted by overriding compareTo method"+ll);


       Collections.sort(ll,(e,e1)->e.name.compareTo(e1.name));
        System.out.println("sorted by collections.sort(): "+ll);

       // ll.stream().filter(ll->ll.marks)


    }

}
