package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class BestTravel {

	public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        // your code
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		Integer[] distances = ls.stream().toArray(Integer[]::new);
		
		getSubList(distances, k, 0, new int[k], set);
		
		System.out.println("Set--->"+set);
		if(set.isEmpty()) return null;
		int bestSum=0;
		
		for (List<Integer> subLs : set) {
	        Integer sumOfDistance = subLs.stream()
	        		  .reduce(0, (a, b) -> a + b);
	        System.out.println(sumOfDistance);
	        if(sumOfDistance<=t && bestSum<sumOfDistance) bestSum=sumOfDistance;
	    }
			    
		return bestSum==0? null : bestSum;
    }
	
	private static void getSubList(Integer[] distances, int len, int index, int[] subList, Set<ArrayList<Integer>> set){       
        if (len == 0){
        	ArrayList<Integer> list = IntStream.of(subList).boxed().collect(Collectors.toCollection(ArrayList::new));
        	set.add(list);
            return;
        }       
        for (int i = index; i <= distances.length-len; i++){
        	subList[subList.length - len] = distances[i];
            getSubList(distances, len-1, i+1, subList, set);           
        }
    } 
	
	private static void findSubList(int k, List<Integer> ls, Set<ArrayList<Integer>> set) {
		ArrayList<Integer> tempLs = (ArrayList<Integer>) ((ArrayList<Integer>) ls).clone();
	    for (int i = 0; i < ls.size(); i++) {
	    	tempLs.remove(i);
	        if (tempLs.size() == k) {
	            for (int j = 0; j < ls.size(); j++) {
	                ArrayList<Integer> tempLs2 = (ArrayList<Integer>) ((ArrayList<Integer>) ls).clone();
	                tempLs2.remove(j);
	                set.add(tempLs2);
	            }
	        } else {
	        	findSubList(k,tempLs, set);
	        }
	        tempLs = (ArrayList<Integer>) ((ArrayList<Integer>) ls).clone();
	    }  
	}
	
	@Test
    public void BasicTests1() {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = BestTravel.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = BestTravel.chooseBestSum(163, 3, ts);
        assertEquals(null, m);      
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = BestTravel.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }
}
