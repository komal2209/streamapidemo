package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiMain1 {
    public static void main(String[] args)
    {
        //a) create a list and filter even numbers from list.

       // this the one way to add the elements .

       List<Integer> list1=new ArrayList<Integer>();
        list1.add(12);
        list1.add(34);
        list1.add(33);
        list1.add(23);
        list1.add(78);

//        // this the one way to add the elements in list when we use list.of() at the time of the
//        declaration mwe can add the elements after that we cannot add the elements because it is immutable .

        List<Integer> list2=List.of(2,4,23,11,22,50,59,47);

       List<Integer> list3= Arrays.asList(45,88,90,78,56,42,71,91);

       //filter even nos from  the list1 without streamapi .
       List<Integer> listEven=new ArrayList<>();
       for(Integer i:list1)
       {
           if(i%2==0) listEven.add(i);
       }
        System.out.println("filter the list without using stream api");
        System.out.println(list1);
        System.out.println(listEven);
        System.out.println();

        //using streamapi
        Stream<Integer>streams =list1.stream();
        List<Integer> evenlists=streams.filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("filter the list with using stream api");
        System.out.println(evenlists);
        System.out.println();
        //using  streamapi in single line
        List<Integer> streamObj=list1.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("filter the list with using stream api in single line");
        System.out.println(streamObj);


        // filters list elements
        List<Integer> streamObjj=list1.stream().filter(i->i>33).collect(Collectors.toList());
        System.out.println();
        System.out.println("filter the list with using stream api in single line");
        System.out.println(streamObjj);

        //print using streamApi
        System.out.println();
        System.out.println("filter the list and print using stream api in single line");
        list1.stream().filter(i->i>33).forEach(System.out::println);


    }
}
