package com.onesoft.car.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.car.dao.CarDao;
import com.onesoft.car.entity.Car;

@Service
public class CarServices {
	@Autowired
	CarDao carDao;

	public String addCar(Car c) {
		return carDao.addCar(c);
	}

	public String addCars(List<Car> c) {
		return carDao.addCars(c);
	}

	public String delCar(int slNo) {
		return carDao.delCar(slNo);
	}

	public String updateCar(Car c) {
		return carDao.updateCar(c);
	}

	public Car findCar(int slNo) {
		return carDao.findCar(slNo);
	}

	public List<Car> findCars() {
		return carDao.findCars();
	}

	public List<Car> getBrand(String brand) {
		List<Car> getCar = carDao.findCars();
		List<Car> liCar = getCar.stream().filter(x -> x.getBrand().equalsIgnoreCase(brand)).toList();
		return liCar;
	}

	public List<Car> getEngineCC(int enginecc) {
		List<Car> getCc = carDao.findCars();
		List<Car> liCC = getCc.stream().filter(x -> x.getEnginecc() > enginecc).toList();
		return liCC;
	}

	public Car maxCar() {
		List<Car> carMax = carDao.findCars();
		Car liMax = carMax.stream().max(Comparator.comparing(Car::getPrice)).get();
		return liMax;
	}

	public Car minCar() {
		List<Car> carMin = carDao.findCars();
		Car liMin = carMin.stream().min(Comparator.comparing(Car::getPrice)).get();
		return liMin;
	}

	public List<Car> getPrice(int price) {
		List<Car> getPriceOf = carDao.findCars();
		List<Car> liPrice = getPriceOf.stream().filter(x -> x.getPrice() >= price).toList();
		return liPrice;
	}

	public Car change(int slNo, Car c) {
		// TODO Auto-generated method stub
		return carDao.change(slNo,c);
	}

	public Car putone(Car c) {
		// TODO Auto-generated method stub
		return carDao.putone(c);
	}

}
