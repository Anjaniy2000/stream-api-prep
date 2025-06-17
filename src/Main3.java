import entities.Transaction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {

        //Check if a list of integers contains a prime number using Java streams
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);

        System.out.println(numbers.stream().anyMatch(Main3::isPrime));





        //Merge two sorted lists into a single sorted list using Java streams
        List<Integer> list1 = Arrays.asList(1, 3, 5, 8, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> integerList = Stream.concat(list1.stream(), list2.stream()).sorted().distinct().collect(Collectors.toList());
        System.out.println(integerList);





        //Find the intersection of two lists using Java streams
        List<Integer> collect = list1.stream().filter(e -> list2.contains(e)).collect(Collectors.toList());
        System.out.println(collect);





        //Given a list of transactions, find the sum of transaction amounts for each day using Java streamm
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> transactionsMap = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
        System.out.println(transactionsMap);





        //Find the kth smallest and biggest element in an array using Java streams
        int k = 3;
        System.out.println(list1.stream().sorted().distinct().skip(k - 1).findFirst().orElse(null));
        System.out.println(list1.stream().sorted(Collections.reverseOrder()).distinct().skip(k - 1).findFirst().orElse(null));





        //Implement a method to partition a list into two groups based on a predicate using Java streams
        Map<Boolean, List<Integer>> partitioned = integerList.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(partitioned.get(true));
        System.out.println(partitioned.get(false));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
