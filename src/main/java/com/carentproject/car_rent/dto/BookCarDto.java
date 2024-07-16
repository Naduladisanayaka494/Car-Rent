package com.carentproject.car_rent.dto;

import com.carentproject.car_rent.enums.BookCarStatus;
import lombok.Data;

import java.util.Date;

@Data

public class BookCarDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public BookCarStatus getBookCarStatus() {
        return bookCarStatus;
    }

    public void setBookCarStatus(BookCarStatus bookCarStatus) {
        this.bookCarStatus = bookCarStatus;
    }

    public Long getCarId() {
        return CarId;
    }

    public void setCarId(Long carId) {
        CarId = carId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    private Date fromDate;

    private Date toDate;

    private Long days;
    private Long price;

    private BookCarStatus bookCarStatus;

    private Long CarId;
    private Long UserId;
}
