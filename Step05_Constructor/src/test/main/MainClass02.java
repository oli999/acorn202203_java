package test.main;

import test.mypac.Cpu;
import test.mypac.HardDisk;
import test.mypac.MacBook;
import test.mypac.Market;
import test.mypac.Memory;

public class MainClass02 {
	public static void main(String[] args) {
		
		//1. MacBook 객체를 생성해서 참조값을 mac1 이라는 지역변수에 담아 보세요.
		MacBook mac1=new MacBook(new Cpu(), new Memory(), new HardDisk());
		//2. mac1 지역변수에 들어 있는 참조값을 이용해서 .doGame() 이라는 메소드를 호출해 보세요.
		mac1.doGame();
		
		
		MacBook mac2=new MacBook(Market.c, Market.m, Market.h);
		mac2.doGame();
	}
}













