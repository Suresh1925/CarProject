package com.onesoft.car.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.car.entity.Car;
import com.onesoft.car.services.CarServices;

@RestController
public class CarController {
	@Autowired
	CarServices carservice;
static Logger log=Logger.getLogger(CarController.class);
	@PostMapping(value = "/PostCar")
	public String addCar(@RequestBody Car c) {
		PropertyConfigurator.configure("car4j.properties");
		log.info(carservice.addCar(c));
		return carservice.addCar(c);
	}

	@PostMapping(value = "/addCars")
	public String addCars(@RequestBody List<Car> c) {
		PropertyConfigurator.configure("car4j.properties");
		log.info(carservice.addCars(c));
		return carservice.addCars(c);
	}

	@DeleteMapping(value = "/delCar/{slNo}")
	public String delCar(@PathVariable int slNo) {
		return carservice.delCar(slNo);
	}

	@PutMapping(value = "/updateCar/{slNo}")
	public String updateCar(@RequestBody Car c) {
		return carservice.updateCar(c);
	}

	@GetMapping(value = "/findCar/{slNo}")
	public Car findCar(@PathVariable int slNo) {
		return carservice.findCar(slNo);
	}

	@GetMapping(value = "/findAll")
	public List<Car> findCars() {
		return carservice.findCars();
	}

	@GetMapping(value = "/getAudi/{brand}")
	public List<Car> getBrand(@PathVariable String brand) {
		return carservice.getBrand(brand);
	}

	@GetMapping(value = "/getCC/{enginecc}")
	public List<Car> getEngineCC(@PathVariable int enginecc) {
		return carservice.getEngineCC(enginecc);
	}

	@GetMapping(value = "/maxPrice")
	public Car maxCar() {
		return carservice.maxCar();
	}

	@GetMapping(value = "/minPrice")
	public Car minCar() {
		return carservice.minCar();
	}

	@GetMapping(value = "/getPriceCar/{price}")
	public List<Car> getPrice(@PathVariable int price) {
		return carservice.getPrice(price);
	}
	@PatchMapping(value="/ModifyVehicle/{slNo}")
	public Car change(@PathVariable int slNo,@RequestBody Car c) {
		return carservice.change(slNo,c);
	}
	
}
