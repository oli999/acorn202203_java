package test.main;

import test.mypac.Rect;

/*
 *   Rect 라는 이름의 클래스를 만들고자 한다.
 *   
 *   해당 클래스로 객체를 생성하고
 *   
 *   사각형의 폭과(width), 높이(height) 를 필드에 대입하고
 *   
 *   showArea() 를 호출하면 사각형의 넓이가 콘솔창에 출력될수 있도록
 *   
 *   Rect 클래스를 설계해 보세요.
 */
public class MainClass05 {
	public static void main(String[] args) {
		Rect r=new Rect();
		r.width=10;
		r.height=20;
		r.showArea();
		//메소드가 리턴해주는 값을 변수에 담아보기
		int area=r.getArea();
	}
}













