package test.main;

import test.mypac.Drill;
import test.mypac.MultiObject;
import test.mypac.Remocon;

public class MainClass05 {
	public static void main(String[] args) {
		MultiObject m1=new MultiObject();
		//여러개의 인터페이스를 구현한 객체를 필요한 type 으로 받아서 사용하기 
		Remocon m2=new MultiObject();
		Drill m3=new MultiObject();
	
	}
}
