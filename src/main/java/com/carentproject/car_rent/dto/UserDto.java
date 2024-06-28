package com.carentproject.car_rent.dto;

import com.carentproject.car_rent.enums.UserRole;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {



    private Long id;
    private String name;
    private String email;

    private UserRole userRole;

}
