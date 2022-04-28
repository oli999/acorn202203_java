package test.main;

import test.auto.Engine;
import test.auto.RacingCar;

public class MainClass08 {
	public static void main(String[] args) {
		RacingCar car1=new RacingCar(new Engine());
		car1.drive();
	}
}
