package work;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMapMethodExample {
    public static void main(String[] args) {
        //filter
        List<String> names=List.of("ankit","anamika","anuj","durga","alok","indu","sweta","komal");
        List<String> stream= names.stream().filter(a->a.startsWith("a")).collect(Collectors.toList());
        System.out.println();

        //start with a and sorted in ascending orders.
        System.out.println("start with a and sorted in ascending orders");
        names.stream().filter(a->a.startsWith("a")).sorted((a,b)->a.compareToIgnoreCase(b)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        System.out.println("filter that start with a and sorted by length");
         //sorted by length
         names.stream().filter(a->a.startsWith("a")).sorted((a,b)->Integer.compare(a.length(),b.length())).forEach(System.out::println);
        System.out.println();

        System.out.println("square using stream api");
        List<Integer> integersList=List.of(5,10,20,13,17,18,19);
        integersList.stream().map(i->i*i).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        System.out.println("square using stream api and checking square of numbers is even or not.");
        integersList.stream().map(i->i*i).filter(i->i%2==0).collect(Collectors.toList()).forEach(System.out::println);



    }
}
