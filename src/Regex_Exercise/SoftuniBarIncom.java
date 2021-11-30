package Regex_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniBarIncom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //	•	Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters
        //	•	Valid product contains any word character and must be surrounded by '<' and '>'
        //	•	Valid count is an integer, surrounded by '|'
        //	•	Valid price is any real number followed by '$'
        //The parts of a valid order should appear in the order given: customer, product, count and a price.
        //Between each part there can be other symbols, except ('|', '$', '%' and '.')
        //For each valid line print on the console: "{customerName}: {product} - {totalPrice}"
        //When you receive "end of shift" print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}".
        //Input / Constraints
        //	•	Strings that you have to process until you receive text "end of shift".
        //Output
        //	•	Print all the valid lines in the format "{customerName}: {product} - {totalPrice}"
        //	•	After receiving "end of shift" print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}"
        //	•	Allowed working time / memory: 100ms / 16MB.

        String input = scanner.nextLine();
        //%George%<Croissant>|2|10.3$
        String regex = "%(?<customer>[A-Z][a-z]*)%[^\\%$.]*<(?<product>\\w+)>[^%$|.]*\\|(?<count>[0-9]+)\\|[^\\%$.]*?(?<price>[0-9]+\\.*[0-9]*)\\$";
                      //%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\w+)>[^|$%.]*\|(?<count>\d+)\|[^|$%.]*?(?<price>[-+]?[0-9]*\.?[0-9]+([eE][-+]?[0-9]+)?)\$
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;

        while(!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()){

                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));


                double totalPrice = price * count;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n",name, product,totalPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
