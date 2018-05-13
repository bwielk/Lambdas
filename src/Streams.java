import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Streams {

    public static void main(String[] args) {

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
    }
}
