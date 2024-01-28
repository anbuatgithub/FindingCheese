package com.meeran.gs;

public class StudentGrade {
	public static void main(String Args[]) {
		int english = 8;
		int maths = 40;
		int computer = 75;
		int science = 88;
		int social = 66;
		
		if(english <40 || maths<40 || computer <40 || science <40 || social<40) {
			System.out.println("Fail");
		}else {
			double average = (english+maths+computer+science+social)/5;
			
			if(average >=90) {
				System.out.println("Grade A");
			}else if(average >=70) {
				System.out.println("Grade B");
			}else if(average >=50) {
				System.out.println("Grade C");
			}else if(average >=40) {
				System.out.println("Grade D");
			}
		}
	}
}
