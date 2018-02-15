package java8.defaultAndStatic;

public class Car implements Vehicle, FourWheeler {

	@Override
	public void type() {
		System.out.println("petrol");
	}

	@Override
	public void print() {
		FourWheeler.super.print();
		Vehicle.super.print();
	}
	
	static void blowHorn() {
		FourWheeler.blowHorn();
		Vehicle.blowHorn();

	}

}
