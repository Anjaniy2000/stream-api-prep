import entities.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

//segregate each student based on their age,
//return a key-value pair in which key is age and value is list of students that belongs to that particular age:
public class GroupByAgeForStudents {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(1, "Jay", 12),
                new Student(2, "Anjaniy", 12),
                new Student(3, "Jaymin", 13),
                new Student(4, "Ruchita", 11),
                new Student(5, "Asuka", 11),
                new Student(6, "Jin", 16),
                new Student(7, "Jay", 12));

        //classification function in grouping by (1st variant[internally calls 2nd variant with toList() hard-coded])
//        Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(student -> student.getAge()));
//        System.out.println(map);

        //removing the duplicates (2nd variant[internally calls 3rd variant with HashMap::new hard-coded])
//        Map<Integer, Set<Student>> map = students.stream().collect(Collectors.groupingBy(student -> student.getAge(), Collectors.toSet()));
//        System.out.println(map);

        //sorting (3rd variant)
        Map<Integer, Set<Student>> map = students.stream().collect(Collectors.groupingBy(student -> student.getAge(), TreeMap::new, Collectors.toSet()));
        System.out.println(map);
    }
}
