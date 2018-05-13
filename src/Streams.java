import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        //BINGO NUMBERS PROJECT

        List<String> bingoNumbers = Arrays.asList(
                "N30", "N45", "N46",
                "E12", "E14", "E30",
                "B21", "B22", "B31",
                "I1", "I10", "I27", "i30",
                "033");

        List<String> iNumbers = new ArrayList<>();

//        bingoNumbers.forEach(bingoNumber -> {
//            if(bingoNumber.toUpperCase().startsWith("I")){
//                iNumbers.add(bingoNumber);
//                System.out.println(bingoNumber);
//            }
//        });
//
//        System.out.println(iNumbers.size());
//        iNumbers.sort((String s1, String s2) -> (s1.compareTo(s2)));
//        iNumbers.forEach(inumber -> {
//            System.out.println(inumber);
//        });

        bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("I"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumber = Stream.of("I13", "I76", "I99", "O42", "O55");
        Stream<String> inNumber = Stream.of("N34", "N65", "N64", "I19", "I45", "I65", "O55", "o55");

        Stream<String> concatStream = Stream.concat(ioNumber, inNumber);
        //System.out.println(concatStream.distinct().count());
        System.out.println("======================+");
        System.out.println(concatStream
                .distinct()
                .sorted()
                .peek(System.out::println)
                .count());

        //DEPARTMENTS PROJECT

        Employee employee1 = new Employee("Blazej Wielk", 21);
        Employee employee2 = new Employee("Tomasso Angelo", 32);
        Employee employee3 = new Employee("Simon Smith", 43);
        Employee employee4 = new Employee("Bartolomeu Diaz", 33);
        Employee employee5 = new Employee("Christopher Baileys", 21);
        Employee employee6 = new Employee("Christian Odiour", 39);
        Employee employee7 = new Employee("Carlie Simonne", 43);
        Employee employee8 = new Employee("Sasha Struninew", 50);
        Employee employee9 = new Employee("Stanley Dido", 33);

        Department hr = new Department("Human Resources");
        hr.addEmployee(employee1);
        hr.addEmployee(employee2);
        hr.addEmployee(employee3);
        hr.addEmployee(employee7);

        Department ux = new Department("Research and Design");
        ux.addEmployee(employee4);
        ux.addEmployee(employee5);
        ux.addEmployee(employee6);
        ux.addEmployee(employee8);
        ux.addEmployee(employee9);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(ux);

        System.out.println("/////////////////////PRINTING ALL THE EMPLOYEES////////////////////////////////");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("/////////////////////PRINTING ALL THE EMPLOYEES OVER 30////////////////////////////////");
        //collects items from a stream to create a new list/collection
        List<Employee> streamToList = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getAge() >= 30)
                .collect(Collectors.toList());
        for(Employee e : streamToList ){
            System.out.println(e.getName() + " AGE => " + e.getAge());
        }

        System.out.println("/////////////////////PRINTING ALL THE EMPLOYEES UNDER 30////////////////////////////////");
        //collects items from a stream to create a new list/collection - with specific streams of commands
        List<Employee> streamToArrayList = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getAge() < 30)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for(Employee e : streamToArrayList ){
            System.out.println(e.getName() + " AGE => " + e.getAge());
        }

        System.out.println("/////////////////////PRINTING ALL THE EMPLOYEES GROUPED BY AGE////////////////////////////////");
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println(groupedByAge.toString());

        System.out.println("/////////////////////PRINTING THE YOUNGEST EMPLOYEE////////////////////////////////");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2 )
                .ifPresent(System.out::println);
    }
}
