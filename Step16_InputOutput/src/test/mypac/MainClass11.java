package test.mypac;

import java.io.File;
import java.io.FileWriter;

public class MainClass11 {
	public static void main(String[] args) {
		//문자열을 저장할 파일을 만들기 위한 File 객체
		File memoFile=new File("c:/acorn202203/myFolder/memo.txt");
		try {
			//파일이 존재하지 않으면
			if(!memoFile.exists()) {
				//파일을 만든다
				memoFile.createNewFile();
			}
			//memo.txt 에 문자열을 출력할수 있는 객체 생성 
			FileWriter fw=new FileWriter(memoFile);
			fw.write("김구라");
			fw.write("\r\n"); //개행기호
			fw.write("\t해골"); // \t 는 tab 들여쓰기 이다. 
			fw.write("\r\n");
			fw.write("원숭이");
			fw.flush();
			fw.close();
			System.out.println("파일에 문자열을 저장했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}








