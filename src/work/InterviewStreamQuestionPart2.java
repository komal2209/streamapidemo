package work;
import java.util.*;
import java.util.stream.Collectors;

public class InterviewStreamQuestionPart2 {
    public static void main(String[] args) {
        String strCre = "JAVA IS THE BEST LANGUAGE IN THE TERMS OF OOPS. JAVA IS VERSATILE LANGUAGE.";
        System.out.println();

        //counting each word frequency.
        System.out.println("sentences :"+strCre);
        Map<String,Long> countWord= Arrays.stream(strCre.split(" ")).collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting()));
        System.out.println(countWord);
        System.out.println();

        //covert into the lower case
        List<String> listOfStr=Arrays.stream(strCre.split(" ")).map(i->i.toLowerCase()).collect(Collectors.toList());
        System.out.println(listOfStr);
        System.out.println();

        //count the numbers which start with one
        List<Integer> al=List.of(10,304,12,11,304,101,25,30,1141,306,1162);
        System.out.println("Lists of numbers : "+al);
        Long ii= al.stream().filter(i->String.valueOf(i).startsWith("1")).mapToInt(i->i).count();
        System.out.println("Count of numbers which start with one :"+ii);
        System.out.println();

        //List of numbers which start with one
        List<Integer>listOfOne= al.stream().filter(i->String.valueOf(i).startsWith("1")).collect(Collectors.toList());
        System.out.println("List of numbers which start with one : "+listOfOne);

        //group by their names first letter and count in each group;
        String[] nameList={"komal","Sweta","Subham","Raj","Kunal","Kavita","Ravi","Govind","Annu","Golu","Indu","Alok","iliyana","misti"};
       Map<Character, Long> lits= Arrays.stream(nameList).map(i->i.toUpperCase()).collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));
        System.out.println(lits);

      //frequency of numbers way-1
        List<Integer> dupNum=List.of(10,304,12,10,306,101,25,30,101,306,1162);
       Set<Integer>dupNumList= dupNum.stream().filter(i-> Collections.frequency(dupNum,i)>1).collect(Collectors.toSet());
        System.out.println("Number which is comes more than one time : "+dupNumList);
        System.out.println();

        //frequency of numbers way-2
        Set<Integer> sets=new HashSet<>();
        Set<Integer> checkFreq=dupNum.stream().filter(i-> !sets.add(i)).collect(Collectors.toSet());
        System.out.println("Number which is comes more than one time : "+checkFreq);
        System.out.println();

        //frequency of numbers way-3
        System.out.println("Number which is comes more than one time : ");
        dupNum.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);
        System.out.println();




    }
}