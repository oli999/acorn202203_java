package test.main;

import test.mypac.Joinner;

public class MainClass07 {
	public static void main(String[] args) {
		Joinner j1=new Joinner() {
			@Override
			public String join(String one, String two) {
				return one+two;
			}
		};
		
		Joinner j2=(one, two)->{
			return one+two;
		};
		
		Joinner j3=(one, two)->one+two;
		
		String result1=j1.join("kim", "gura");
		String result2=j2.join("kim", "gura");
		String result3=j3.join("kim", "gura");
		
		//문자열은 내용이 같아도 참조값은 다를 수 있다(같을 수도 있다)
		boolean isEqual = result1 == result2;
		//문자열의 내용비교(내용이 같은지 비교) 할때는 String 객체의 메소드를 활용해야한다.
		boolean isEqual2 = result1.equals(result2);
		boolean isEqual3 = result1.equals("kimgura");
		boolean isEqual4 = "kimgura".equals(result1);
	}
}














