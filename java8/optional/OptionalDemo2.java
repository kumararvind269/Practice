package java8.optional;

import java.util.Optional;

public class OptionalDemo2 {

	public static void main(String[] args) {
		
		 Optional<String> gender = Optional.of("MALE");
	        Optional<String> emptyGender = Optional.empty();

	        if (gender.isPresent()) {
	            System.out.println("Value available.");
	        } else {
	            System.out.println("Value not available.");
	        }

	        gender.ifPresent(g -> System.out.println("value available."));

	        emptyGender.ifPresent(g -> System.out.println("value available."));
	        
	        System.out.println(gender.orElse("NA")); 
	        System.out.println(emptyGender.orElse("NA")); 
	        System.out.println(gender.orElseGet(() -> "NA")); 
	        System.out.println(emptyGender.orElseGet(() -> "NA"));


	}

}
