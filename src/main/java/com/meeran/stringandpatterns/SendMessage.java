package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SendMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static  String str[]
            = { "2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999" };
	
	public static String sendMessage(String message)
    {
        String output = "";
        String previous = "";
        boolean previouscase=false;
        boolean ishashed = false;
        int n = message.length();
        for (int i = 0; i < n; i++) {
        	if(Character.isUpperCase(message.charAt(i)) && !previouscase) {
        		output = output + "#";
        		previouscase = true;
        		ishashed=true;
        	}else if(Character.isLowerCase(message.charAt(i)) && previouscase) {
        		output = output + "#";
        		previouscase = false;
        		ishashed=true;
        	}
            if (message.charAt(i) == ' ') {
                output = output + "0";
                previous=" ";
            }
            else if (message.charAt(i)=='!') {
            	output = output + "1111";
            	previous = "1";
            }else if (message.charAt(i)=='-') {
            output = output + "**";
            	previous = "*";
            } else if(Character.isDigit(message.charAt(i))) {
            	
            	if(!previous.isBlank() && (previous.contains(Character.toString(message.charAt(i))) )) {
            		output = output + " "+Character.toString(message.charAt(i))+"-";
            	}else {
            		output = output + Character.toString(message.charAt(i))+"-";
            	}
            	previous = Character.toString(message.charAt(i));
            }
            else {
                int position = Character.isUpperCase(message.charAt(i)) ? message.charAt(i) - 'A' :  message.charAt(i) - 'a';
                if(!ishashed && !previous.isBlank() && (previous.contains(str[position]) || str[position].contains(previous))) output = output + " ";
                output = output + str[position];
                previous = str[position];
                ishashed=false;
            }
        }
        return output;
    }
	
	
	  private static void testing_send(String input, String expected) {
		    String actual = sendMessage(input);
		    assertEquals(expected, actual);
		  }

		  @Test
		   public void sampleTests() {
		    testing_send("hey", "4433999");
  
			
			  testing_send("one two three", "666 6633089666084477733 33");
			  testing_send("Hello World!", "#44#33555 5556660#9#66677755531111");
			  testing_send("Def Con 1!", "#3#33 3330#222#666 6601-1111");
			  testing_send("A-z", "#2**#9999"); 
			  testing_send("1984", "1-9-8-4-");
			  testing_send("Big thanks for checking out my kata",
			  "#22#444 4084426655777703336667770222443322255444664066688 806999055282");
			 
		  }

}
