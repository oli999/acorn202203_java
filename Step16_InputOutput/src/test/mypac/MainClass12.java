package test.mypac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 *   c:/acorn202203/myFolder/memo.txt ���Ͽ� ��ϵ� ���ڿ��� �о 
 *   �ܼ�â�� ����� ������.
 *   
 *   - hint 
 *   FileReader ��ü�� �� Ȱ���� ������.
 */
public class MainClass12 {
	public static void main(String[] args) {
		//���ڿ��� ������ ������ ����� ���� File ��ü
		File memoFile=new File("c:/acorn202203/myFolder/memo.txt");
		
		try {
			//���Ͽ��� ���ڿ��� �о���ϼ� �ִ� ��ü ����
			FileReader fr=new FileReader(memoFile);
			//�ݺ��� ���鼭
			while(true) {
				//���� code �ϳ��� �о��. 
				int code=fr.read();
				//���� ���̻� ���� code ���� ������
				if(code==-1) {
					break;//�ݺ��� Ż��
				}
				//�ڵ尪�� ���ڷ� ��ȯ�ؼ� 
				char ch=(char)code;
				//�����ȣ ���� ����ϱ� 
				System.out.print(ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















