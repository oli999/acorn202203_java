package test.mypac;

import java.io.BufferedReader;
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
public class MainClass13 {
	public static void main(String[] args) {
		//���ڿ��� ������ ������ ����� ���� File ��ü
		File memoFile=new File("c:/acorn202203/myFolder/memo.txt");
		
		try {
			//���Ͽ��� ���ڿ��� �о���ϼ� �ִ� ��ü ����
			FileReader fr=new FileReader(memoFile);
			BufferedReader br=new BufferedReader(fr);
			//�ݺ��� ���鼭 
			while(true) {
				//���پ� �о�� 
				String line=br.readLine();
				//���� ���̻� ���� ���ڿ��� ���ٸ�
				if(line==null) {
					break; //�ݺ��� Ż��
				}
				//�о ���ڿ� �ֿܼ� ����ϱ� 
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















