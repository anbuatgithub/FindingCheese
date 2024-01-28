package com.meeran.stringandpatterns;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Trumpdetector {
	public static double detect(String trumpySpeech) {
        //your code here
		Pattern pattern = Pattern.compile("[a]+|[e]+|[i]+|[o]+|[u]+", Pattern.CASE_INSENSITIVE); 
		Matcher matcher = pattern.matcher(trumpySpeech);
		int vowelCount =0;
		int occurrence =0;
		while(matcher.find()) {
			if(matcher.group().length()>1) {
				vowelCount += matcher.group().length()-1;
			}
			occurrence++;
		}
		return vowelCount==0 ? 0 : Math.round((vowelCount*1.0/occurrence)*100.0)/100.0;
   }
	@Test
    public void sampleTests() {
         assertEquals(0, Trumpdetector.detect("I will build a huge wall"),0.001);
         assertEquals(4, Trumpdetector.detect("HUUUUUGEEEE WAAAAAALL"),0.001);
         assertEquals(2.5, Trumpdetector.detect("MEXICAAAAAAAANS GOOOO HOOOMEEEE"),0.001);
         assertEquals(1.89, Trumpdetector.detect("America NUUUUUKEEEE Oooobaaaamaaaaa"),0.001);
         assertEquals(1.56, Trumpdetector.detect("listen migrants: IIII KIIIDD YOOOUUU NOOOOOOTTT"),0.001);
    }
	
	private static final List<String> base =new LinkedList<>(List.of ("naughty countries", "kill", "bad foreigners", "I have long fingers", "pretty wife", "excellent sons", "go home", "migrants", "great", "America", "listen", "Obama", "power", "tradition", "family", "religion", "huge", "wall", "nuke", "I kid you not", "I am telling the truth", "bombs", "mexicans", "border", "hillary", "I am rich", "I am very rich", "I am filthy rich", "migrants", "build", "I know it", "success", "trump", "trump university", "good Americans")),
            extra = List.of("", "", "", "", "", ",", ",", ":", ".", "!", "?", "!!!", "!?!", "...", "!!!!!!1!!", "!!!?!?!?!?!");
    private static Random random = new Random();
   
    @Test
    public void randomTests() {
        for (int testno = 0; testno < 40; testno++) {
            Collections.shuffle(base);
            String test = base
                    .subList(0, random.nextInt(base.size()-3)+3)
                    .stream()
                    .map(w -> transfomWord(w))
                    .collect(Collectors.joining(" "));
                           
            test = Character.toUpperCase(test.charAt(0))+test.substring(1);           
            assertEquals(solution(test), Trumpdetector.detect(test),0.001);
        }
    } // random Tests

    private String transfomWord(String word){
        StringBuilder transformedWord=new StringBuilder();
        for (char c : word.toCharArray()){
            transformedWord.append(c);
            if (VOWELS.contains(c)){
                transformedWord.append(String.valueOf(c).repeat( random.nextInt(5)));
            }
        }
      
        return (random.nextBoolean() ? 
                transformedWord.toString() : transformedWord.toString().toUpperCase())+
                (extra.get(random.nextInt(extra.size())));
    }
    // --------------------------------------------------
    private static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static double solution(String trumpySpeech) {
        int count = 0, total = 0, last = ' ';
        for (char c : trumpySpeech.toLowerCase().toCharArray()) {
            if (VOWELS.contains(c)) {
                if (c == last) {
                    count++;
                } else {
                    total++;
                }
            }
            last = c;
        }
        return Math.round(count * 100.0 / total) / 100.0;
    }
}
