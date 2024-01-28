package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.Stack;

import org.junit.Test;

public class SimpleReversedParenthesis {
	public static int simpleReversedParenthesis(String s){
        //..
		if(s.length()%2!=0) return -1;
		int count=0;
		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray()) {
			if(ch=='(') stack.add(ch);
			else {
				if(!stack.isEmpty()) stack.pop();
				else {
					count++;
					stack.add(ch);
				}
			}
		}
		return stack.size() %2 !=0 ? -1 : count+stack.size()/2;
    }
	
	@Test
    public void basicTests(){     
        assertEquals(2,simpleReversedParenthesis(")()("));
        assertEquals(1,simpleReversedParenthesis("((()"));
        assertEquals(-1,simpleReversedParenthesis("((("));
        assertEquals(3,simpleReversedParenthesis("())((("));
        assertEquals(4,simpleReversedParenthesis("())()))))()()("));     
    }
	
	@Test
    public void randomTests(){ 
        for(int i=0;i<100;i++){
            String [] arr = rand3();
            int exp1 = jh09(arr[0]);
            assertEquals(exp1,simpleReversedParenthesis(arr[0]));
            int exp2 = jh09(arr[1]);
            assertEquals(exp2,simpleReversedParenthesis(arr[1]));
        }
    }
	
	private static Random random = new Random();    
    
    private static int jh09(String s){
        if (s.length() % 2 != 0) return -1;
        int c = 0, k = 0;
        for(char ch : s.toCharArray()) {
            if (ch == '(')
                k++;
            else if (k > 0)
                k--;
            else{
                k++; c++;
            }                
        }
        return c + k / 2;
    } 
  
    public static String [] rand3(){
        int len = random(2,15), i = 0;
        String braces = "()", small = "", large = "";
        while (i < len){
            int brace = random(0,2);
            small += braces.charAt(brace);
            i++;            
        }
        len = random(2,1000);
        i = 0;
        while (i < len){
            int brace = random(0,2);
            large += braces.charAt(brace);
            i++;            
        }
        return new String[] {small, large};
    }
    
    private static int random(int l, int u){
        return random.nextInt(u-l)+l;
    }    
}
