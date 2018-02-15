package java8.optional;

import java.util.Optional;

public class Person {

	private String personName;
	
	private Optional<Car> car;
	
	public Person(String personName, Optional<Car> car) {
		super();
		this.personName = personName;
		this.car = car;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}

}
