package Regex_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //After decryption:
        //Each message should have a planet name, population, attack type ('A', as attack or 'D', as destruction) and soldier count.
        //The planet name starts after '@' and contains only letters from the Latin alphabet.
        //The planet population starts after ':' and is an Integer;
        //The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (exclamation mark).
        //The soldier count starts after "->" and should be an Integer.
        //The order in the message should be: planet name -> planet population -> attack type -> soldier count.
        // Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.

        //STCDoghudd4=63333$D$0A53333
        //EHfsytsnhf?8555&I&2C9555SR
        Map<String, List<String>> mapPlanets = new TreeMap<>();
        mapPlanets.put("Attacked", new ArrayList<>());
        mapPlanets.put("Destroyed", new ArrayList<>());

        int attackedCount = 0;
        int destroyedCount = 0;

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();

            //To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive
            // and remove the count from the current ASCII value of each symbol of the encrypted message.
            String decriptedMessage = decription(input);

            String regex = "@(?<planet>[A-Za-z]+)[^-@!:>]*:(?<population>\\d+)[^-@!:>]*!(?<atackType>[AD])![^-@!:>]*->(?<soldiersCount>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decriptedMessage);

            while(matcher.find()){
                String planetName = matcher.group("planet");
                String attackType = matcher.group("atackType");
                if (attackType.equals("A")) {
                    attackType = "Attacked";
                    mapPlanets.get(attackType).add(planetName);
                    attackedCount++;
                }else{
                    attackType = "Destroyed";
                    mapPlanets.get(attackType).add(planetName);
                    destroyedCount++;
                }
            }
        }
        mapPlanets
                .entrySet()
                .stream()
                .forEach(el -> {
                    System.out.println(el.getKey() + " planets: " + el.getValue().size());
                    el.getValue().stream().sorted().forEach(list -> System.out.println("-> " + list));
                });

    }



    private static String decription(char[] input) {

        int count = 0;
        for (char element:input) {
            if (element == 's' || element == 'S'||element == 't'||element == 'T'||element == 'a'||element == 'A'||element == 'r'||element == 'R') {
                count++;
            }
        }
        StringBuilder decripted = new StringBuilder();
        for (int j = 0; j < input.length; j++) {
            int newChar = input[j] - count;
            decripted.append((char)newChar);
        }
        String finalMessage = decripted.toString();
        return finalMessage;
    }
}
