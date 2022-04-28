package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	
	static class YourRemocon implements Remocon{
		@Override
		public void up() {
			System.out.println("무언가를 올려요");
		}

		@Override
		public void down() {
			System.out.println("무언가를 내려요");
		}
	}
	
	public static void main(String[] args) {
		Remocon r1=new YourRemocon();
		useRemocon(r1);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}











