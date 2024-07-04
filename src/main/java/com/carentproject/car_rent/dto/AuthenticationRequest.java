package com.carentproject.car_rent.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;


}
