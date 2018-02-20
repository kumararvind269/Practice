package rxjavaDemo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class RxJavaDemo3 {

	public static void main(String[] args) {

		
		//Zip
		Observable<Integer> obs1 = Observable.just(1, 3, 5, 7, 9);
        Observable<Integer> obs2 = Observable.just(2, 4, 6);
        
        Observable<List<Integer>> obs = Observable.zip(obs1, obs2, (value1, value2) -> {
            List<Integer> list = new ArrayList<Integer>();
            list.add(value1);
            list.add(value2);
            return list;
        });
        
        obs.subscribe((value) -> {
              System.out.println("Value = " + value);            
        });
        
        
        //reduce
        Observable.just(1, 2, 3, 4, 5)
	      .reduce(0,(v1,v2)->v1+v2)
	      .subscribe(value -> {
	          System.out.println("value = " + value);
	      }); 
        
        //range
        Observable.range(1, 10)
		  .observeOn(Schedulers.computation())
		  .subscribe(r->System.out.println(r));
		

        
	}

}
