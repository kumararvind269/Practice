package java8.lambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ErrorHandingLambda {

	public static void main(String[] args) {

		int[] arr = {1,3,6,3,2,0,3,4};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		// list.forEach(x-> System.out.println(50/x));

		   list.forEach(ConsumerWrapper(x-> System.out.println(50/x)));


	}

	public static Consumer<Integer> ConsumerWrapper(Consumer<Integer> con){
		return i -> {
			try {
				con.accept(i);
			}catch(Exception ex){
				System.out.println(ex);
			}	
		};
	}
}
