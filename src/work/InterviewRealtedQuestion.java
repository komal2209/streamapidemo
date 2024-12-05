package work;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// channel for pick the question -(Naveen AutomationLabs)
public class InterviewRealtedQuestion {
    public static void main(String[] args) {
        //remove duplicates option 1

        ArrayList<Integer> all=new ArrayList<>();
        all.add(20);
        all.add(10);
        all.add(5);
        all.add(5);
        all.add(25);
        all.add(15);
        all.add(25);
        all.add(10);
        all.add(0);
        //all.add(2);
        //all.add(-1);
        //all.add(-5);
        System.out.println("Print the lists of integer");
        System.out.println(all);


        System.out.println();
        System.out.println("Sum of all numbers");
      //  all.stream().reduce((i1, i2)->i1+i2).stream().collect(Collectors.toList()).forEach(System.out::println);
       Optional<Integer> sumRes= all.stream().reduce((i1, i2)->i1+i2);
        System.out.println("Sum of all numbers: "+sumRes.get());
        System.out.println();

        //Average of all the Integers of the list.
        Double avgRes=all.stream().mapToInt(i->i).average().getAsDouble();
        System.out.println("Average is: "+avgRes);
        System.out.println();

        //square of the given number.
       List<Integer> sqrRes=all.stream().map(i->i*i).collect(Collectors.toList());

        System.out.println("All the given numbers:"+all);
        System.out.println("Square of numbers:"+sqrRes);


        //square it and filter which is greater than 100 and then average it
        System.out.println();
        System.out.println("First square all the numbers then filter which is greater than 100 after that take out average.");
        Double sqrFilAvgRes= all.stream().map(i->i*i).filter(i->i>100).mapToInt(i->i).average().getAsDouble();
        System.out.println("Square + Filter + Average = "+sqrFilAvgRes);

        System.out.println();
        System.out.println("Print the even number from the list.");
        List<Integer> evenNumber= all.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("Even numbers of the list:"+evenNumber);

        System.out.println();
        System.out.println("print the odd number from the list.");
        List<Integer> oddNumber= all.stream().filter(i->i%2!=0).collect(Collectors.toList());
        System.out.println("Odd numbers of the list:"+oddNumber);

        System.out.println();
        System.out.println("print the number which are start with 2 or '-' .");
        List<Integer> startWithTwo= all.stream().map(i->i.toString()).filter(i->i.startsWith("2") || i.startsWith("-")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("Number prefix with 2: "+startWithTwo);



        System.out.println();
        //remove the duplicates and  order is not  preserved using toSet()
        System.out.println("Remove the duplicates and  order is not  preserved using toSet()");
        //Remove the duplicates but order may not be preserved
        all.stream().collect(Collectors.toSet()).stream().forEach(System.out::println);

        //remove the duplicates and  order is also  preserved using distinct()

        System.out.println();
        System.out.println("Remove the duplicates and  order is also  preserved using distinct()");
        List<Integer> duplicateRes= all.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicateRes);


     //print duplicate numbers using frequency method of collections
        System.out.println();
        System.out.println("Print the numbers which is occur more than one time in the list using frequency method.");
        Set<Integer> setDup= all.stream().filter(e->Collections.frequency(all,e)>1).collect(Collectors.toSet());
        System.out.println("print the duplicate numbers :"+setDup);

        System.out.println();
        System.out.println("Print the numbers which is occur more than one time in the list using  method.");
        Set<Integer> setNum =new HashSet<Integer>();
        Set<Integer> setNums=all.stream().filter(e->!setNum.add(e)).collect(Collectors.toSet());
        System.out.println("print the duplicate numbers :"+setNums);
        System.out.println();

        //find out the max and min for ascending order

        System.out.println("find out the max and min for ascending order max and min method");
        Integer maxAsc=all.stream().max((e1,e2)->e1.compareTo(e2)).get();
        Integer minAsc=all.stream().min((e1,e2)->e1.compareTo(e2)).get();
        System.out.println("Maximum :"+maxAsc +", Minimum :"+minAsc);
        System.out.println();
        //find out the max and min for descending order

        System.out.println("find out the max and min for descending order using max and min method");
        Integer maxDes=all.stream().max((e1,e2)->e2.compareTo(e1)).get();
        Integer minDes=all.stream().min((e1,e2)->e2.compareTo(e1)).get();
        System.out.println("Maximum :"+maxDes +", Minimum :"+minDes);
        System.out.println();

        System.out.println("find out the max and min using reduce");
        Integer maxRec=all.stream().reduce(1,(a,b)->a>b?a:b);
        Integer minRec=all.stream().reduce(1,(a,b)->a<b?a:b);
        System.out.println("Maximum :"+maxRec +", Minimum :"+minRec);
        System.out.println();

        System.out.println("find out the max and min using Max/Min method  with Integer");
        Integer maxInt=all.stream().max(Integer::compareTo).get();
        Integer minInt=all.stream().min(Integer::compareTo).get();
        System.out.println("Maximum :"+maxInt +", Minimum :"+minInt);
        System.out.println();

        System.out.println("find out the max and min using Max/Min method  with comparing method with Integer::valueOf()");
        int maxIntt=all.stream().max(Comparator.comparing(Integer::valueOf)).get();
        Integer minIntt=all.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Maximum :"+maxIntt +", Minimum :"+minIntt);
        System.out.println();


        System.out.println("find out the max and min with '(e1,e2)->e1-e2'");
        int maxInts=all.stream().max((e1,e2)->e1-e2).get();
        Integer minInts=all.stream().min((e1,e2)->e1-e2).get();
        System.out.println("Maximum :"+maxInts+", Minimum :"+minInts);
        System.out.println();

        //sorted default Natural order(asc)
        System.out.println("Default natural sorting order(asc).");
        List<Integer> sortDef=all.stream().sorted().collect(Collectors.toList());
       // List<Integer> sortDef=all.stream().sorted((e1,e2)->e1.compareTo(e2)).collect(Collectors.toList());
      //  List<Integer> sortDef=all.stream().sorted((e1,e2)->-e2.compareTo(e1)).collect(Collectors.toList());
       // List<Integer> sortDef=all.stream().sorted((e1,e2)->-e2+e1).collect(Collectors.toList());
        System.out.println("Lists :"+sortDef);
        System.out.println();

        //descending order
        System.out.println("Customized sorting order(dsc).");
        List<Integer> sortCust=all.stream().sorted((e1,e2)->e2.compareTo(e1)).collect(Collectors.toList());//option1
     //  List<Integer> sortCust=all.stream().sorted((e1,e2)->-e1.compareTo(e2)).collect(Collectors.toList()); //option2
       // List<Integer> sortCust=all.stream().sorted((e1,e2)->-e1+e2).collect(Collectors.toList()); //option3
      //  List<Integer> sortCust=all.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()); // option4

        System.out.println("Lists :"+sortCust);
        System.out.println();

        //only three element to print which start with 2 in ascending order.
        List<Integer> ll=all.stream().map(i->i.toString()).filter(i->i.startsWith("2")).map(Integer::valueOf).sorted().limit(3).collect(Collectors.toList());
        System.out.println("only three element to print which start with 2 in ascending order: "+ll);
        System.out.println();

        // print only three element which start with 2 in ascending order.
        Integer sumOf3=all.stream().limit(3).reduce((p,q)->p+q).get();
        System.out.println("sum of first 3 numbers :"+sumOf3);
        System.out.println();

        //skip the first 3 numbers
        List<Integer> skipFirst3=all.stream().skip(3).collect(Collectors.toList());
        System.out.println("original list :"+all);
        System.out.println("skip the first 3 numbers from the list :"+skipFirst3);
        System.out.println();

        //skip the first 3 element and add rest of the element.
        Integer skipFirst3Num=all.stream().skip(3).reduce((p,q)->p+q).get();
        System.out.println("original list :"+all);
        System.out.println("skip the first 3 numbers from the list and add rest of the numbers :"+skipFirst3Num);
        System.out.println();

        // removing duplicates and then find out  second maximum highest.
        System.out.println("Removing duplicates and then find out second maximum highest.");
        System.out.println("original list :"+all);
        System.out.println();
        all.stream().distinct().sorted((e1, e2)->-e1+e2).skip(1).limit(1).forEach(System.out::println);
        System.out.println();

        //without removing duplicates and then find out second maximum highest.
        System.out.println("Without removing duplicates and then find out second maximum highest.");
        System.out.println("original list :"+all);
        System.out.println();
        all.stream().sorted((e1, e2)->-e1+e2).skip(1).limit(1).forEach(System.out::println);
        System.out.println();

        // removing duplicates and then find out  second minimum .
        System.out.println("Removing duplicates and then find out second minimum.");
        System.out.println();
        System.out.println("original list :"+all);
        Integer minSec=all.stream().distinct().sorted((e1, e2)->+e1-e2).skip(1).limit(1).findFirst().get();
        System.out.println("second minimum :"+minSec);


        //without removing duplicates and then find out  second minimum .
        System.out.println("Removing duplicates and then find out second minimum.");
        System.out.println();
        System.out.println("original list :"+all);
        Integer minSecs= all.stream().sorted((e1, e2)->+e1-e2).skip(1).limit(1).findFirst().get();
        System.out.println("second minimum :"+minSecs);
    }
}
