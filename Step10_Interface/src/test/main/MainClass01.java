package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		//Remocon 인터페이스를 구현(implements) 한 클래스를 이용해서 Remocon type 의 참조값 얻어내기 
		Remocon r1=new MyRemocon();
		r1.up();
		r1.down();
		
		//인터페이스의 필드 참조 ( static final )
		String result=Remocon.COMPANY;
	}
	
}
