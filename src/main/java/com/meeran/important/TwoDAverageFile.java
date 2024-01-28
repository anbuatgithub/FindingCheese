package com.meeran.important;

import java.util.*;
public class TwoDAverageFile {
	public static void main(String Args[]) {
		String[] file = {"Meeran","30","40","70",
				"Tony","60","70","80",
				"Minha", "99","98","90",
				"Muiz","90","98","99"};
		
		List<String> bestGrade = bestAverage1(file);
		
		System.out.print("Best Student(s): ");
		for(int i=0; i<bestGrade.size()-1; i++) {
			System.out.print( bestGrade.get(i)+", ");
		}
		System.out.println(" and his Average is: "+bestGrade.get(bestGrade.size()-1));
		
		
		String[][] fileArr = {{"Meeran","30","40","70"},
				{"Tony","60","70","80"},
				{"Minha", "99","98","90"},
				{"Muiz","90","98","99"}};
		
		System.out.println("findAverage-->"+findAverage(fileArr).toString());
		
	}
	static List<String> findAverage(String[][] fileArr){
		double bestAverage=0;
		List<String> list = new ArrayList<String>();
		for(int i=0; i<fileArr.length;i++) {
			String name = fileArr[i][0];
			int sum=0;
			for(int j=1; j<fileArr[i].length;j++) {
				sum+=Integer.parseInt(fileArr[i][j]);
			}
			double average = sum/fileArr[i].length-1;
			if(average>bestAverage) {
				list.clear();
				list.add(name);
				bestAverage=average;
			}else if(average == bestAverage) {
				list.add(name);
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static List<String> findAverage1(String[][] fileArr){
		double average = 0.0;
		double bestAverage = 0.0;
		List<String> bestStudent = new ArrayList<String>();
		for(int i=0; i< fileArr.length; i++) {
			String name="";
			int sum=0;
			int j=0;
			for(; j<fileArr[i].length;j++) {
				if(j==0) name = fileArr[i][0];
				else sum += Integer.parseInt(fileArr[i][j]);
			}
			average = sum/j;
			if(average>bestAverage) {
				bestAverage=average;
				bestStudent.clear();
				bestStudent.add(name);
			} else if(average==bestAverage)bestStudent.add(name);
		}
		return bestStudent;
	}
	
	static List<String> bestAverage(String[] file) {
		double average , bestAverage =0;
		String bestStudent="";
		List<String> bestGrade = new ArrayList<String>();
		for(int i=0; i<file.length; i+=4) {
			average = (Integer.parseInt(file[i+1])+Integer.parseInt(file[i+2])+
					Integer.parseInt(file[i+3]))/3;
			if(average>bestAverage) {
				bestAverage=average;
				bestStudent=file[i];
				bestGrade.clear();
				bestGrade.add(bestStudent);
			}else if(average==bestAverage) {
				bestStudent=file[i];
				bestGrade.add(bestStudent);
			}
		}
		bestGrade.add(Double.toString(bestAverage));
		return bestGrade;
	}
	
	
	
	static List<String> bestAverage1(String[] file){
		double average,bestAverage=0;
		List<String> bestStudent = new ArrayList<String>();
		for(int i=0; i<file.length; i+=4) {
			average= (Integer.parseInt(file[i+1])+Integer.parseInt(file[i+2])
			+Integer.parseInt(file[i+3]))/3;
			
			if(average>bestAverage) {
				bestAverage = average;
				bestStudent.clear();
				bestStudent.add(file[i]);
			}else if(average == bestAverage){
				bestStudent.add(file[i]);
			}
		}
		bestStudent.add(Double.toString(bestAverage));
		
		return bestStudent;
	}
}
