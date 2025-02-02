package com.carentproject.car_rent.services.admin;

import com.carentproject.car_rent.dto.BookCarDto;
import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.dto.CarDtoListDto;
import com.carentproject.car_rent.dto.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;
   List<CarDto> getAllCars();

   void deleteCar(Long id);

   CarDto getCarById(Long id);

   boolean updateCar(Long carId,CarDto carDto) throws IOException;

    List<BookCarDto> getBookings();

    boolean changeBookingStatus(Long bookingId,String status);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);


}
