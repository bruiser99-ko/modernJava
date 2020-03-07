package modernJava.chapter12.ex01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Ex01 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2017, 9, 21);	//2017-9-21
		int year = date.getYear();	//2017
		Month month = date.getMonth();	//SEPTEMBER
		int day = date.getDayOfMonth();	//21
		DayOfWeek dow = date.getDayOfWeek();	//THURSDAY
		int len = date.lengthOfMonth();	//31(9월의 일 수)
		boolean leap = date.isLeapYear();	//false(윤년 아님)

		System.out.println(date);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(dow);
		System.out.println(len);
		System.out.println(leap);
		System.out.println();

		LocalDate today = LocalDate.now();	//오늘 년월일
		
		int year2 = date.get(ChronoField.YEAR);	//2017
		int month2 = date.get(ChronoField.MONTH_OF_YEAR);	//9
		int day2 = date.get(ChronoField.DAY_OF_MONTH);	//21
		
		System.out.println(today);
		System.out.println(year2);
		System.out.println(month2);
		System.out.println(day2);
		System.out.println();
		
		int year3 = date.getYear();
		Month month3 = date.getMonth();
		int month3int = date.getMonthValue();
		int day3 = date.getDayOfMonth();
		
		System.out.println(year3);
		System.out.println(month3);
		System.out.println(month3int);
		System.out.println(day3);
		System.out.println();
		
		LocalTime time = LocalTime.of(13, 45, 20);	//13:45:20
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		System.out.println();
		
		LocalDate date2 = LocalDate.parse("2017-09-21");
		LocalTime time2 = LocalTime.parse("13:47:30");
		System.out.println(date2);
		System.out.println(time2);
		System.out.println();
		
		LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		System.out.println(dt1);
		System.out.println(dt2);
		System.out.println(dt3);
		System.out.println(dt4);
		System.out.println(dt5);
		
		LocalDate date3 = dt1.toLocalDate();
		LocalTime time3 = dt1.toLocalTime();
		System.out.println(date3);
		System.out.println(time3);
		System.out.println();
		
		Instant it1 = Instant.ofEpochSecond(3);
		Instant it2 = Instant.ofEpochSecond(3, 0);
		Instant it3 = Instant.ofEpochSecond(2, 1_000_000_000);
		Instant it4 = Instant.ofEpochSecond(4, -1_000_000_000);
		System.out.println(it1);
		System.out.println(it2);
		System.out.println(it3);
		System.out.println(it4);
		System.out.println();
		// Instant클래스는 ChronoField클래스와 함께 사용할 수 없다.
		
		/*Duration과 Period*/
		Duration d1 = Duration.between(time, time2);
		System.out.println(d1);
		Duration d2 = Duration.between(dt1, dt2);
		System.out.println(d2);
		Duration d3 = Duration.between(it1, it2);
		System.out.println(d3);
		System.out.println();
		
		Period tenDays = Period.between(LocalDate.of(2017, 9, 11), LocalDate.of(2017, 9, 21));
		System.out.println(tenDays);
		System.out.println();
		
		Duration threeMinutes1 = Duration.ofMinutes(3);
		Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
		System.out.println(threeMinutes1);
		System.out.println(threeMinutes2);
		
		Period tenDays2 = Period.ofDays(10);
		Period threeWeeks = Period.ofWeeks(3);
		Period twoYearsSixMonthsOneday = Period.of(2, 6, 1);
		System.out.println(tenDays2);
		System.out.println(threeWeeks);
		System.out.println(twoYearsSixMonthsOneday);
		
		
	}
}
