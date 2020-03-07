package modernJava.chapter11.ex01;

public class Ex01 {

	public class Person {
		private Car car;

		public Car getCar() {
			return car;
		}
	}

	public class Car {
		private Insurance insurance;

		public Insurance getInsurance() {
			return insurance;
		}
	}

	public class Insurance {
		private String name;

		public String getName() {
			return name;
		}
	}

	/*
	 * NULL로 인한 문제 발생 Person 객체가 차가 없다면(car = null) getInsurance() 메서드를 실행하면
	 * NullPointerException이 발생한다. 만약 Person이 null 이거나 getInsurance()가 null을 반환한다면
	 * 해결이 필요하다.
	 */

	/* 보수적인 자세로 NullPointerException 줄이기 */
	public String getCarInsuranceName1(Person person) {
		if (person != null) {
			Car car = person.getCar();
			if (car != null) {
				Insurance insurance = car.getInsurance();
				if (insurance != null) {
					return insurance.getName();
				}
			}
		}
		return "unknown";
	}

	/* 깊은 의심(중첩 if 확인) 제거 */
	public String getCarInsuranceName2(Person person) {
		if (person == null) {
			return "unknown";
		}
		Car car = person.getCar();
		if (car == null) {
			return "unknown";
		}
		Insurance insurance = car.getInsurance();
		if (insurance == null) {
			return "unknown";
		}
		return insurance.getName();
	}

}
