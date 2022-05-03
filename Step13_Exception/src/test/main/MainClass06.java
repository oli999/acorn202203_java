package test.main;

import test.mypac.MyUtil;

public class MainClass06 {
	public static void main(String[] args) {
		//Exception 을 처리할 필요가 없음 
		MyUtil.draw();
		
		//send() 메소드에서 발생하는 Exception 을 처리 해야 한다.
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
