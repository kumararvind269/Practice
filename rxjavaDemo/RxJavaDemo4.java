package rxjavaDemo;

import rx.Observer;
import rx.subjects.PublishSubject;

public class RxJavaDemo4 {

	public static void main(String[] args) {
		
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
