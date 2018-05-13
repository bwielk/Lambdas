import java.sql.SQLOutput;
import java.util.*;

public class Lambda {

    public static void main(String[] args) {
        //new Thread(new CodeToRun()).start();
        new Thread(() -> {
            System.out.println("Printing from runnable");
            System.out.println("Line 2");
            System.out.println("Line 3");
        }).start();

        Employee employee1 = new Employee("Blazej", 21);
        Employee employee2 = new Employee("Tomasso", 32);
        Employee employee3 = new Employee("Simon", 43);
        Employee employee4 = new Employee("Bartolomeu", 33);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        Collections.sort(employees, (e1, e2) ->
            e1.getName().compareTo(e2.getName()));

        for(Employee e : employees){
            System.out.println(e.getName() + " age => " + e.getAge());
        }

        UpperConcat uc = ((s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        });
        System.out.println(doStringStuff(uc, employees.get(1).getName(), employees.get(2).getName()));
        System.out.println(new AnotherClass().doSomething());
    }

    public static final String doStringStuff(UpperConcat u1, String s1, String s2){
        return u1.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return name;
    }

}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething(){
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass' name is " + getClass().getSimpleName());
        return Lambda.doStringStuff(uc, "String1", "String2");
    }

    public void printValue(){
        int number = 25;
        Runnable r = () -> {
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
               e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}
