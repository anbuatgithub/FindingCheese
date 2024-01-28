package com.meeran.important;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MostFrequentWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = top3(" khgk' khgk khg'k ' ' ' word wOrd WORd WORLD WORD a a a b ab sbc abc sbc");

		for (String str : list1) {
			System.out.print(str + " ");
		}
		
	}
	
	public static List<String> top3(String s) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9']*");
		Matcher matcher = pattern.matcher(s);
		Map<String,Integer> map = new HashMap<String,Integer>();
		while(matcher.find()) {
			String str = matcher.group().toLowerCase();
			map.merge(str, 1, (a,b)->a+b);
		}
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static List<String> top31(String s) {
		// Your code here

		Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9']*");
		Matcher matcher = pattern.matcher(s);
		Map<String,Integer> map = new HashMap<String,Integer>();
		while(matcher.find()) {
			String str= matcher.group().toLowerCase();
			map.put(str, map.getOrDefault(str,1)+1);
		}
		return map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(3)
				.map(Map.Entry :: getKey)
				.collect(Collectors.toList());

	}

}
