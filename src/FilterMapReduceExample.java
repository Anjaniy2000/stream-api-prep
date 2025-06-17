import entities.Employee;

import java.util.List;
import java.util.Optional;

//Filter the employees with salary greater than 25000 and find the maximum out of it:
public class FilterMapReduceExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Jay Shah", "jay101shah@gmail.com", 30000D),
                new Employee(2, "Anjaniy Salekar", "anjaniy01salekar@gmail.com", 25000D),
                new Employee(3, "Deepak Salekar", "deepak101salekar@gmail.com", 35000D),
                new Employee(4, "Ruchita Salekar", "ruchita101salekar@gmail.com", 20000D),
                new Employee(5, "Chetan Salekar", "chetan101salekar@gmail.com", 40000D)
        );

        Optional<Double> maxSalary = employees.stream()
                .filter(employee -> employee.getSalary() > 25000)
                .map(employee -> employee.getSalary())
                .reduce((a, b) -> a > b ? a : b);

        System.out.println("Max Salary: " + maxSalary.get());
    }
}
