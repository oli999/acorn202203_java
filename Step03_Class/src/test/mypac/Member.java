package test.mypac;

public class Member {
	//필드
	public int num;
	public String name;
	public String addr;
	
	//메소드
	public void showInfo() {
		//필드에 저장된 내용을 아래와 같은 형식으로 콘솔창에 출력하는 코드를 작성해 보세요.
		//번호:1, 이름:김구라, 주소:노량진
		System.out.println("번호:"+this.num+", 이름:"+this.name+", 주소:"+this.addr);
	}
}
