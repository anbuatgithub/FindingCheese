package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DistBetweenStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double shortestDistance(String document, String word1, String word2) {
		int wordCount=0;
		double word1Count =0, word2Count=0;
		double shortestDistance=Double.MAX_VALUE;
		for(String word : document.split(" ")) {
			if(word1.equalsIgnoreCase(word))word1Count = wordCount + (word.length()/2d);
			else if(word2.equalsIgnoreCase(word))word2Count = wordCount + (word.length()/2d);
			
			if(word1Count>0 && word2Count>0) shortestDistance = Math.min(shortestDistance, Math.abs(word2Count-word1Count));
			
			wordCount += word.length()+1;
		}
		return shortestDistance;
	}
	
	@Test
	public void testShortestDistance() {
		String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
		assertEquals(2.5, shortestDistance( document, "is", "a" ));
	}
	

}
