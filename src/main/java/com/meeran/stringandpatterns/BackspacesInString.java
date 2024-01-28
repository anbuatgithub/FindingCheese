package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class BackspacesInString {
	public String cleanString(String s) {
	    // your code here
		StringBuilder alpha = new StringBuilder();
		int toRemove=0;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)=='#')
				toRemove++;
			else {
				if(toRemove>0)
					toRemove--;
				else alpha.append(s.charAt(i));
			}
		}
		
		return alpha.length()==0 ? "" : alpha.reverse().toString();
	  }
	
	@Test
    public void testCleanString() {
        final BackspacesInString bis = new BackspacesInString();
        assertEquals("l", bis.cleanString("e##l"));
        assertEquals("sa", bis.cleanString("####gfdsgf##hhs#dg####fjhsd###dbs########afns#######sdanfl##db#####s#a"));
        assertEquals("6+yqw8hfklsd-=-f", bis.cleanString("831####jns###s#cas/*####-5##s##6+yqw87e##hfklsd-=-28##fds##"));
        assertEquals("jf", bis.cleanString("abjd####jfk#"));
        assertEquals("ac", bis.cleanString("abc#d##c"));
        assertEquals("", bis.cleanString("abc####d##c#"));
    }
}
