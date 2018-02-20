package rxjavaDemo;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Single;

public class RxJavaDemo2 {

	public static void main(String[] args) {

		System.out.println("scan");
		String[] letters = {"a", "b", "c"};
		Observable.from(letters)
		.scan(new StringBuilder(), StringBuilder::append)
		.subscribe(total -> System.out.println(total.toString()));

		System.out.println("groupBy");
		Observable.just(1,2,3,4,5,6,7,8,9,10)
		.groupBy(i -> 0 == (i % 2) ? "EVEN" : "ODD")
		.subscribe(group ->
		group.subscribe((number) -> {
			if (group.getKey().equals("EVEN")) {
				System.out.println("Even: "+ number);
			} else {
				System.out.println("odd: "+ number);
			}
		})
				);

		System.out.println("fiter");
		Observable.just(1,2,3,4,5,6,7,8,9,10)
		.filter(i -> (i % 2 == 1))
		.subscribe(i -> System.out.println(i));

		System.out.println("takeWhile");
		Observable.just(1,2,3,4,5,6,7,8,9,10)
		.takeWhile(i -> i < 5)
		.subscribe(i -> System.out.println(i));


		String[] result = {"X"};
	    Observable<Long> obser
		= Observable.interval(200, TimeUnit.MILLISECONDS).limit(10);
	    obser.subscribe(i -> result[0] += i+" ");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result[0]);
		
		String[] result1 = {""};
		Single<String> single = Observable.just("Hello")
		  .toSingle()
		  .doOnSuccess(i -> result1[0] += i)
		  .doOnError(error -> {
		      throw new RuntimeException(error.getMessage());
		  });
		single.subscribe(i->System.out.println(i));
		
		
	}
}
