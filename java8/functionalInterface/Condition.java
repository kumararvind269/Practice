package java8.functionalInterface;

@FunctionalInterface
public interface Condition<T> {
	
	public boolean check(T t);

}
