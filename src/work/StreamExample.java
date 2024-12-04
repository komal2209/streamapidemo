package work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {



        List<Integer> al=List.of(20,30,5,50,60,70,85);
        System.out.println("Total student marks list.");
        System.out.println(al);
        System.out.println();

        System.out.println("Total fail student");
        int totalfailedStudent= (int) al.stream().filter(i->i<35).count();
        System.out.println(totalfailedStudent);
        System.out.println();

        System.out.println("Fail student marks  list before adding the grace marks .");
        List<Integer>  failedStudentList=al.stream().filter(i->i<35).sorted().collect(Collectors.toList());
        System.out.println(failedStudentList);
        System.out.println();
        System.out.println("After adding 5 grace marks to fail student mark still they did not qualify.");
        List<Integer>  graceStudentList=al.stream().filter(i->i<35).map(i->i+5).filter(i->i<35).sorted().collect(Collectors.toList());
        System.out.println(graceStudentList);
        System.out.println();

        System.out.println("Pass student mark list.");
        List<Integer>  passStudentList=al.stream().filter(i->i>=35).sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
        System.out.println(passStudentList);




        System.out.println();
        System.out.println("filter according to the string length .if the length is the sort by alphabetical order");


        List<String> ss=new ArrayList<>();
        ss.add("Komal Kumari");
        ss.add("Govind Kumar");
        ss.add("Shubham Shaw");
        ss.add("Ravi Kumar");
        ss.add("Sweta Prasad");
        ss.add("Rahul Singh");
        ss.add("Raju Kumar");
        Comparator<String> c=(s1, s2)->
        {
            int l1=s1.length();
            int l2=s2.length();
            if(l1>l2) return-1;
           else if(l1<l2) return 1;
           else return s1.compareTo(s2);

        };
        List<String> sList=ss.stream().sorted(c).collect(Collectors.toList());
        System.out.println(sList);






    }
}
