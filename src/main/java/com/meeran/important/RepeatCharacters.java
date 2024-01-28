package com.meeran.important;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//1.	Implement a method which performs basic string compression by counting sequences of 
// repeating characters. Given "AABBBCCCD" it should return "A2B3C3D1".

public class RepeatCharacters {
	public static void main(String Args[]) {
		String str = "AABBBCCCDA";
		getCompressedString(str);
		System.out.println("Compressed String for the Str "+str+ " is "+getCompressedString(str));
		System.out.println("Compressed String in Order for the Str "+str+ " is "+getCompressedStringinOrder(str));
		str = "AAAAAAAA";
		System.out.println("Compressed String in Order for the Str "+str+ " is "+getCompressedStringinOrder(str));
		str = "A";
		System.out.println("Compressed String in Order for the Str "+str+ " is "+getCompressedStringinOrder(str));
		str = "AABBCCAA";
		System.out.println("Compressed String in Order for the Str "+str+ " is "+getCompressedStringinOrder(str));

	}
	
	static String getCompressedStringinOrder(String str) {
		if(str.length()==1) return str.charAt(0)+"1";
		StringBuilder output = new StringBuilder();
		Character current = str.charAt(0);
		int count=1;
		for(int i=1;i<str.length();i++) {
			if(current == str.charAt(i)) {
				count++;
			}else {
				output.append(current+""+count);
				count=1;
				current=str.charAt(i);
			}
			if(i==str.length()-1) output.append(current+""+count);
		}
		return output.toString();
	}
	
	static String getCompressedString1(String str) {
		Map<Character,Integer> compressedMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++) {
			if(compressedMap.containsKey(str.charAt(i))) {
				int index = compressedMap.get(str.charAt(i))+1;
				compressedMap.put(str.charAt(i), index);
			}else {
				compressedMap.put(str.charAt(i), 1);
			}
		}
		StringBuilder resultStr = new StringBuilder();
		for(Map.Entry<Character, Integer> entry: compressedMap.entrySet()) {
			resultStr.append(entry.getKey()+""+entry.getValue());
		}
		return resultStr.toString();
	}
	
	static String getCompressedStringinOrder1(String str) {
		StringBuilder resultStr = new StringBuilder();
		
		if(str.length()==1) {
			return str.charAt(0)+""+1;
		}
		
		char previousChar = str.charAt(0);
		int count =1;
		
		for(int i=1; i<str.length(); i++) {
			
			if(previousChar == str.charAt(i)) {
				count++;
			}else {
				resultStr.append(previousChar+""+count);
				previousChar = str.charAt(i);
				count=1;
			}
			if(i==str.length()-1) {
				resultStr.append(previousChar+""+count);
			}
		}
		return resultStr.toString();
	}
	
	static String getCompressedString(String str) {
		Map<Character,Integer> compressedMap = new HashMap<Character,Integer>();
		for(Character ch : str.toCharArray()) {
			//compressedMap.put(ch, compressedMap.getOrDefault(ch, 0)+1);
			compressedMap.merge(ch, 1, (a,b) -> a+b);
		}
		
		 return compressedMap.entrySet().stream().map(e->e.getKey()+""+e.getValue()).collect(Collectors.joining());
	}
	
	static String getCompressedString2(String str) {
		StringBuilder result = new StringBuilder();
		if(str.length()==1) {
			return str.charAt(0)+""+1;
		}
		Character prev = str.charAt(0);
		int count=1;
		for(int i=1; i<str.length(); i++) {
			if(prev==str.charAt(i)) {
				count++;
			}else {
				result.append(prev+""+count);
				count=1;
				prev=str.charAt(i);
			}
			if(i==str.length()-1) {
				result.append(prev+""+count);
			}
		}
		return result.toString();
	}
	
}
