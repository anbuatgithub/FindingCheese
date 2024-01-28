package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class ApacheLogPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	String findTopIpaddress(String[] lines){
		Map<String, Integer> map = new TreeMap<String,Integer>();
		String result="";
		for(String str : lines) {
			String ip = str.split(" ")[0];
			map.merge(ip, 1, (a,b)-> (a+b));
		}
		int max=Integer.MIN_VALUE;
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			if(max<entry.getValue()) {
				max = entry.getValue();
				result=entry.getKey();
			}else if(max==entry.getValue()) {
				result+=","+entry.getKey();
			}
		}
		return result;
	}

	@Test
	public void testFindTopIpaddress() {
		String lines[] = new String[]{
				"10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
				"10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
		String Output = "10.0.0.1";
		assertEquals(Output, findTopIpaddress(lines));
		String lines2[] = new String[]{
				"10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
				"10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
				"10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};
		Output = "10.0.0.1,10.0.0.2";
		assertEquals(Output, findTopIpaddress(lines2));
	}
}
