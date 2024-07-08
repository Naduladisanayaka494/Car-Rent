package com.carentproject.car_rent.repository;

import com.carentproject.car_rent.entity.Car;
import com.carentproject.car_rent.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarRepository extends JpaRepository<Car, Long> {



}
