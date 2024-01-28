package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Order;

public class LastSurvivors {
	
	public static String lastSurvivors(String str) {
	    StringBuilder sb = new StringBuilder(str);
	    boolean mod;
	    
	    do {
	      mod = false;
	      for (int i = 0; i < sb.length(); i++) {
	        char ch = sb.charAt(i);
	        int idx = sb.indexOf("" + ch, i + 1);
	        if (idx > 0) {
	          sb.deleteCharAt(idx);
	          sb.setCharAt(i, ch == 'z' ? 'a' : (char)(ch + 1));
	          mod = true;
	        }
	      }
	    } while (mod);
	    
	    return sb.toString();
	  }
	
	
	public static String lastSurvivors1(String str) {
		if(str.equals("") || str.length()==0) return "";
		StringBuilder sb = new StringBuilder(str);
		for(int i=0;i<sb.length();i++) {
			for(int j=0; j<sb.length();j++) {
				if(i!=j && sb.charAt(i) == sb.charAt(j)) {
					if(sb.charAt(i)=='z') sb.replace(i, i+1, "a");
					else sb.replace(i, i+1, (char)(sb.charAt(i)+1)+"");
					sb.deleteCharAt(j);
					break;
				}
			}
		}
        return (sb.length()>1 && isRepeatChars(sb.toString())) ? lastSurvivors1(sb.toString()) : sb.toString();
     }
	
	public static boolean isRepeatChars(String str) {
	    for (int i = 0; i < str.length(); i++) {
	        for (int j = i + 1; j < str.length(); j++) {
	            if (str.charAt(i) == str.charAt(j)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	
    @Test
    public void ordinary() {
       assertEquals("ac", sort(LastSurvivors.lastSurvivors("abaa")), String.format("given: %s", "abaa"));
       assertEquals("c", sort(LastSurvivors.lastSurvivors("zzab")), String.format("given: %s", "zzab"));
       assertEquals("", sort(LastSurvivors.lastSurvivors("")), String.format("given: %s", ""));
    }
  
    @Test
    public void zeroLength() {
       assertEquals("", sort(LastSurvivors.lastSurvivors("")), String.format("given: %s", ""));
    }
  
    @Test
    public void newEdge() {
       String str ="xsdlafqpcmjytoikojsecamgdkehrqqgfknlhoudqygkbxftivfbpxhxtqgpkvsrfflpgrlhkbfnyftwkdebwfidmpauoteahyh";
       assertEquals("acdeghlmnqrvyz", sort(LastSurvivors.lastSurvivors(str)), String.format("given: %s", str));
    }
    
    @Test
    public void ordinary1() {
       assertEquals("ac", sort(LastSurvivors.lastSurvivors1("abaa")), String.format("given: %s", "abaa"));
       assertEquals("c", sort(LastSurvivors.lastSurvivors1("zzab")), String.format("given: %s", "zzab"));
       assertEquals("", sort(LastSurvivors.lastSurvivors1("")), String.format("given: %s", ""));
    }
  
    @Test
    public void zeroLength1() {
       assertEquals("", sort(LastSurvivors.lastSurvivors1("")), String.format("given: %s", ""));
    }
  
    @Test
    public void newEdge1() {
       String str ="xsdlafqpcmjytoikojsecamgdkehrqqgfknlhoudqygkbxftivfbpxhxtqgpkvsrfflpgrlhkbfnyftwkdebwfidmpauoteahyh";
       assertEquals("acdeghlmnqrvyz", sort(LastSurvivors.lastSurvivors1(str)), String.format("given: %s", str));
    }
  
    static private String sort(String s) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      return new String(chars);
    }
}
