public class LambdaMyExamples {

    public static void main(String[] args) {
        String s1 = "MyNameIs";
        String s2 = "IDon'tKnowMyName";

        CountsCharacters c = (s) -> {
            char[] chars = s.toCharArray();
            return chars.length;
        };

        System.out.println("Number of chars for " + s1 + " => " + c.countChars(s1));
        System.out.println("Number of chars for " + s2 + " => " + c.countChars(s2));

        CountsCharsAndComparesStrings cac = (st1, st2) -> {
            int numOfCharsSt1 = st1.toCharArray().length;
            int numOfCharsSt2 = st2.toCharArray().length;
            if (numOfCharsSt1 > numOfCharsSt2) {
                System.out.println(st1 + " is greater than " + st2);
            } else if (numOfCharsSt1 < numOfCharsSt2) {
                System.out.println(st2 + " is greater than " + st1);
            } else {
                System.out.println(st2 + " and " + st1 + " are equal");
            }
        };

        cac.countAndCompare(s1, s2);
        cac.countAndCompare("Abcefg","Hijklmn");

        Add a = (num1, num2) -> {
            return num1 + num2;
        };

        System.out.println("The result of adding => " + a.addNumbers(12, 3));

        Multiply m = (num1, num2) -> {
            return num1*num2*num1*num2;
        };

        System.out.println("The result of multiplying => " + m.multiplyNums(1,2));

        Multiply m1 = (num1, num2) -> {
            Double d = (Math.pow(num1, 3) + Math.pow(num2, 3));
            return d.intValue();
        };

        Multiply m2 = (num1, num2) -> {
            return num1*num2*20;
        };

        System.out.println("The result of multiplying m2 => " +  m2.multiplyNums(6,7));

        System.out.println("The result of multiplying m1 => " + m1.multiplyNums(2, 5));
    }
}

interface CountsCharacters {
    public int countChars(String s);
}

interface CountsCharsAndComparesStrings {
    public void countAndCompare(String s1, String s2);
}

interface Add {
    public int addNumbers(int a, int b);
}

interface Multiply {
    public int multiplyNums(int a, int c);
}
