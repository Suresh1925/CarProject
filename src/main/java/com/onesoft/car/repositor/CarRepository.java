package com.onesoft.car.repositor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onesoft.car.entity.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
