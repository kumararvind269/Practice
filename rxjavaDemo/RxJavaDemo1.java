package rxjavaDemo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class RxJavaDemo1 
{
    public static void main( String[] args )
    {
        
    	Observable<String> observable = Observable.just("Hello");
    	observable.subscribe(s->System.out.println(s));
    	
    	
    	String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    	Observable<String> observable1 = Observable.from(letters);
    	Subscription subs =observable1.subscribe(
    	  i -> System.out.println(i),//onNext
    	  Throwable::printStackTrace, //OnError
    	  () -> System.out.println("completed") //OnCompleted
    	);
    	
    	observable1.map(String::toUpperCase).subscribe(x->System.out.println(x));
    	
    	observable1.flatMap(x -> getTitle()).distinct().subscribe(x->System.out.println(x));;
    	
    }
    
   public static Observable<String> getTitle() {
    	List<String> titleList = new ArrayList<>();
    	titleList.add("ABC");
    	titleList.add("XYZ");
        return Observable.from(titleList);
    }
}
