import entities.Book;
import entities.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        //Collectors.
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "alice@example.com", 75000.0, 28, "Female", "IT"),
                new Employee(2, "Bob", "bob@example.com", 62000.0, 35, "Male", "HR"),
                new Employee(3, "Charlie", "charlie@example.com", 82000.0, 30, "Male", "Finance"),
                new Employee(4, "Diana", "diana@example.com", 92000.0, 26, "Female", "Marketing"),
                new Employee(5, "Ethan", "ethan@example.com", 58000.0, 40, "Male", "Operations"),
                new Employee(6, "Fiona", "fiona@example.com", 76000.0, 29, "Female", "IT"),
                new Employee(7, "George", "george@example.com", 67000.0, 33, "Male", "Finance"),
                new Employee(8, "Hannah", "hannah@example.com", 89000.0, 27, "Female", "Marketing"),
                new Employee(9, "Ian", "ian@example.com", 54000.0, 45, "Male", "HR"),
                new Employee(10, "Jasmine", "jasmine@example.com", 73000.0, 32, "Female", "IT")
        );



        List<Book> books = List.of(
                new Book(1, "Harry Potter", "Fiction", 100),
                new Book(2, "Effective Java", "Programming", 550),
                new Book(3, "The Alchemist", "Philosophy", 300),
                new Book(4, "Clean Code", "Programming", 600),
                new Book(5, "Rich Dad Poor Dad", "Finance", 250),
                new Book(6, "Atomic Habits", "Self-Help", 400),
                new Book(7, "The Lean Startup", "Business", 450),
                new Book(8, "Sapiens", "History", 500),
                new Book(9, "The Da Vinci Code", "Thriller", 350),
                new Book(10, "Think Like a Monk", "Philosophy", 270)
        );

        //convert the employee name to uppercase and joined all of them with comma sign:
        System.out.println("Employee Names with Uppercase with , sign");
        String collected = employees.stream().map(employee -> employee.getName()).map(name -> name.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(collected);





        //Find the count of book in each category:
        Map<String, Long> booksMap = books.stream().collect(Collectors.groupingBy(Book::getCategory, Collectors.counting()));
        System.out.println(booksMap);





        //Find the count of employee in each department:
        Map<String, Long> employeesMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeesMap);





        //Find the average age of male and female employee:
        Map<String, Double> averageAgeByGenderMap = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAgeByGenderMap);





        //Find the department who is having maximum number of employee:
        Map.Entry<String, Long> entry = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(entry);





        //Find the average salary in all departments:
        Map<String, Double> averageSalaryByGroupMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryByGroupMap);





        //Find the highest salary in each department:
        Map<String, Optional<Employee>> highestSalaryByDepartmentMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(highestSalaryByDepartmentMap);
    }
}
