package strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String s = "i FollowMilind_Mehta";

        //Given a string, write a program to count the occurrences of each character.
        String[] splitString = s.split("");
//        Map<String, Long> result = Arrays.stream(splitString).collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        Map<String, Long> result = Arrays.stream(splitString).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        //Function.identity() is a static method from the java.util.function.Function interface.
        //It returns a function that returns its input as output — unchanged.
        //You often use groupingBy() to group elements based on a key.
        //If you want to group by the element itself, use Function.identity().

        //skip " " and _
        Map<String, Long> resultEnhanced = Arrays.stream(splitString).filter(e -> ((!e.isBlank()) && (!e.contains("_")))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(resultEnhanced);





        //Given a string, find characters that appear more than once.
        //via frequency
        List<String> duplicates = Arrays.stream(splitString).filter(e -> Collections.frequency(Arrays.asList(splitString), e) > 1).distinct().collect(Collectors.toList());
        System.out.println(duplicates);

        //hard-way
        Map<String, Long> duplicatesWithHardWay = Arrays.stream(splitString).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(duplicatesWithHardWay);





        //Given a string, find the first unique character.
        String uniqueChar = Arrays.stream(splitString).filter(e -> (!e.isBlank() && !e.equals("_")))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst()
                .orElse(null);

        System.out.println(uniqueChar);





        //find the longest string in a given array.
        List<String> stringList = List.of("Milind", "Mehta", "follow", "Microservices", "Springboot");
        String longestString = stringList.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).orElse(null);
        System.out.println(longestString);

        //via Comparator
        System.out.println(stringList.stream().max(Comparator.comparing(String::length)).orElse(null));

        //printing a length of the largest string:
        OptionalInt length = stringList.stream().mapToInt(str -> str.length()).max();
        System.out.println("Length: " + length.getAsInt());





        //Find the number of occurrences of a given character in a list of strings using Java streams
        char target = 'M';
        long count = stringList.stream().flatMapToInt(String::chars).filter(c -> c == target).count();
        System.out.println(count);





        //Find Longest Words in a Sentence Using:
        String sentence = "My name is Saurabh, and I am working at Capgemini as a Java Developer";
        int maxLength = Arrays.stream(sentence.split(" ")).mapToInt(e -> e.length()).summaryStatistics().getMax();
        System.out.println(maxLength);
        Arrays.stream(sentence.split(" ")).filter(e -> (e.length() == maxLength)).forEach(System.out::println);
    }
}
