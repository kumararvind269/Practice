package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamDemo {

	public static void main(String...strings) {

		long startTime = System.currentTimeMillis();
		long StreamSum = StreamSum(1000L);
		long endTime = System.currentTimeMillis();
		System.out.println("Stream sum:"+StreamSum+" total time: "+(endTime-startTime));

		startTime = System.currentTimeMillis();
		long ParaStreamSum = ParaStreamSum(1000L);
		endTime = System.currentTimeMillis();
		System.out.println("Parallel Stream sum:"+ParaStreamSum+" total time: "+(endTime-startTime));
		
		List<Long> list = Stream.iterate(1L,i->i+1).limit(10).collect(Collectors.toList());
		Spliterator<Long> s = list.spliterator();
	    System.out.println("Total Size: "+s.estimateSize());
	    
	   // while(s.tryAdvance(x->System.out.print(x+" ") ));
	    s.tryAdvance(x->System.out.print(x+" ") );
	    s.tryAdvance(x->System.out.print(x+" ") );
	    System.out.println("\nSize after two iteration "+s.estimateSize());
	    
	    Spliterator<Long> s1 = s.trySplit();
	    System.out.println("Size after split 1st: "+ s.estimateSize());
	    System.out.println("Size after split 2nd: "+s1.estimateSize());
	    
	    while(s.tryAdvance(x->System.out.print(x+" ") ));
	    System.out.println();
	    while(s1.tryAdvance(x->System.out.print(x+" ") ));
		
	}

	private static long StreamSum(Long num) {
		Long temp= Stream.iterate(1L,i->i+1).limit(num).reduce(0L,(i,j)->i+j);
		return temp;
	}

	private static long ParaStreamSum(Long num) {
		Long temp= Stream.iterate(1L,i->i+1).limit(num).parallel().reduce(0L,(i,j)->i+j);
		return temp;
	}


}
