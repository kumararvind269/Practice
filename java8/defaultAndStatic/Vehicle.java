package java8.defaultAndStatic;

public interface Vehicle {


	default void print() {
		System.out.println("Inside vehicle print");
	}

	static void blowHorn() {
		System.out.println("inside vehicle blowHorn");
	}


}
