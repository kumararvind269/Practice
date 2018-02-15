package java8.lambdaExpression;

import java.util.Arrays;
import java.util.Collection;

public class LambdaDemo1 {

	public static void main(String[] args) {
		
		String[] strArr = {"qaz","edced","ujnd","mnbqsc","as","uefvxcvdf"};
		
		System.out.println("Original Array:" + Arrays.asList(strArr));
		
		Arrays.sort(strArr,(x,y)->x.compareTo(y));   //Arrays.sort(strArr,String::compareTo);
		
		System.out.println("Sorted Array:" + Arrays.asList(strArr));
		
		Arrays.sort(strArr,(x,y)->y.length()-x.length());
		
		System.out.println("Array sorted via length:" + Arrays.asList(strArr));

	}

}
