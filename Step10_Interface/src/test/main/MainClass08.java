package test.main;

import test.mypac.Calc;

public class MainClass08 {
	public static void main(String[] args) {
		//Calc 인터페이스를 람다식(한줄코딩) 으로 구현하기 
		Calc add=(a, b)->a+b;
		Calc sub=(a, b)->a-b;
		Calc multi=(a, b)->a*b;
		Calc divide=(a, b)->a/b;
		
		double result1=add.exec(10, 20);
		double result2=sub.exec(10, 20);
		double result3=multi.exec(10, 20);
		double result4=divide.exec(10, 20);
		
	}
}
