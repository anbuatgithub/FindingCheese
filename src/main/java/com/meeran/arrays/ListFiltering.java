package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListFiltering {
	public static List<Object> filterList(final List<Object> list) {
	    // Return the List with the Strings filtered out
		List<Object> output = new ArrayList<Object>() ;
	    for(int i=0; i<list.size();i++) {
	    	if(list.get(i) instanceof Number) output.add(list.get(i));
	    }
	    return output;
	}
	
	 @Test
	  public void examples() {
	    assertEquals(List.of(1, 2), filterList(List.of(1, 2, "a", "b")), "For input: [1, 2, \"a\", \"b\"]");
	    assertEquals(List.of(1, 0, 15), filterList(List.of(1, "a", "b", 0, 15)), "For input: [1, \"a\", \"b\", 0, 15]");
	    assertEquals(List.of(1, 2, 123), filterList(List.of(1, 2, "aasf", "1", "123", 123)), "For input: [1, 2, \"aasf\", \"1\", \"123\", 123]");    
	  } 
}
