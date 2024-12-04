package work;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AskedQuestion {
    public static void main(String[] args) {
        System.out.println();
        String strs="hii komal hii govind hii sweta ravi how are you";
        System.out.println("Original sentence: "+strs);
        System.out.println();
        String ress= Arrays.stream(strs.split(" ")).distinct().collect(Collectors.joining(" "));

        System.out.println("After removing duplicates: "+ress);
    }
}
