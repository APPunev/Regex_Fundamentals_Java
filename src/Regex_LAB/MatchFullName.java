package Regex_LAB;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern patern = Pattern.compile(regex);
        Matcher match = patern.matcher(names);

        while(match.find()){
            System.out.print(match.group() + " ");
        }
    }
}
