package java8.defaultAndStatic;

public interface FourWheeler {


	default void print() {
		System.out.println("Inside FourWheeler print");
	}

	static void blowHorn() {
		System.out.println("inside FourWheeler blowHorn");
	}

	public void type();

}
