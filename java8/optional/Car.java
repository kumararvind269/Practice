package java8.optional;

import java.util.Optional;
import java8.optional.Insurance;

public class Car {

	
	private String carName;
	
	private Optional<Insurance> insurance;

	public Car( String carName, Optional<Insurance> insurance) {
		super();
		this.carName = carName;
		this.insurance = insurance;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	
	
		
}
