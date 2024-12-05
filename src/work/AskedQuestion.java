package work;

import java.util.*;
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
        //1.Given a list of numbers and find square of each number and filter the number whose square is greater than 100 and also find the average of filtered numbers
        List<Integer> sqrRes=all.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println("Square of numbers:"+sqrRes);
        System.out.println();
        System.out.println("Square numbers greater than 100 :"+sqrRes);
        all.stream().mapToInt(i->i*i).filter(i->i>100).forEach(System.out::println);
        System.out.println();
       double output= all.stream().mapToInt(i->i*i).filter(i->i>100).map(i->i).average().getAsDouble();
        System.out.println("Average : "+output);
        System.out.println();

//2.Given a list of numbers and find square of each number and filter the number whose square is greater than 100 and also find the average of filtered numbers
        List<Integer> sqrRess=all.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println("Square of numbers:"+sqrRess);
        System.out.println();
        List<Integer> greaterSquares = sqrRes.stream().filter(i->i>100).collect(Collectors.toList());
        System.out.println("Square numbers greater than 100 :"+greaterSquares);
        System.out.println();
        double outputs= greaterSquares.stream().mapToInt(i ->i).average().getAsDouble();
        System.out.println("Average of greaterSquares: "+outputs);
        System.out.println();

         //1. Print Even & print Odd Numbers using Streams

        List<Integer> listEven=all.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("List of Even Numbers:"+listEven);
        System.out.println();
        List<Integer> listOdd=all.stream().filter(i->i%2!=0).collect(Collectors.toList());
        System.out.println("List od Odd Numbers:"+listOdd);

        //2.Print Numbers Starts With Prefix 2 using Streams
        List<Integer> lists=List.of(2, 222, 234, 567, 890, 432, 234, 211, 22);
       List<Integer> integerList= lists.stream().map(i->i.toString()).filter(i->i.startsWith("2")).map(i->Integer.valueOf(i)).collect(Collectors.toList());
        System.out.println("Option-1 list of number whose start with 2 : "+integerList);
        System.out.println();
       Map<Boolean,List<Integer>>listMap=lists.stream().collect(Collectors.groupingBy(i->i.toString().startsWith("2")));
        System.out.println("option-2 list of number whose start with 2 : "+listMap.get(true) );
        System.out.println();

        //3.Multiple the elements in an array and print using stream
        Integer[] arr = {1,2,3,4,5};
       Integer value= Arrays.stream(arr).reduce(1,(i1,i2)->i1*i2);
        System.out.println("Multiply of all numbers of list : "+value);











    }
}
