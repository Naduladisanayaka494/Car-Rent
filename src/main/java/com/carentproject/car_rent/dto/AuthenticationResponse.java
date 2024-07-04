package com.carentproject.car_rent.dto;

import com.carentproject.car_rent.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
