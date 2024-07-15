package com.carentproject.car_rent.controller;

import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
