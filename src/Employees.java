import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Employees {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Blazej", 21);
        Employee employee2 = new Employee("Tomasso", 32);
        Employee employee3 = new Employee("Simon", 43);
        Employee employee4 = new Employee("Bartolomeu", 33);
        Employee employee5 = new Employee("Christopher", 26);
        Employee employee6 = new Employee("Christian", 39);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge()>=30);
        printEmployeesByAge(employees, "Employees under 30", employee -> employee.getAge()<30);
        printEmployeesByAge(employees, "Employees under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan10 = i -> i>10;
        IntPredicate lessThan12 = i -> i<12;
        IntPredicate lessThan100 = i -> i <100;
        System.out.println("\n1 " + greaterThan10.test(11));
        System.out.println("\n2 " + greaterThan10.negate().test(11));
        System.out.println("\n3 " + lessThan12.or(lessThan100).test(99));
        System.out.println("\n4 " + greaterThan10.and(lessThan100).test(20));
        System.out.println("\n5 " + greaterThan10.and(lessThan100).test(1));
        System.out.println("\n6 " + greaterThan10.and(lessThan100).test(111));
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> condition){
        System.out.println(ageText);
        System.out.println("*****************************");
        for(Employee e : employees){
            if(condition.test(e)){
                System.out.println(e.getName());
            }
        }
    }
}