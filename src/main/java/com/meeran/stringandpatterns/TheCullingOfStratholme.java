package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;

public class TheCullingOfStratholme {
	public static String purify(String s) {
		return s.replaceAll("\\w?[iI]+\\w?", "").replaceAll("\\s+", " ").trim();
	}
	public static String purify1(String s) {
        //Write your code here
		if(s==null || s.length()==0) return "";
		String output="";
		int i=0;
		char last = 0;
		if(s.charAt(0)=='i' || s.charAt(0)=='I') i=2;
		else if(s.charAt(i)!=' '){
			if(s.length()>1 && (s.charAt(1)=='i' || s.charAt(1)=='I')) i=3;
			else {
				last = s.charAt(i);
				output+=s.charAt(i)+"";
				i++;
			}
		}
		for(; i+1<s.length();i++) {
			
			if(s.charAt(i)==' ' || (s.charAt(i)!='i' && s.charAt(i)!='I' && s.charAt(i+1)!='i' && s.charAt(i+1)!='I' && s.charAt(i-1)!='i' && s.charAt(i-1)!='I')) {
				if(s.charAt(i)!=' ') {
					last = s.charAt(i);
					output+=s.charAt(i)+"";
				}else if (last!=' ' && output.length()>0) {
					last = s.charAt(i);
					output+=s.charAt(i)+"";
				}
			}
		}
		if(i<s.length() && s.charAt(i)!='i' && s.charAt(i)!='I'
				&& i-1>0 && s.charAt(i-1)!='i' && s.charAt(i-1)!='I') output+=s.charAt(i)+"";
		return output.trim();
    }
	
	@Test
    public void testChili() {
      String input = "chili";
      System.out.println("input: "+input);      
      assertEquals("c", TheCullingOfStratholme.purify(input));
    }
  @Test
    public void testNumbersWithExtraSpaces() {
      String input = "1i2i 33 i4i5 55ii5";
      System.out.println("input: "+input);      
      assertEquals("33 5", TheCullingOfStratholme.purify(input));
    }
  @Test
    public void testPineapplePizza() {
      String input = "        Pineapple pizza is delicious";
      System.out.println("input: "+input);      
      assertEquals("eapple za deus", TheCullingOfStratholme.purify(input));
    }
    void testSomething() {
        // assertEquals("expected", "actual");
    }
  private final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890      ABCDEFGHIJKLMNOPQRSTUVWXYZ      iiiiiiiiiIIIIIII";
    private final Random rand = new Random();
    private char randomChar() {
       return alphabet.charAt(rand.nextInt(alphabet.length()));
    } 
  @Test
  public void randomTests() {
        for (int trial = 1; trial <= 100; trial++) {
            String[] expected = new String[rand.nextInt(21)];
            for (int i = 0; i < expected.length; i++)
                expected[i] = "" + randomChar() + randomChar();
            if ( 0 < expected.length && rand.nextBoolean() )
                expected[expected.length-1] = randomChar() + "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expected.length; i++)
                sb.append(expected[i]);
            assertEquals(solution(sb.toString()), TheCullingOfStratholme.purify(sb.toString()));
        }
    
    }
    public static String solution(String s) {
        return s.replaceAll("(?i)\\w?i+\\w?", "").replaceAll("^ +| +(?= |$)", "");
    }
    
}
