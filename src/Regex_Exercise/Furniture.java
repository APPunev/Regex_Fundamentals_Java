package Regex_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]+)!(?<quantity>[0-9]+)";

        double totalSum = 0;

        List<String> furnitureList = new ArrayList<>();

        while(!input.equals("Purchase")){
            //">>{furniture name}<<{price}!{quantity}"
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(input);

            while (match.find()){
                String furniture = match.group("furniture");
                double price = Double.parseDouble(match.group("price"));
                int quantity = Integer.parseInt(match.group("quantity"));

                furnitureList.add(furniture);
                totalSum += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitureList.forEach(el -> System.out.println(el));
        System.out.printf("Total money spend: %.2f",totalSum);
    }
}
