import entities.Student;

import java.util.List;
import java.util.Optional;


//short-circuit operations:
public class ShortCircuitOperations {
    public static void main(String[] args) {
//        List<Integer> numbers = List.of(1,3,5,10,100,512,-2,-3,-5,1000);
//        List<Student> students = List.of(
//                new Student(1, "Jay", 12),
//                new Student(2, "Anjaniy", 12),
//                new Student(3, "Jaymin", 13),
//                new Student(4, "Ruchita", 11),
//                new Student(5, "Asuka", 11),
//                new Student(6, "Jin", 16),
//                new Student(7, "Jay", 12));
//
//        //intermediate - operations
//        // limit(maxSize):
//        List<Student> limitedStudents = students.stream().limit(2).toList();
//        limitedStudents.forEach(System.out::println);
//
//        //terminal - operations
//        //findFirst():
//        Optional<Integer> firstEvenNumber = numbers.stream().filter(number -> number % 2 == 0).findFirst();
//        System.out.println("First even number: " + firstEvenNumber.get());
//
//        //findAny() (only works with parallel stream, without parallel stream it will give the same results as findFirst):
//        Optional<Integer> randomEvenNumber = numbers.stream().parallel().filter(number -> number % 2 == 0).findAny();
//        System.out.println("Random even number from a list: " + randomEvenNumber.get());
//
//        //anyMatch(predicate):
//        boolean anyMatch = students.stream().anyMatch(student -> student.getName().toLowerCase().contains("ja"));
//        System.out.println("any name starts with `ja`: " + anyMatch);
//
//        //allMatch(predicate):
////        boolean allMatch = students.stream().allMatch(student -> student.getAge() > 10 && student.getAge() < 20);
//        boolean allMatch = students.stream().allMatch(student -> student.getAge() > 14 && student.getAge() < 20);
//        System.out.println("student that are present in a given age range are: " + allMatch);
    }
}
