package com.carentproject.car_rent.services.customer;

import com.carentproject.car_rent.dto.BookCarDto;
import com.carentproject.car_rent.dto.CarDto;

import java.util.List;

public interface CustomerService {
    List<CarDto> getAllCars();

    boolean bookCar(BookCarDto bookCarDto);

}
