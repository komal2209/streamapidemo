package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {

        //create stream object using Stream.of().
          String names[]={"Komal, ","Karan, ","Govind, ","Golu, ","Sweta, ","Shubham, ","Ravi, ","Annu"};
          Stream<String> streamArr= Stream.of(names);
          streamArr.forEach(System.out::print);


        //create stream object using builder.
        Stream<Object> streamObj= Stream.builder().build();

        //create stream object using empty()
        Stream<Object> emptyStream= Stream.empty();
        System.out.println();
        //create stream object using Arrays.Stream();
        IntStream intStream=Arrays.stream(new int[]{20,10,30,79,85,90,50});
        intStream.forEach(System.out::println);

        //create stream objects for lists,set
        List<Integer> lists=new ArrayList<>();
        lists.add(12);
        lists.add(34);
        lists.add(23);
        lists.add(78);
        lists.add(90);

        Stream<Integer> stream=lists.stream();
        stream.forEach(System.out::println);

        System.out.println();
        System.out.println("converting stream object to array");
        ArrayList<Integer> al=new ArrayList<>();
        al.add(0);
        al.add(10);
        al.add(5);
        al.add(20);
        al.add(15);

        Integer[] II=al.stream().toArray(Integer[]::new);
        for(Integer I:II)
        {
            System.out.print(I +",");
        }
        System.out.println();
        System.out.println("converting array into stream object");
        Stream.of(II).forEach(System.out::println);

    }
}
