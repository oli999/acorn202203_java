package test.main;

import test.mypac.Car;
import test.mypac.Messenger;

public class MainClass02 {
	public static void main(String[] args) {
	
		//Messenger Ŭ������ ���� static �޼ҵ� 3���� ȣ���ϴ� code �� �ۼ��� ������
		Messenger.sendMessage("hi");
		Messenger.getMessage();
		Messenger.useCar(new Car());
		
	}
}