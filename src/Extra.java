import entities.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Extra {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Jay Shah", "jay101shah@gmail.com", 30000D),
                new Employee(2, "Anjaniy Salekar", "anjaniy01salekar@gmail.com", 25000D),
                new Employee(3, "Deepak Salekar", "deepak101salekar@gmail.com", 35000D),
                new Employee(4, "Ruchita Salekar", "ruchita101salekar@gmail.com", 20000D),
                new Employee(5, "Chetan Salekar", "chetan101salekar@gmail.com", 40000D)
        );
        //Filter the employees with salary greater than 25000 and find the maximum out of it:
        //double result = employees.stream().filter(e -> e.getSalary() > 25000).mapToDouble(e -> e.getSalary()).summaryStatistics().getMax();
        Double result = employees.stream().filter(e -> e.getSalary() > 25000).map(e -> e.getSalary()).reduce((s1, s2) -> s1 > s2 ? s1 : s2).get();
        System.out.println(result);


        List<List<String>> data = List.of(
                List.of("Java", "Python"),
                List.of("C++", "JavaScript")
        );

        List<String> result2 = data.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(result2);

        //Split a list of sentences into words
        List<String> sentences = List.of(
                "I love Java",
                "Streams are powerful"
        );
        sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);





        //Flatten a list of comma-separated string values
        List<String> csvData = List.of("a,b,c", "d,e", "f");
        csvData.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .forEach(System.out::println);





        //Flatten a List of List of Integers
        List<List<Integer>> numbers = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5)
        );

        numbers.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);


        //data update:
        //check if employee's salary is less than 20k, if so then add 2k and append '_underpaid' with their name.
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() < 30000).map(e -> {
            e.setSalary(e.getSalary() + 2000);
            e.setName(e.getName() + " " + "_underpaid");
            return e;
        }).toList();
        System.out.println(employeeList);
    }
}
