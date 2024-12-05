package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AskedQuestion {
    public static void main(String[] args) {
        System.out.println();
        String strs="hii komal hii govind hii sweta ravi how are you";
        System.out.println("Original sentence: "+strs);
        System.out.println();
        String ress= Arrays.stream(strs.split(" ")).distinct().collect(Collectors.joining(" "));

        System.out.println("After removing duplicates: "+ress);


        System.out.println();

        ArrayList<Integer> all=new ArrayList<>();
        all.add(20);
        all.add(10);
        all.add(5);
        all.add(5);
        all.add(25);
        all.add(15);
        all.add(25);
        all.add(10);
        System.out.println();
        System.out.println("All the given numbers:"+all);
        System.out.println();
        List<Integer> sqrRes=all.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println("Square of numbers:"+sqrRes);
        System.out.println();
        System.out.println("Square numbers greater than 100 :"+sqrRes);
        all.stream().mapToInt(i->i*i).filter(i->i>100).forEach(System.out::println);
        System.out.println();
       double output= all.stream().mapToInt(i->i*i).filter(i->i>100).map(i->i).average().getAsDouble();
        System.out.println("Average : "+output);





    }
}
