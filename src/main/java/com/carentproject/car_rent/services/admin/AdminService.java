package com.carentproject.car_rent.services.admin;

import com.carentproject.car_rent.dto.CarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;
   List<CarDto> getAllCars();
}
