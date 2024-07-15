package com.carentproject.car_rent.services.customer;

import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.entity.Car;
import com.carentproject.car_rent.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

  private final CarRepository  carRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }
}
