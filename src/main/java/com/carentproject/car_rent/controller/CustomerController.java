package com.carentproject.car_rent.controller;

import com.carentproject.car_rent.dto.BookCarDto;
import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getallCars(){
        List<CarDto> cardtoList= customerService.getAllCars();
        return ResponseEntity.ok( cardtoList);
    }

    @PostMapping("/car/book")
    public ResponseEntity<Void> bookaCar(@RequestBody BookCarDto bookCarDto){
        boolean success = customerService.bookCar(bookCarDto);
        if(success){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long carId) {
        CarDto carDto = customerService.getCarById(carId);
        if (carDto != null) {
            return ResponseEntity.ok(carDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
