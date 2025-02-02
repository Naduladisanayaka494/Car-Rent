package com.carentproject.car_rent.services.customer;

import com.carentproject.car_rent.dto.BookCarDto;
import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.dto.CarDtoListDto;
import com.carentproject.car_rent.dto.SearchCarDto;

import java.util.List;

public interface CustomerService {
    List<CarDto> getAllCars();

    boolean bookCar(BookCarDto bookCarDto);

    CarDto getCarById(Long carId);

    List<BookCarDto> getBookingsByUserId(Long userId);

    List<BookCarDto> getBookings();

    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
