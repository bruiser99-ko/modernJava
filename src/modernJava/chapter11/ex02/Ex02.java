package modernJava.chapter11.ex02;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex02 {

	public class Person {
		private Optional<Car> car;
		public Optional<Car> getCar() {
			return car;
		}
	}
	
	public class Car {
		private Optional<Insurance> insurance;
		public Optional<Insurance> getInsurance() {
			return insurance;
		}
	}
	public class OptPerson {
		private OptCar optCar;
		public OptCar getOptCar() {
			return optCar;
		}
	}
	
	public class OptCar {
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
	
	public String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
				.flatMap(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
	}
	
	/* Optional 스트림 조작 */
	public Set<String> getCarInsuranceNames(List<OptPerson> person) {
		return person.stream()
				.map(OptPerson::getOptCar)
				.map(OptCar::getInsurance)
				.map(Insurance::getName)
				.collect(Collectors.toSet());
	}
}
