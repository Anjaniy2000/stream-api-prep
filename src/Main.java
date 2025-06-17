
import entities.Employee;
import entities.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //supplier:
        Supplier<Integer> generateRandomNumber = () -> {
            return (int) (Math.random() * 10);
        };
        System.out.println(generateRandomNumber.get());

        //consumer:
        Consumer<String> greetings = (message) -> {
          System.out.println(message);
        };
        greetings.accept("Good Morning");

        //predicate:
        Predicate<Integer> isEven = (number) -> {
            return (number % 2 == 0);
        };
        System.out.println(isEven.test(12));
        System.out.println(isEven.test(301));

        //function:
        Function<Student, Integer> mapToRollNo = (student -> {
            return student.getRollNo();
        });
        Student jay = new Student(1,"Jay");
        Student sam = new Student(2, "Sam");
        System.out.println("Role No of Jay = " + mapToRollNo.apply(jay));
        System.out.println("Role No of Sam = " + mapToRollNo.apply(sam));




        //stream api prep:

        //square of all the elements present in a list:
        //also extract the average of it:
        List<Integer> numbers = List.of(1,2,3,5,10,100,512,-2,-3,-5,1000);
        // List<Integer> squaredNumbers = numbers.stream().map(number -> number * number).toList(); // immutable list
        // squaredNumbers.add(2); // will throw error -> unsupportedOperationException
        List<Integer> squaredNumbers = numbers.stream().map(number -> number * number).collect(Collectors.toList()); // mutable list
        squaredNumbers.forEach(System.out::println);

        //getting an average:
        double average = numbers.stream().map(number -> number * number).mapToInt(number -> number).average().getAsDouble();
        System.out.println("Average : " + average);

        //sort elements - ASC:
        System.out.println("ASC Elements: ");
        numbers.stream().sorted().forEach(System.out::println);

        System.out.println();
        //sort elements - DESC:
        System.out.println("DESC Elements: ");
        numbers.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);





        //sort the employees based on the salary, if two employees have same salary then sort by name:
        //both asc and desc:
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "Jay Shah", "jay101shah@gmail.com", 30000D),
                new Employee(2, "Anjaniy Salekar", "anjaniy01salekar@gmail.com", 30000D),
                new Employee(3, "Deepak Salekar", "deepak101salekar@gmail.com", 35000D),
                new Employee(4, "Ruchita Salekar", "ruchita101salekar@gmail.com", 20000D),
                new Employee(5, "Chetan Salekar", "chetan101salekar@gmail.com", 40000D)
        ));

        //asc:
        System.out.println("ASC Employees : ");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);

        System.out.println();
        //desc:
        System.out.println("DESC Employees : ");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName).reversed()).forEach(System.out::println);

        System.out.println("How many numbers of employees having salary greater then 30k = "
                +
                employees.stream().filter(employee -> employee.getSalary() > 30000).count());






        //reverse an array in-place via streams:
        int[] array = {1,2,3,5,10,100,512,-2,-3,-5,1000};
        IntStream.range(0, array.length / 2).forEach(i -> {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        });
        System.out.println("Reversed an array in-place");
        Arrays.stream(array).forEach(System.out::println);





        //print top 3 salaried employees:
        System.out.println("Top 3 salaried employees : ");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);

        //fetch the employees having salary less than 3rd highest salary:
        System.out.println("Employee having 3rd highest salary");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).skip(2).forEach(System.out::println);






        //print the second highest and the lowest number from a list:
        List<Integer> numbers2 = List.of(1,2,3,5,10,100,512,-2,-3,-5,1000,1,2,10,1000,-3,-2,512);
        System.out.println("Second lowest number");
        numbers2.stream().sorted().distinct().limit(2).skip(1).forEach(System.out::println);
        System.out.println("Second highest number");
        numbers2.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).forEach(System.out::println);





        //print odd numbers and even numbers of a list
        System.out.println("Evens");
        numbers2.stream().filter(number -> number % 2 == 0).distinct().forEach(System.out::println);
        System.out.println("Odds");
        numbers2.stream().filter(number -> number % 2 != 0).distinct().forEach(System.out::println);





        //print the numbers starts with the given prefix (2 [both + and -]):
        System.out.println("Number starts with prefix (2 [both + and -])");
        List<Integer> numbers3 = List.of(22,21,34,56,222,2,112,121,-25,-216,1002,2002);
        numbers3.stream()
                .map(number -> String.valueOf(number))
                .filter(number -> number.startsWith("2") || number.startsWith("-2"))
                .map(number -> Integer.valueOf(number))
                .forEach(System.out::println);





        //mapToInt -> summaryStatistics:
        System.out.println("Max : " + numbers.stream().mapToInt(number -> number).summaryStatistics().getMax());
        System.out.println("Min : " + numbers.stream().mapToInt(number -> number).summaryStatistics().getMin());
        System.out.println("Average : " + numbers.stream().mapToInt(number -> number).summaryStatistics().getAverage());
        System.out.println("Sum : " + numbers.stream().mapToInt(number -> number).summaryStatistics().getSum());





        //print the duplicate elements of a list:
        Set<Integer> set = new HashSet<>();
        System.out.println("Duplicate Elements : ");
        numbers2.stream().filter(number -> (!set.add(number))).forEach(System.out::println);
        System.out.println("Via Collections().frequency()");
        numbers2.stream().filter(number -> Collections.frequency(numbers2, number) > 1).distinct().forEach(System.out::println);
    }
}