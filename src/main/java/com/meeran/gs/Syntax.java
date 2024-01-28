package com.meeran.gs;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Syntax {
	public static void main(String[] args) {
		
		
		//Sort Map by values
		
		Map<String, String> country = new HashMap<String,String>();
		country.put("India", "New Delhi");
        country.put("USA", "Washington D.C.");
        country.put("Japan", "Tokyo");
        country.put("China", "Beijing");
        country.put("Australia", "Melb");
        
        country = country.entrySet()
        		.stream()
        		.sorted(Map.Entry.comparingByValue())
        		.collect(Collectors.toMap(
        				Map.Entry::getKey,
        				Map.Entry::getValue,
        				(oldValue,newValue) -> newValue,
        				LinkedHashMap::new
        				));
        System.out.println("sorted value-->"+country.toString());
        
        List<String> resultValues = country.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey().reversed())
                .map(x -> x.getValue())
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        
        String str="jhfg";
        List<String> resultValues1 = Arrays.stream(str.split("")).collect(Collectors.toList());
        System.out.println("resultValues1-->"+(resultValues1));
        
        String parens = "";
        Deque<Character> deque = new LinkedList<Character>();
		for(Character ch : parens.toCharArray()) {
			if(ch=='{' || ch=='[' || ch=='(') deque.offer(ch);
			else if (!deque.isEmpty() && ((ch=='}' && deque.peekLast()=='{') || (ch==']' && deque.peekLast()=='[') || 
					(ch==')' && deque.peekLast()=='('))) deque.removeLast();
		}
        
        country = country.entrySet()
        		.stream()
        		.sorted(Map.Entry.comparingByKey())
        		.collect(Collectors.toMap(
        				Map.Entry::getKey,
        				Map.Entry::getValue,
        				(oldKey,newKey) -> newKey,
        				LinkedHashMap::new
        				));
        System.out.println("sorted key-->"+country.toString());
        
        
        
	}
}
