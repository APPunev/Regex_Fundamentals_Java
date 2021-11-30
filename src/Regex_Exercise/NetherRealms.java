package Regex_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double healthPoints = 0;
        double damagePoints = 0;

        List<String> names = Arrays.stream(scanner.nextLine().split(",")).map(el -> el.trim()).collect(Collectors.toList());
        Map<String, List<Double>> demons = new LinkedHashMap<>();
        for (String name:names) {
            demons.put(name, new ArrayList<>());
            healthPoints = healthPointCalc(name);
            demons.get(name).add(healthPoints);
            damagePoints = damagePointsCalc(name);
            demons.get(name).add(damagePoints);
        }
        demons.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    //"{demon name} - {health points} health, {damage points} damage"
                    System.out.print(entry.getKey() + " - ");
                    List<Double> values = entry.getValue();
                    System.out.printf("%.0f health,",values.get(0));
                    System.out.printf(" %.2f damage",values.get(1));
                    System.out.println();
                });
    }

    private static double damagePointsCalc(String name) {
        double sum = 0;
        String regex = "[-0-9.]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        StringBuilder builder = new StringBuilder();
        while(matcher.find()){
            String current = matcher.group();
            sum += Double.parseDouble(matcher.group());
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i)=='*') {
                sum *= 2;

            }else if (name.charAt(i)=='/') {
                sum /= 2;
            }
        }

        return sum;
    }

    private static double healthPointCalc(String name) {
        double healthPoints = 0;
        String healthRegex = "[^0-9\\+\\-\\*\\/\\.]";
        Pattern pattern = Pattern.compile(healthRegex);
        Matcher matcher = pattern.matcher(name);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()){
            builder.append(matcher.group());
        }
        String nameAfterRegex = builder.toString();
        for (int i = 0; i < nameAfterRegex.length(); i++) {
            healthPoints += nameAfterRegex.charAt(i);
        }
         return healthPoints;
    }
}
