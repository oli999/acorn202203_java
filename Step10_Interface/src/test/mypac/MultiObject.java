package test.mypac;

public class MultiObject implements Remocon, Drill{

	@Override
	public void up() {
		System.out.println("올려요");
	}

	@Override
	public void down() {
		System.out.println("내려요");
	}

	@Override
	public void hole() {
		System.out.println("구녕을 뚤어요");
	}

}
