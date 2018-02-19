package java8.dateAndTimeApi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateAndTimeDemo {

	public static void main(String[] args) {
		
		//Local Date
		LocalDate lDate = LocalDate.now();
		System.out.println("Today's Date: "+lDate); 
		LocalDate lDate1 = LocalDate.of(2018,02,01);
		System.out.println("Date: "+lDate1);
		LocalDate lDate2 = LocalDate.parse("2014-12-12");
		System.out.println("Date: "+lDate2);
		
		Period period = Period.between(lDate2, lDate1);
		System.out.println("Period "+period);
		

		//Local Time
		LocalTime lTime = LocalTime.now();
		System.out.println("current time "+lTime); 
		LocalTime lTime1 = LocalTime.of(22,12,12);
		lTime1.plusHours(6);
		System.out.println("time: "+lTime1); 
		LocalTime lTime2 = LocalTime.parse("13:23:01");
		System.out.println("time: "+lTime2); 
		
		Duration duration = Duration.between(lTime2,lTime1);
		System.out.println("Duration "+duration);
		
		//Local date and time
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime ldt1 = LocalDateTime.of(2018, 2, 1, 12, 10,10,123);
		System.out.println(ldt1);
		LocalDateTime ldt2 = LocalDateTime.of(lDate,lTime);
		System.out.println(ldt2);
		LocalDateTime ldt3 = LocalDateTime.parse("2018-02-19T12:15:24.188");
		System.out.println(ldt3);
		
		//DateTimeFormatter
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String str = formatter.format(now);
		System.out.println(str);
		System.out.println(now.format(formatter));
		
		LocalDateTime now1 = LocalDateTime.parse("2018/02/19 13:03:18", formatter);
		System.out.println(now1);		
		
		

	
	}

}
