package rxjavaDemo;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.observables.ConnectableObservable;
import rx.subjects.PublishSubject;

public class RxJavaDemo4 {

	public static void main(String[] args) throws InterruptedException {


		//PublishSubject
		PublishSubject<String> subject = PublishSubject.create(); 

		Observer<String> obv1 = getObserve("one");
		Observer<String> obv2= getObserve("two");

		subject.subscribe(obv1);
		subject.onNext("ABC");
		subject.onNext("DEF");
		subject.subscribe(obv2);
		subject.onNext("GHI");
		subject.onNext("JKL");
		subject.onCompleted();


		//cache
		Observable<Long> obs = Observable.interval(500, TimeUnit.MILLISECONDS);
		obs = obs.cache();
		obs.subscribe(i->System.out.println("A "+i));
		Thread.sleep(1000);
		obs.subscribe(i->System.out.println("B "+i));
		Thread.sleep(1000);
		obs.subscribe(i->System.out.println("C "+i));
	

       //ConnectableObservable
		String[] result = {""};
		ConnectableObservable<Long> connectable
		  = Observable.interval(200, TimeUnit.MILLISECONDS).publish();
		connectable.subscribe(i -> result[0] += i);
		connectable.connect();
		System.out.println("Before Sleep: "+result[0]);
		Thread.sleep(500);
		System.out.println("After Sleep: "+result[0]);



	}

	private static Observer<String> getObserve(String name) {
		return new Observer<String>() {

			@Override
			public void onCompleted() {
				System.out.println("Oncompleted of Observer "+ name);
			}

			@Override
			public void onError(Throwable e) {
			}

			@Override
			public void onNext(String t) {
				System.out.println("OnNext of Observer "+name+" Vaue: "+t);

			}
		};
	}




}
