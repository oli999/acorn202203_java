package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	
	static Weapon w1=new Weapon() {

		@Override
		public void attack() {
			System.out.println("뭔진 모르겠지만 공격하자!");
		}
		
	};
	
	public static void main(String[] args) {
		useWeapon(w1);
		
		Weapon w2=new Weapon() {
			@Override
			public void attack() {
				System.out.println("오잉? 이것도 공격하네?");
			}
		};
		
		useWeapon(w2);
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("오잉? 이것도 공격하네?");
			}
		});
		
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}










