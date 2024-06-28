package com.carentproject.car_rent.services.auth;

import com.carentproject.car_rent.dto.SignUpRequest;
import com.carentproject.car_rent.dto.UserDto;

public interface AuthService {
UserDto createdCustomer(SignUpRequest signuprequest);
boolean hascustomerwithemail(String email);
}
