package test.auto;

public class CampingCar extends Car{

	public CampingCar(Engine engine) {
		// super() 는 부모클래스의 생성자를 호출하는 것을 의미한다. 
		super(engine);
		
	}
	
	//메소드
	public void sleepInCar() {
		System.out.println("차에서 잠을 자요!");
	}
}
