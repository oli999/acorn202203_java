package test.mypac;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass16 {
	public static void main(String[] args) {
		//�ʿ��� �������� ���� ���� ������ �̸� �����.
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("c:/acorn202203/myFolder/1.jpg");
			fos=new FileOutputStream("c:/acorn202203/myFolder/copied.jpg");
			//�غ��ÿ�~  
			
			//byte �˰��̸� �о byte[] ��ü ����
			byte[] buffer=new byte[1024];
			
			while(true) {
				//byte[] ��ü�� �����ؼ� �о�� ���ϵǴ� �����ʹ� ���� byte �� ������ ���ϵȴ�. 
				int readedByte=fis.read(buffer);
				System.out.println("readedByte:"+readedByte);
				if(readedByte==-1) {
					break;//�ݺ��� Ż��
				}
				//byte[] �� �ִ� �����͸� 0 ���濡�� ���� ���� ��ŭ(readedByte) ����ϱ�
				fos.write(buffer, 0, readedByte);
				fos.flush();
			}
			System.out.println("�۾� ����!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null)fos.close();
				if(fis!=null)fis.close();
			}catch(Exception e) {}
		}
	}
}











