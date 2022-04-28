package test.main;

import test.auto.CampingCar;
import test.auto.Engine;

public class MainClass07 {
	public static void main(String[] args) {
		
		CampingCar car1=new CampingCar(new Engine());
		car1.drive();
		car1.sleepInCar();
		
	}
}
