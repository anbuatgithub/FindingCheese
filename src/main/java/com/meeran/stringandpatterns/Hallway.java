package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Hallway {
	public static int contact1(String hallway) {
		Matcher matcher = Pattern.compile("(\\>)(\\-*)(\\<)").matcher(hallway);
		int count =0;
		int result=Integer.MAX_VALUE;
		while ( matcher.find() ) {
		    count = (int) matcher.group(0).chars().filter(ch -> ch == '-').count();
		    if(result>count) result=count;
		    if(result==1 || count==0) return 1;
		}
		return result==Integer.MAX_VALUE ? -1 : (result==2 ? result:(result/2)+1);
	}
	
	public static int contact(String hallway) {
	    return Pattern.compile(">-*<").matcher(hallway).results().mapToInt(r -> r.group().length() / 2).min().orElse(-1);
	  }
	
	@Test
    public void testContact() {
		assertEquals(3, Hallway.contact("----------<------>--------------<--------<->------------------>---->>--------------------->->->---------------------->----<----->---------------------->-----------------------<--------->-----------"));
        assertEquals(1, Hallway.contact("---><----"));
        assertEquals(1, Hallway.contact("--->-<------->----<-"));
        assertEquals(-1, Hallway.contact("----<----->----"));
        assertEquals(2, Hallway.contact(">-----<-->--<-----")); 
        assertEquals(3, Hallway.contact(">>-----<<")); 
        assertEquals(5, Hallway.contact(">---------------<--------------------------<-------->---------<------->----------<----<---->>----------<------->>>---------------<<------>"));
    } 
}
