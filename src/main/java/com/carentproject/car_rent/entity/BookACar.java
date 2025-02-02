package com.carentproject.car_rent.entity;

import com.carentproject.car_rent.dto.BookCarDto;
import com.carentproject.car_rent.enums.BookCarStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data

public class BookACar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date fromDate;

    private Date toDate;

    private Long days;
    private Long price;

    private BookCarStatus bookCarStatus;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="car_id",nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
    private Car car;

    public BookCarDto getbookACarDto(){
        BookCarDto bookCarDto=new BookCarDto();
        bookCarDto.setId(id);
        bookCarDto.setDays(days);
        bookCarDto.setBookCarStatus(bookCarStatus);
        bookCarDto.setPrice(price);
        bookCarDto.setFromDate(fromDate);
        bookCarDto.setToDate(toDate);
        bookCarDto.setEmail(user.getEmail());
       bookCarDto.setUsername(user.getUsername());
       bookCarDto.setCarId(car.getId());
       return bookCarDto;

    }



}
