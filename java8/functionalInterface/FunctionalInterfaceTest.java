package java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		System.out.println("Print all numbers:");

		eval(list, n->true);

		System.out.println("Print even numbers:");
		eval(list, n-> n%2 == 0 );

		System.out.println("Print numbers greater than 3:");

		Condition<Integer> cond = n-> n > 3;

		eval(list, cond);

		/*Predicate<Integer> pred = p -> p<3;
		Consumer<Integer> con = c -> System.out.println(c);
		Function<Integer,Integer> fun = (f) -> 2*f;
		Supplier<Double> sup = () -> Math.random();*/
	}

	public static void eval(List<Integer> list, Condition<Integer> condition) {

		for(Integer n: list) {

			if(condition.check(n)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}


}


