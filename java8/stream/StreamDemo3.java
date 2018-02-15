package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.stream.Employee.GENDER;

public class StreamDemo3 {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,GENDER.FEMALE,"Aruna"));
		list.add(new Employee(2,GENDER.MALE,"Arvind"));
		list.add(new Employee(3,GENDER.MALE,"Vaibhav"));
		list.add(new Employee(4,GENDER.FEMALE,"Sudha"));
		list.add(new Employee(5,GENDER.FEMALE,"Arti"));

		Map<GENDER,List<Employee>> hm = list.stream().collect(Collectors.groupingBy(Employee::getGender));
		for(GENDER st : hm.keySet()) {
			System.out.println("gender: "+st +" "+hm.get(st));
		}
		
		Map<GENDER,Optional<Employee>> hm1 = list.stream().
					collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy((x,y)->x.getName().compareTo(y.getName()))));
		
		for(GENDER st : hm1.keySet()) {
			System.out.println("gender: "+st +" "+hm1.get(st));
		}
		
		String name = list.stream().map(x->x.getName()).collect(Collectors.joining(","));
		System.out.println(name);
		
		Map<Integer,String> hm2 = list.stream().collect(Collectors.toMap(Employee::getId,Employee::getName));
		
		for(Integer st : hm2.keySet()) {
			System.out.println("id: "+st +" "+hm2.get(st));
		}

		
	}

}
