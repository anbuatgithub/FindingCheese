package anbu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class CommonCharacter {
    public static void main(String[] args) {
        Arrays.stream(commonCharacters(new String[]{"abc","bcda","c"})).forEach(System.out::println);
    }

    public  static  String[] commonCharacters(String[] strings) {
        HashMap<Character, Integer> characterCounts =
                new HashMap<Character, Integer>();
        for (String string : strings) {
            HashSet<Character> uniqueStringCharacters = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                uniqueStringCharacters.add(string.charAt(i));
            }
            for (char character : uniqueStringCharacters) {
                if (!characterCounts.containsKey(character)) {
                    characterCounts.put(character, 0);
                }

                characterCounts.put(character, characterCounts.get(character) +1 );
            }
        }
        ArrayList<Character> finalCharacters = new ArrayList<Character>();
        for (Map.Entry<Character, Integer> characterCount :
                characterCounts.entrySet()) {
            Character character = characterCount.getKey();
            Integer count = characterCount.getValue();
            if (count == strings.length) {
                finalCharacters.add(character);
            }
        }

        String[] finalCharacter = new String[finalCharacters.size()];
        for(int i=0;i< finalCharacter.length;i++){
            finalCharacter[i]= finalCharacters.get(i).toString();
        }
        return finalCharacter;
    }
}