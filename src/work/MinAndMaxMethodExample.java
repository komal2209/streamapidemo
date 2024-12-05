package work;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// durga and durgesh channel
public class MinAndMaxMethodExample {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        al.add(0);
        al.add(10);
        al.add(5);
        al.add(20);
        al.add(15);

       //stream api way
        Optional<Integer> ll=al.stream().max(Integer::compareTo);
        if(ll.isPresent()) System.out.println("Maximum :"+ll.get().intValue());
        System.out.println();
        System.out.println("sorted ascending order 0,5,10,15,20");
        //sorted ascending order 0,5,10,15,20
        Optional<Integer> min=al.stream().min((i1, i2)->i1.compareTo(i2));
        System.out.println("minimum value :"+min);//0
        Optional<Integer> max=al.stream().max((i1, i2)->i1.compareTo(i2));
        System.out.println("maximum value :"+max);//20
        System.out.println();
        System.out.println("sorted in 20,15,10,5,0(descending order)");
      // sorted in 20,15,10,5,0(descending order)
        Optional<Integer> mini=al.stream().min((i1, i2)->-i1.compareTo(i2));
        System.out.println("minimum value :"+mini); //20
        Optional<Integer> maxi=al.stream().max((i1, i2)->-i1.compareTo(i2));
        System.out.println("maximum value :"+maxi); //0

        System.out.println("printing using lambda expression");
       Consumer<Integer> f= i->{System.out.println("square of " + i + " is: " + i*i);};
       al.stream().forEach(i->{System.out.println("square of " + i + " is: " + i*i);});
        System.out.println();

        System.out.println();

        System.out.println("find out the max and min using reduce");
        Integer maxRec=al.stream().reduce(1,(a,b)->a>b?a:b);
        Integer minRec=al.stream().reduce(1,(a,b)->a<b?a:b);
        System.out.println("Maximum :"+maxRec +", Minimum :"+minRec);
        System.out.println();

        System.out.println("find out the max and min using Max with Integer");
        Integer maxInt=al.stream().max(Integer::compareTo).get();
        Integer minInt=al.stream().min(Integer::compareTo).get();
        System.out.println("Maximum :"+maxRec +", Minimum :"+minRec);
        System.out.println();


        System.out.println("find out the max and min using Max/Min method  with comparing method with Integer::valueOf()");
        int maxIntt=al.stream().max(Comparator.comparing(Integer::valueOf)).get();
        Integer minIntt=al.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Maximum :"+maxIntt +", Minimum :"+minIntt);
        System.out.println();


        System.out.println("find out the max and min with '(e1,e2)->e1-e2'");
        int maxInts=al.stream().max((e1,e2)->e1-e2).get();
        Integer minInts=al.stream().min((e1,e2)->e1-e2).get();
        System.out.println("Maximum :"+maxInts+", Minimum :"+minInts);
        System.out.println();

        Integer maxStr=al.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Maximum of all numbers using max method: "+maxStr);
        System.out.println();

    }
}
