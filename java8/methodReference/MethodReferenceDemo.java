package java8.methodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.Comparator;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		
		  List<Employee> names = new ArrayList<>();
		
		  names.add(new Employee(123,"Arvind",99999999));

		  names.add(new Employee(121,"Ramesh",777777777));
		  
		  names.add(new Employee(127,"Sohit",88888888));
	      
	      //names.sort((s1,s2)->s1.getName().compareToIgnoreCase(s2.getName()));;
		  
	      names.sort(Comparator.comparing(Employee::getName).reversed().thenComparing(Employee::getEmpId));
	      
	      names.forEach(System.out::println);
	      
	      Supplier<Double> random = Math::random;
	      System.out.println(random.get());
	      
	}

}
