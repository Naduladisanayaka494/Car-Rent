package com.carentproject.car_rent.services.customer;

import com.carentproject.car_rent.dto.BookCarDto;
import com.carentproject.car_rent.dto.CarDto;
import com.carentproject.car_rent.entity.BookACar;
import com.carentproject.car_rent.entity.Car;
import com.carentproject.car_rent.entity.User;
import com.carentproject.car_rent.enums.BookCarStatus;
import com.carentproject.car_rent.repository.BookACarRepository;
import com.carentproject.car_rent.repository.CarRepository;
import com.carentproject.car_rent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

  private final CarRepository  carRepository;
  private final UserRepository userRepository;
  private final BookACarRepository bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

//    @Override
//    public boolean bookCar(BookCarDto bookCarDto) {
//        Optional<Car> optionalCar = carRepository.findById(bookCarDto.getCarId());
//        Optional<User>  optionalUser = userRepository.findById(bookCarDto.getUserId());
//        if(optionalCar.isPresent() && optionalUser.isPresent()){
//            Car exsitingcar = optionalCar.get();
//            BookACar bookAcar = new BookACar();
//            BookCarDto bookacardto = new  BookCarDto();
//            bookAcar.setUser(optionalUser.get() );
//            bookAcar.setCar(exsitingcar);
//            bookAcar.setBookCarStatus(BookCarStatus.PENDING);
//            long diffInMilliSeconds =bookacardto.getToDate().getTime()-bookacardto.getFromDate().getTime();
//            long days = TimeUnit.MICROSECONDS.toDays(diffInMilliSeconds);
//            bookAcar.setDays(days);
//            bookAcar.setPrice( exsitingcar.getPrice()*days);
//            bookACarRepository.save(bookAcar);
//            return true;
//
//
//        }
//        return false;
//    }

    @Override
    public boolean bookCar(BookCarDto bookCarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookCarDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookCarDto.getUserId());
        if(optionalCar.isPresent() && optionalUser.isPresent()){
            Car existingCar = optionalCar.get();
            BookACar bookAcar = new BookACar();

            bookAcar.setUser(optionalUser.get());
            bookAcar.setCar(existingCar);
            bookAcar.setBookCarStatus(BookCarStatus.PENDING);

            long diffInMilliSeconds = bookCarDto.getToDate().getTime() - bookCarDto.getFromDate().getTime();
            long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds);

            bookAcar.setDays(days);
            bookAcar.setPrice(existingCar.getPrice() * days);
            bookACarRepository.save(bookAcar);

            return true;
        }
        return false;
    }


    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookCarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map(BookACar::getbookACarDto).collect(Collectors.toList());
    }

    @Override
    public List<BookCarDto> getBookings() {
        return null;
    }


}
