package work;

import java.util.*;
import java.util.stream.Collectors;


// channel for pick the question -(code with ease - by varsha)
public class InterviewStreamQuestion {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(12, 4, 3, 4, 9, 7, 8, 54, 2, 37, 8);
        List<String> str = Arrays.asList("Apple", "coconut", "Orange", "Mango", "banana", "Cherry");
        Optional<Integer> st = al.stream().reduce((a, b) -> a + b);
        System.out.println("sum of all numbers using streams reduce method: " + st.get());
        System.out.println();

        int stt = al.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of all numbers using streams mapToInt Method: " + stt);
        System.out.println();

        //Maximum of all numbers.
        Integer maxStr = al.stream().max(Integer::compareTo).get();
        System.out.println("Maximum of all numbers using max method: " + maxStr);
        System.out.println();


        Integer max = al.stream().reduce((a, b) -> a > b ? a : b).get();
        System.out.println("Maximum of all numbers using reduce method :" + max);
        System.out.println();

        // string which start which 'c' character
        long count = str.stream().map(i -> i.toLowerCase()).filter(a -> a.startsWith("c")).count();
        System.out.println("count the word which is start with 'c' :" + count);
        System.out.println();

        // Covert all the string into the uppercase.
        List<String> strUpper = str.stream().map(i -> i.toUpperCase()).filter(a -> a.startsWith("C")).collect(Collectors.toList());
        System.out.println("Covert string into the uppercase which start with 'C':" + strUpper);
        System.out.println();

        // even and odd

        List<Integer> eveNum = al.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNum = al.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + eveNum + " / Odd Numbers: " + oddNum);
        System.out.println();

        //average of double
        List<Double> ddList = Arrays.asList(12.9, 4.0, 3.8, 9.0, 7.8, 8.8, 54.90, 37.90);
        Double avgList = ddList.stream().mapToDouble(i -> i).average().getAsDouble();
        System.out.println("Average : " + avgList);

        //String  Concatenation
        String conList = str.stream().collect(Collectors.joining(","));
        System.out.println(conList);
        System.out.println();

        //remove duplicate
        List<Integer> llRemove = al.stream().distinct().collect(Collectors.toList());
        System.out.println("Remove the duplicates : " + llRemove);
        System.out.println();


        List<Integer> remDup = al.stream().collect(Collectors.toSet()).stream().sorted().collect(Collectors.toList());
        System.out.println("Remove the duplicates : " + remDup);
        System.out.println();



        Integer sumaofall = al.stream().reduce((a, b) -> a + b).get();
        System.out.println("List of numbers: " + al);
        System.out.println();

        Double numAvg= al.stream().mapToInt(i->i).average().getAsDouble();
        System.out.println("average of all the numbers." +numAvg);
        System.out.println();

        boolean llEven=al.stream().anyMatch(i->i%2==0);
        System.out.println("Lists : "+al);
        System.out.println("checking any of numbers in the list is even or not : " +llEven);
        System.out.println();


        boolean llOdd=al.stream().allMatch(i->i%2==0);
        System.out.println("Lists : "+al);
        System.out.println("checking all of numbers in the list is even or not : " +llOdd);

    }
}
