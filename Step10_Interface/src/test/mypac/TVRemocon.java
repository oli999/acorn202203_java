package test.mypac;

public class TVRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("TV 체널을 올려요");
	}

	@Override
	public void down() {	
		System.out.println("TV 체널을 내려요");
	}

}
