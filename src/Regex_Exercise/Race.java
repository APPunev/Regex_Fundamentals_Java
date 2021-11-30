package Regex_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //George, Peter, Bill, Tom
        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        // racerName -> distance(0)
        racers.forEach(racer -> racersDistances.put(racer, 0));
        String regexLetters = "[A-Za-z]+";
        Pattern patternName = Pattern.compile(regexLetters);
        String regexDistance = "[0-9]";
        Pattern patternDistance = Pattern.compile(regexDistance);
        //["George", "Peter", "Bill", "Tom"]
        String input = scanner.nextLine();
        //"G!32e%o7r#32g$235@!2e"
        while(!input.equals("end of race")){

            //letters will be the name of the racer
            StringBuilder builderName = new StringBuilder();
            Matcher matcher = patternName.matcher(input);
            while(matcher.find()){
                builderName.append(matcher.group());
            }
            //sum of all numbers will be the distance
            int distance = 0;
            Matcher matchDistance = patternDistance.matcher(input);
            while(matchDistance.find()){
                distance += Integer.parseInt(matchDistance.group());
            }
            String name = builderName.toString();

            if (racersDistances.containsKey(name)){
                int currentDistance = racersDistances.get(name);
                racersDistances.put(builderName.toString(),currentDistance + distance);
            }
            input = scanner.nextLine();
        }
        //sorting by decending order of the distance
        List<String> first3Best = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.printf("1st place: %s%n",first3Best.get(0));
        System.out.printf("2nd place: %s%n",first3Best.get(1));
        System.out.printf("3rd place: %s%n",first3Best.get(2));
    }
}
