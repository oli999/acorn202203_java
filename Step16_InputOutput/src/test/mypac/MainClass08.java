package test.mypac;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File f=new File("c:/");
		//���ϰ�ü ���(File[]) �� ���� 
		File[] files=f.listFiles();
		//�ݺ��� ���鼭 File ��ü�� �ϳ��� �����ؼ� 
		for(File tmp:files) {
			//���� �ش� ������ ���丮��� 
			if(tmp.isDirectory()) {
				//���ȣ�� ���丮�� ���ʿ� ����ϱ� 
				System.out.println("[ "+tmp.getName()+" ]");
			}else {
				System.out.println(tmp.getName());
			}
		}
	}
}
