import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Employee employee5 = new Employee("Christopher Baileys", 26);
        Employee employee6 = new Employee("Christian Odiour", 39);

        Department hr = new Department("Human Resources");
        hr.addEmployee(employee1);
        hr.addEmployee(employee2);
        hr.addEmployee(employee3);

        Department ux = new Department("Research and Design");
        ux.addEmployee(employee4);
        ux.addEmployee(employee5);
        ux.addEmployee(employee6);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(ux);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
    }
}
