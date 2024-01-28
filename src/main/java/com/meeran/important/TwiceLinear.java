package com.meeran.important;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 2x+1
// 3x+1
public class TwiceLinear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Result - "+ dblLinear(10)+"- 22");
        System.out.println("Result - "+ dblLinear(20)+"- 57");
        System.out.println("Result - "+ dblLinear(30)+"- 91");
        System.out.println("Result - "+ dblLinear(50)+"- 175");
	}
	public static int dblLinear (int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for(int i=0; i<n;i++) {
			int x= 2 * list.get(i)+1;
			int y = 3 * list.get(i)+1;
			if(!list.contains(x))list.add(x);
			if(!list.contains(y))list.add(y);
		}
		Collections.sort(list);
		return list.get(n);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int dblLinear1 (int n) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		for(int i=0; i<=n;i++) {
			int x = 2*list.get(i)+1;
			int y = 3*list.get(i)+1;
			list.add(x);
			list.add(y);
		}
		Collections.sort(list);
		list=list.stream().distinct().collect(Collectors.toList());
		return list.get(n);
	}
}
