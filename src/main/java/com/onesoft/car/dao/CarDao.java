package com.onesoft.car.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.car.entity.Car;
import com.onesoft.car.repositor.CarRepository;

@Repository
public class CarDao {
	@Autowired
	CarRepository carRepo;

	public String addCar(Car c) {
		carRepo.save(c);
		return "Saved successfully";
	}

	public String addCars(List<Car> c) {
		carRepo.saveAll(c);
		return "Added Successfully";
	}

	public String delCar(int slNo) {
		carRepo.deleteById(slNo);
		return "Deleted Successfully";
	}

	public String updateCar(Car c) {
		carRepo.save(c);
		return "Updated Successfully";
	}

	public Car findCar(int slNo) {
		return carRepo.findById(slNo).get();
	}

	public List<Car> findCars() {
		return carRepo.findAll();
	}

	public Car change(int slNo, Car c) {
		Car x=carRepo.findById(slNo).get();
		x.setBrand(c.getBrand());
		x.setModel(c.getModel());
		x.setColor(c.getColor());
		x.setPrice(c.getPrice());
		x.setEnginecc(c.getEnginecc());
		return carRepo.save(x);
	}

	public Car putone(Car c) {
		// TODO Auto-generated method stub
	return	carRepo.save(c);
	
	}


}
