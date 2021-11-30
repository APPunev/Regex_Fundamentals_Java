package Regex_LAB;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "\\b(?<day>\\d{2})(?<sep>[-.\\/])(?<month>[A-Z][a-z]+)\\2(?<year>\\d{4})";

        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        //Day: 13, Month: Jul, Year: 1928
        //Day: 10, Month: Nov, Year: 1934
        //Day: 25, Month: Dec, Year: 1937

        while(match.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",match.group("day"),match.group("month"),match.group("year"));
        }
    }
}
