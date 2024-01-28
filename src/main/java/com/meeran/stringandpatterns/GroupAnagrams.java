package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Set<Set<String>> group(List<String> words){
		Map<String, Set<String>> map = new HashMap<>();
		for(String str : words) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			
			String key = String.valueOf(chars);
			map.putIfAbsent(key, new HashSet<>());
			map.get(key).add(str);
		}
		return new HashSet<>(map.values());	
	}
	
	@Test
	public void testGroup() {
		String [] str = {"eat","tea","tan","ate","nat","bat"};
		List<String> words = Arrays.asList(str);
		Set<Set<String>> output = new HashSet<Set<String>>();
		Set<String> arr1 = new HashSet<String>();
		arr1.add("bat");
		output.add(arr1);
        Set<String> arr2 = new HashSet<String>();
        arr2.add("nat");
        arr2.add("tan");
        output.add(arr2);
        Set<String> arr3 = new HashSet<String>();
        arr3.add("ate");
        arr3.add("eat");
        arr3.add("tea");
        output.add(arr3);
        
        assertEquals(output, group(words));
	}

}
