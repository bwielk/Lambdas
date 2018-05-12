import java.util.ArrayList;
import java.util.List;
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
