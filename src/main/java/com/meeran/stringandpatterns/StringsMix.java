package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class StringsMix {
	public static String mix(String s1, String s2) {
	      // your code
		Map<Character, Integer> s1Map = findOccurence(s1);
		Map<Character, Integer> s2Map = findOccurence(s2);
		System.out.println("s1Map-->"+s1Map);
		System.out.println("s2Map-->"+s2Map);
		final List<Character> allCharacters = new ArrayList<>(s2Map.keySet());

        for (char c : new ArrayList<>(s1Map.keySet())) {
            if (!allCharacters.contains(c)) {
                allCharacters.add(c);
            }
        }
        System.out.println("allCharacters-->"+allCharacters);
        List<String> resultList = new ArrayList<>();
		for(int i = 0; i < allCharacters.size(); i++) {
			int s1Count=0, s2Count=0;
			StringBuffer result = new StringBuffer();
			char currentchar = allCharacters.get(i);
			if(s1Map.get(currentchar)!=null) s1Count= s1Map.get(currentchar);
			if(s2Map.get(currentchar)!=null) s2Count= s2Map.get(currentchar);
			if(s1Count>s2Count) result.append("1:"+repeatNTimes(currentchar,s1Count));
			else if(s1Count<s2Count) result.append("2:"+repeatNTimes(currentchar,s2Count));
			else result.append("=:"+repeatNTimes(currentchar,s1Count));
			resultList.add(result.toString());
		}
		System.out.println("resultList-->"+resultList);
		return resultList.stream()
                .sorted(Comparator.comparing(String::length)
                        .reversed()
                        .thenComparing(s -> s.length() == 0 ? -1 : s.charAt(0))
                        .thenComparing(Function.identity()))
                .collect(Collectors.joining("/"));
	}
	
	private static Map<Character, Integer> findOccurence(String str){
		Map<Character, Integer> outputMap = new LinkedHashMap<Character, Integer>();
		for(Character ch : str.toCharArray()) {
			if(Character.isAlphabetic(ch) && Character.isLowerCase(ch)) 
				outputMap.put(ch, outputMap.getOrDefault(ch, 0)+1);
		}
		return outputMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	private static String repeatNTimes(Character s, int n) { 
	    StringBuilder repeatStr = new StringBuilder(); 
	    for (int i = 0; i < n; i++) { 
	    	repeatStr.append(s); 
	    } 
	    return repeatStr.toString(); 
	} 
	
	@Test
    public void test() {
        System.out.println("Mix Fixed Tests");
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", mix("Are they here", "yes, they are here"));
        assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
        		mix("looping is fun but dangerous", "less dangerous than coding"));
        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
        		mix(" In many languages", " there's a pair of functions"));
        assertEquals("1:ee/1:ll/1:oo", mix("Lords of the Fallen", "gamekult"));
        assertEquals("", mix("codewars", "codewars"));
        assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
        		mix("A generation must confront the looming ", "codewarrs"));
		 
    }
}
