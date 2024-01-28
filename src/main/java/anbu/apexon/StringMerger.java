package anbu.apexon;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringMerger {
	
	public static boolean isMerge2(String s, String part1, String part2) {
	      return s.isEmpty() || part1.isEmpty() || part2.isEmpty() ? s.equals(part1 + part2) :
	        s.charAt(0) == part1.charAt(0) && isMerge(s.substring(1), part1.substring(1), part2) ||
	        s.charAt(0) == part2.charAt(0) && isMerge(s.substring(1), part1, part2.substring(1));
	    }


	public static boolean isMerge(String s, String part1, String part2) {

		char[] firstArray = s.toCharArray();
		Arrays.sort(firstArray);
		String firstString = String.valueOf(firstArray);

		char[] secondArray = new StringBuilder(part1).append(part2).toString().toCharArray();
		Arrays.sort(secondArray);
		String secondString = String.valueOf(secondArray);

		return firstString.equals(secondString);

	}




	public static boolean isMerge1(String s, String part1, String part2) {
		System.out.println("s-->"+s+" part1-->"+part1+" part2-->"+part2);
		if(s.length()!=part1.length() + part2.length()) return false;
		StringBuilder sSb = new StringBuilder(s);
		StringBuilder part1Sb = new StringBuilder(part1);
		StringBuilder part2Sb = new StringBuilder(part2);
		while(sSb.length()>0) {
			int part1Length=0,part2Length=0;
			for(int i=0; i<part1Sb.length(); i++) {
				if(sSb.charAt(i) == part1Sb.charAt(i)) part1Length++;
				else break;
			}
			for(int i=0; i<part2Sb.length(); i++) {
				if(sSb.charAt(i) == part2Sb.charAt(i)) part2Length++;
				else break;
			}
			if(part1Length==0 && part2Length==0) return false;
			if(part1Length <= part2Length) {
				part2Sb.delete(0, 1);
				sSb.delete(0, 1);
			}else {
				part1Sb.delete(0, 1);
				sSb.delete(0, 1);
			}
		}
		return sSb.length()== 0 && part1Sb.length()==0 && part2Sb.length() ==0 ? true : false;
	}
	
	private Random random = new Random();


	  @Test
	  public void normalHappyFlow() {
	    assertTrue("codewars can be created from code and wars", StringMerger.isMerge("codewars", "code", "wars"));
	    assertTrue("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "cdwr", "oeas"));
	    assertTrue("Making progress", StringMerger.isMerge("Making progress", "Mak pross", "inggre"));
	  }
	  
	  @Test
	  public void alwaysPass() {
	    assertTrue("this can't fail", true);
	  }
	  
	  @Test
	  public void normalSadFlow() {
	    assertFalse("codewars is not code + code", StringMerger.isMerge("codewars", "code", "code"));
	    assertFalse("More progress", StringMerger.isMerge("More progress", "More ess", "pro"));
	  }
	  
	  @Test
	  public void canHandleEmptyPart() {
	    assertTrue("codewars are codewars", StringMerger.isMerge("codewars", "codewars", ""));
	    assertTrue("codewars are codewars", StringMerger.isMerge("codewars", "", "codewars"));
	  }
	  
	  @Test
	  public void canHandleTooFewChars() {
	    assertFalse("codewars is not codewar", StringMerger.isMerge("codewars", "code", "war"));
	    assertFalse("codewars is not co", StringMerger.isMerge("codewars", "c", "o"));
	  }
	  
	  @Test
	  public void canHandleExtraChars() {
	    assertFalse("codewars is not codewarss", StringMerger.isMerge("codewars", "code", "warss"));
	  }
	  
	  @Test
	  public void canHandleCharactersInWrongOrder() {
	    assertFalse("codewars can't be created from code and wasr", StringMerger.isMerge2("codewars", "code", "wasr"));
	    assertFalse("codewars can't be created from cwdr and oeas", StringMerger.isMerge("codewars", "cwdr", "oeas"));
	  }
	  
	  @Test
	  public void canHandleEmptyStrings() {
	    assertFalse("empty result string", StringMerger.isMerge("", "code", "wars"));
	    assertFalse("empty part one", StringMerger.isMerge("codewars", "", "code"));
	    assertFalse("empty part two", StringMerger.isMerge("codewars", "code", ""));
	    assertFalse("empty parts", StringMerger.isMerge("codewars", "", ""));
	    assertTrue("all empty", StringMerger.isMerge("", "", ""));
	  }
	  
	  @Test
	  public void canHandleBananas() {
	    assertTrue("Going bananas!", StringMerger.isMerge("Bananas from Bahamas", "Bahas", "Bananas from am"));
	  }
	  
	  @Test
	  public void someRandomCases() {
	    for(int i = 0; i < 20; i++) {
	      String[] parts = splitString("Can we merge it? Yes, we can!");
	      if (random.nextBoolean())
	        assertTrue("'Can we merge it? Yes, we can!' is a merge of '" +
	                 parts[0] + "' and '" + parts[1] + "'",
	                 StringMerger.isMerge("Can we merge it? Yes, we can!", parts[0], parts[1]));
	      else
	        assertFalse("'Can we merge it? No, we can't!' is a not merge of '" +
	                 parts[0] + "' and '" + parts[1] + "'",
	                 StringMerger.isMerge("Can we merge it? No, we can't!", parts[0], parts[1]));
	    }
	  }
	  
	  @Test
	  public void someMoreRandomCases() {
	    for(int i = 0; i < 20; i++) {
	      String s = randomString();
	      String[] parts = splitString(s);
	      assertTrue("'" + s + "' is a merge of '" +
	                 parts[0] + "' and '" + parts[1] + "'",
	                 StringMerger.isMerge(s, parts[0], parts[1]));
	    }
	  }
	  
	  @Test
	  public void evenMoreRandomCases() {
	    for(int i = 0; i < 20; i++) {
	      String s = randomString();
	      if (random.nextBoolean() || s.charAt(0) == s.charAt(s.length()-1)) {
	        String[] parts = splitString(s);
	        assertTrue("'" + s + "' is a merge of '" +
	                   parts[0] + "' and '" + parts[1] + "'",
	                   StringMerger.isMerge(s, parts[0], parts[1]));
	      } else {
	        String[] parts = splitString(s);
	        s = s.charAt(s.length()-1) + s.substring(1, s.length()-1) + s.charAt(0);
	        assertFalse("'" + s + "' is not a merge of '" +
	                   parts[0] + "' and '" + parts[1] + "'",
	                   StringMerger.isMerge(s, parts[0], parts[1]));
	      }
	    }
	  }
	  
	  @Test
	  public void someTrickyRandomCases() {
	    for(int i = 0; i < 20; i++) {
	      String[] chunks = {randomString(), randomString(),
	                         randomString(), randomString()};
	      String s = chunks[0] + chunks[1] + chunks[0] + chunks[2] + chunks[3];
	      String p1 = chunks[0] + chunks[2];
	      String p2 = chunks[0] + chunks[1] + chunks[3];
	      assertTrue("'" + s + "' is a merge of '" +
	                 p1 + "' and '" + p2 + "'",
	                 StringMerger.isMerge(s, p1, p2));
	    }
	  }
	    
	  private String randomString() {
	    String s = "";
	    int length = random.nextInt(20) + 10;
	    for(int i = 0; i < length; i++) {
	      char ch = (char) (random.nextInt(123-32) + 32);
	      s += ch;
	    }
	    return s;
	  }
	  
	  private String[] splitString(String s) {
	    String s1 = "";
	    String s2 = "";
	    for(char ch: s.toCharArray()) {
	      if (random.nextBoolean())
	        s1 += ch;
	      else
	        s2 += ch;
	    }
	    return new String[] {s1, s2};
	  }
}
