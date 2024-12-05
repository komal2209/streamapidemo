package work;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Long.compare;
// channel for pick the question -(code with ease - by varsha)

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

        //Given the list of words filter and print the palindrome
        List<String> str=List.of("ANNA","KOMAL","GOGO","GOLU","DEED","SWETA","LEVEL","RAVI","RADAR");
        List<String> lists=str.stream().filter(i->i.equals(new StringBuilder(i).reverse().toString())).collect(Collectors.toList());
        System.out.println(lists);
        System.out.println();

        //find out the prime numbers
        List<Integer> numbs=List.of(11,304,12,13,31,306,7,5);
        List<Integer> prmNumbs=numbs.stream().filter(i->i%2!=0||i%3!=0).collect(Collectors.toList());
        System.out.println("List of prime numbers :"+prmNumbs);

         //how do we Concatenate two  array into the single array and sort it.
        int arr1[]={1,2,8,9,10,11,12,15};
        int arr2[]={4,5,6,7,13,14,0,3};

        int[] uniqueNum= IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
        System.out.println("Concatenate two arrays and sorted : "+uniqueNum);
        System.out.println();

        //concatenate two list and remove the duplicates.

        List<String> list1=List.of("Apple","Banana","Cherry","Grapes","Blackberry","Waterfruit","Sugarcane","Carrot");
        List<String> list2=List.of("Apple","Mango","Cherry","PineApple","Watermelon","Pears","Orange","Carrot","Beetroot");

        List<String> contList=Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
        System.out.println(contList);
        System.out.println();


        // The student who got the above and equal to 60 those student marked as pass otherwise marked as failed

        class Student {
            Integer marks;
            String name;

            Student(Integer marks, String name) {
                this.marks = marks;
                this.name = name;
            }

           public String toString()
            {
                return this.name +" "+this.marks;
            }
        }
        List<Student> ll = new ArrayList<>();
        ll.add(new Student(90, "Komal"));
        ll.add(new Student(70, "Sweta"));
        ll.add(new Student(80, "Golu"));
        ll.add(new Student(60, "Ravi"));
        ll.add(new Student(30, "Raju"));
        ll.add(new Student(40, "Rajiv"));

        System.out.println("List of Student : "+ll);
        System.out.println();
        Map<String,List<Student>> listOfPassStud= ll.stream().collect(Collectors.groupingBy(i->i.marks>=60 ? "pass" : "fail"));
        System.out.println("List of Passed Student : "+listOfPassStud);
        System.out.println();


        // sort according to the increasing order of length
        List<String> listOfFruit=List.of("Apple","Banana","Cherry","Grapes","Blackberry","WaterFruit","Sugarcane","Carrot");
        listOfFruit.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
                Comparator<String> c=(s1,s2)->
                {
                    int len1=s1.length();
                    int len2=s2.length();
                    if(len1>len2) return 1;
                    else if(len1<len2) return -1;
                    else return s1.compareTo(s2);
                };


        List<String> strSortBy=listOfFruit.stream().sorted(c).collect(Collectors.toList());
        System.out.println("Sorted by length of the word. if length is same then sort by alphabetically : "+strSortBy);
        System.out.println();

        List<String> strSortByLen=listOfFruit.stream().sorted((e,e1)->compare((Integer)e.length(),e1.length())).collect(Collectors.toList());
        System.out.println("Sorted by length of the word : "+strSortByLen);
        System.out.println();

       List<String> sortBy= listOfFruit.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println("Sorted by length of the word. "+sortBy);
    }
}