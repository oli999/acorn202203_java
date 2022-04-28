package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		//여러분이 직접 클래스를 만들고 객체 생성을 해서 아래의 useWeapon() 메소드를 호출해 보세요.
		Weapon w1=new Gun();
		MainClass02.useWeapon(w1);
	}
	//이 메소드는 아주 복잡한 동작을 하는 메소드라고 가정하자 
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}











