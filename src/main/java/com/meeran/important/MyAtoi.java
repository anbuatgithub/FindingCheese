package com.meeran.important;

public class MyAtoi {
	public static void main(String Args[]) {
		String str="-123";
		System.out.println("MyAtoi for the String "+str+" is "+myAtoi(str));
		str="-123fgg";
		System.out.println("MyAtoi for the String "+str+" is "+myAtoi(str));
		str="42";
		System.out.println("MyAtoi for the String "+str+" is "+myAtoi(str));
		str="+123";
		System.out.println("MyAtoi for the String "+str+" is "+myAtoi(str));
		str="dfdsg";
		System.out.println("MyAtoi for the String "+str+" is "+myAtoi(str));
		str="8hgy8998";
		System.out.println("MyAtoi for the String "+str+" is "+myAtoi(str));
	}
	static int myAtoi(String str) {
		int sign=1, index=0, ans=0;
		if(str.charAt(0)=='+') index++;
		if(str.charAt(0)=='-') {
			index++; 
			sign=-1;
		}
		for(;index<str.length();index++) {
			if(Character.isDigit(str.charAt(index))) ans=(ans*10) + str.charAt(index)-'0';
			else break;
		}
		return ans*sign;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int myAtoi1(String str) {
		int sign=1, result=0, index=0;
		if(str.charAt(0)=='+')index++;
		if(str.charAt(0)=='-') {
			index++;
			sign=-1;
		}
		for(;index<str.length();index++) {
			if(Character.isDigit(str.charAt(index))) {
				result = (result*10) + str.charAt(index) -'0';
			}else break;
		}
		return result * sign;
	}
}
