package com.carentproject.car_rent.services.admin;

import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.entity.Car;
import com.carentproject.car_rent.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final CarRepository carRepository;


    @Override
    public boolean postCar(CarDto carDto) throws IOException {
        try{
            Car car = new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setType(carDto.getType());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setImage(carDto.getImage().getBytes());
            carRepository.save(car);
            return true;
        }catch (Exception e){
            return false;
        }


    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car>  optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDto).orElse((null));
    }

    @Override
    public boolean updateCar(Long carId, CarDto carDto) throws IOException {
        Optional<Car>  optionalCar = carRepository.findById(carId);
        if( optionalCar.isPresent()){
            Car exsistingCar = optionalCar.get();
            if(carDto.getImage()!=null){
                exsistingCar.setImage(carDto.getImage().getBytes());


            }
            exsistingCar.setPrice(carDto.getPrice());
            exsistingCar.setYear(carDto.getYear());
            exsistingCar.setType(carDto.getType());
            exsistingCar.setDescription(carDto.getDescription());
            exsistingCar.setTransmission(carDto.getTransmission());
            exsistingCar.setColor(carDto.getColor());
            exsistingCar.setName(carDto.getName());
            exsistingCar.setBrand(carDto.getBrand());
            carRepository.save(exsistingCar);
            return true;
        }
        return false;
    }
}
