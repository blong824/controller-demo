package com.billy.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImplementation implements CarServiceInterface {

	List<Car> cars = new ArrayList<>();
	
	@PostConstruct()
	public void init() {
		cars.add(new Car(1L, "toyota", "tundra", "black"));
		cars.add(new Car(2L, "nissan", "rogue", "green"));
		cars.add(new Car(3L, "bmw", "3-series", "blue"));
	}
	
	@Override
	public List<Car> getCars() {
		return cars;
	}

	@Override
	public List<Car> getCars(String make, String model) {

		List<Car> result = cars.stream()
				.filter(c -> c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model))
				.collect(Collectors.toList());
		
		return result;
		
	}

	@Override
	public Car getCarsById(Long id) {
		
		Optional<Car> result = cars.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
		
		return result.get();
		
	}
	
	@Override
	public Car addCar(Car car) {
		cars.add(car);
		return car;
	}

}