import java.util.regex.*;
public class Calculator {


    public static void main(String[] args)  {
        try {
            System.out.println(add("1,2,3//;\n1000,1;2"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static int add(String SumNum) throws Exception {


        if (SumNum.isEmpty()) {
            return 0;
        }


        String delimeter = "[,\n]";
        if (SumNum.startsWith("//")) {
            String[] parts = SumNum.split("\n");
            delimeter = parts[0].substring(2);
            SumNum = parts[1];
        }
        delimeter = delimeter.replace("\\","\\\\");
        delimeter = delimeter.replace("-","\\-");
        String[] numbers = SumNum.split("["+delimeter+"]+");//store strings separated by comma and new line in the array





            if(SumNum.startsWith(" ")) {
                throw new Exception("ERROR: invalid input");
            }

            if(!SumNum.startsWith("//")&& SumNum.contains("//")){
                throw new Exception("ERROR: invalid input ");
            }
            if(!Pattern.compile("[0-9]").matcher(SumNum.substring(SumNum.length()-1)).matches()){
                throw new Exception("ERROR: invalid input");
            }




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


