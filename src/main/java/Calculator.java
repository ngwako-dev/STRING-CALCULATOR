import java.util.Arrays;
import java.util.regex.*;
public class Calculator {


    public static void main(String[] args) throws Exception {
        try {
            System.out.println(add("//***\n1***2***3"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static int add(String SumNum) throws Exception {

//          Pattern p = Pattern.compile("[0-9]");
//          Matcher m = p.matcher(SumNum);


        if (SumNum.isEmpty()) {
            return 0;
        }


        String delimeter = "[,\n]";
        if (SumNum.startsWith("//")) {
            String[] parts = SumNum.split("\n");
            delimeter = parts[0].substring(2);
            SumNum = parts[1];
        }


        String[] numbers = SumNum.split("["+delimeter+"]+");//store strings separated by comma and new line in the array
        StringBuilder negative = new StringBuilder();


        for (String a : numbers) {
            if (Integer.parseInt(a) < 0) {
                negative.append(a);
            }
            if (a.equals(numbers[numbers.length - 1]) && (negative.length() > 0)) {
                throw new Exception("ERROR: negatives not allowed " + negative);
            }



            }
            int sum = 0;
            for (String input : numbers) {
                int nums = Integer.parseInt(input);//convert strings to integer
                if (nums < 1000) {
                    sum += nums;
                }
            }
         return sum;


    }
}


