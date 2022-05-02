package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass04 {
	public static void main(String[] args) {
		File f=new File("c:/acorn202203/myFolder/memo.txt");
	
		//위의 경로에 실제로 파일을 만들어 주는 File 객체의 메소드를 찾아서 실행하고
		//실제로 파일이 만들어지는지 확인해 보세요.
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 정상 종료 됩니다.");
	}
}
