package com.meeran.important;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MostIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String output=getMostFrequentIp(new String[]{"10.0.0.1 - GET 2020-08-24", 
        		"10.0.0.1 - GET 2020-08-24",
        		"10.0.0.2 - GET 2020-08-20", 
        		"10.0.0.3 - GET 2020-08-24",
        		"10.0.0.3 - GET 2020-08-24",
        		"10.0.0.3 - GET 2020-08-24",
        		"10.0.0.4 - GET 2020-08-24",});
        System.out.println("Most Frequent IP is: "+output);
	}
	
	public static String getMostFrequentIp(String[] logs){
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String str : logs) {
			String ip = str.split(" ")[0];
			map.merge(ip, 1, (a,b)->a+b);
		}
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.findFirst().get().getKey();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static String getMostFrequentIp1(String[] logs){
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 for(String str : logs) {
			 String[] temp = str.split(" ");
			 map.put(temp[0], map.getOrDefault(temp[0], 0)+1);
		 }
		 return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				 .findFirst().get().getKey();
	 }
}
