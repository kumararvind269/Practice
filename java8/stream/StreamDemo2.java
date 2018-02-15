package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;

public class StreamDemo2 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 8, 4, 5,6);
		List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(squares);

		//Integer max1 = numbers.stream().reduce(0,(x,y)->x>y?x:y);
		Integer max = numbers.stream().reduce(0,Integer::max);

		System.out.println(max);

		int sum = numbers.parallelStream().reduce(0, Integer::sum);
		System.out.println(sum);

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		List<int[]> x = numbers1.stream().flatMap(i -> numbers2.stream()
				.map(j -> new int[] {i,j})).collect(Collectors.toList());
		x.forEach(x1->System.out.println(Arrays.toString(x1)));

		IntStream intStrm = Arrays.stream(new int[] {1,2,3});

		IntStream.range(0,100).filter(i -> i%7==0).forEach((i)->System.out.print(i+" "));


		String[][] twoArr = {{"sdfsd","sdfsd"}};
		Stream<String[]> StrmTwoArr = Stream.of(twoArr);
		Stream<String> vv = StrmTwoArr.flatMap(qq->Stream.of(qq));
		vv.forEach(System.out::print);
		System.out.println();

		Stream.iterate(new int[] {0,1},t -> new int[] {t[1],t[1]+t[0]}).
										limit(10).forEach(t->System.out.print(t[0]+" "));;

	}

}
