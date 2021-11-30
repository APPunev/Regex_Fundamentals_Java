package Regex_LAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();
        String regex = "\\+359(?<separator>[- ])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern patern = Pattern.compile(regex);
        Matcher match = patern.matcher(numbers);

        List<String> phoneMatch = new ArrayList<>();
        while(match.find()){
            phoneMatch.add(match.group());
        }
        System.out.println(phoneMatch.toString().replaceAll("[\\[\\]]", ""));
    }
}
