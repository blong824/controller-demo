package com.billy.demo;

import java.util.List;

public interface CarServiceInterface {

	public List<Car> getCars();
	public List<Car> getCars(String make, String model);
	public Car getCarsById(Long id);
	public Car addCar(Car car);
}
