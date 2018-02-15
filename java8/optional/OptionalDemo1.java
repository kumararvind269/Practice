package java8.optional;

import java.util.Optional;

public class OptionalDemo1 {

	public static void main(String[] args) {
		
		Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
        //System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
        
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender1 -> gender1.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender1 -> gender1.map(String::toUpperCase)));

        System.out.println(gender.filter(g -> g.equals("male"))); 
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE")));
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE")));
		

	}

}
