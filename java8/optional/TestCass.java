package java8.optional;

import java.util.Optional;

public class TestCass {

	public static void main(String[] args) {
		
		Insurance insure = new Insurance(1,"I123");
		Car car = new Car("C123",Optional.ofNullable(insure));
		Person person = new Person("P123",Optional.ofNullable(car));
		
		System.out.println(getInsuranceName(person));
		
		Insurance insure1 = null;
		Car car1 = new Car("C123",Optional.ofNullable(insure1));
		Person person1 = new Person("P123",Optional.ofNullable(car1));
		System.out.println(getInsuranceName(person1));
		
	}

	private static String getInsuranceName(Person person) {
		
		return person.getCar().flatMap(x-> x.getInsurance()).map(i->i.getInsureName()).orElse("No Value");
	}

}
