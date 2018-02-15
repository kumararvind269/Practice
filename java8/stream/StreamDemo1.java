package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

		List<String> str = Arrays.asList("hello","world","hi");

		//Stream<String> str1 = str.stream().flatMap(x->Arrays.stream(x.split(""))).distinct();
		Stream<String> str1 = str.stream().map(x -> x.split("")).flatMap(x->Arrays.stream(x)).distinct();
		List<String> str2 = str1.collect(Collectors.toList());

		System.out.println(str2);
		
		System.out.println(str.stream().allMatch(x->x.equals("hi")));
		System.out.println(str.stream().anyMatch(x->x.equals("hi")));
		System.out.println(str.stream().noneMatch(x->x.equals("h")));
		System.out.println(str.stream().findAny().get());
		
		System.out.println(str2.stream().sorted(String::compareTo).limit(5).skip(2).collect(Collectors.toList()));
		
		List<Integer> lt1 = Arrays.asList(1,4,44,2,7,0,4,75,3,23);
		
		System.out.println(lt1.stream().filter(x -> x>4).collect(Collectors.toList()));
		
		System.out.println(lt1.stream().reduce(0,(x,y)->x+y));
		

	}

}
