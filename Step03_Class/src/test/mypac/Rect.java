package test.mypac;

public class Rect {
	//필드
	public int width;
	public int height;
	//면적을 콘솔에 출력하는 메소드
	public void showArea() {
		//면적 얻어내기
		int area=width*height;
		//콘솔에 출력하기
		System.out.println("면적:"+area);
	}
	//면적을 메소드를 호출한곳으로 리턴해주는 메소드
	public int getArea() {
		int area=width*height;
		return area;
	}
}
