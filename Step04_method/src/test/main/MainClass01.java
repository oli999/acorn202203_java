package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass01 {
	public static void main(String[] args) {
		//MyObject 클래스에 정의된 3개의 메소드를 차례로 호출하는 code 를 작성해 보세요.
		MyObject obj=new MyObject();
		obj.walk();
		int num=obj.getNumber();
		String greet=obj.getGreeting();
		Car car=obj.getCar();
		
		// .setNum()  .setName()  .useCar() 메소드 3개를 호출하는 code 를 작성해 보세요.
		obj.setNum(10);
		obj.setName("김구라");
		obj.useCar(new Car());
		
		// .listenMusic() 메소드를 호출하는 code 를 작성해 보세요.
		obj.listenMusic(new Radio(), new Speaker());
	}
}













