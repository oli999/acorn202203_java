package test.mypac;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass15 {
	public static void main(String[] args) {
		//�ʿ��� �������� ���� ���� ������ �̸� �����.
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("c:/acorn202203/myFolder/1.jpg");
			fos=new FileOutputStream("c:/acorn202203/myFolder/copied.jpg");
			//�غ��ÿ�~   ( �о int ���� �״�� ����ϸ� ��)
			while(true) {
				//1byte �� �о�� 
				int data=fis.read();
				System.out.println(data);
				//���� ���̻� ���� �����Ͱ� ���ٸ� 
				if(data==-1) {
					break;//�ݺ��� Ż��
				}
				//�о ��ŭ ���
				fos.write(data);
				fos.flush();//����
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











