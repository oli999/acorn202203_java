package test.mypac;

public class SmartPhone extends HandPhone{
	//생성자
	public SmartPhone() {
		System.out.println("SmartPhone 생성자 호출됨");
	}
	
	//메소드
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	//부모의 메소드 재정의(Override)
	@Override
	public void takePicture() {
		System.out.println("100 만 화소의 고화질 사진을 찍어요!");
	}
}
