package test.main;

public class MainClass12 {
	public static void main(String[] args) {
		//특정 조건에서 종료되는 반복문
		int count=0;
		//정확한 반복 횟수를 알수 없을때 사용할수 있는 반복문 
		while(count<1000) {
			count++;
			System.out.println("반복 횟수:"+count);
		}
	}
}
