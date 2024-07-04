package com.carentproject.car_rent.services.auth;

import com.carentproject.car_rent.dto.SignUpRequest;
import com.carentproject.car_rent.dto.UserDto;
import com.carentproject.car_rent.entity.User;
import com.carentproject.car_rent.enums.UserRole;
import com.carentproject.car_rent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
   private final UserRepository userRepository;

    @Override
    public UserDto createdCustomer(SignUpRequest signuprequest) {
        User user = new User();
        user.setName(signuprequest.getName());
        user.setEmail(signuprequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signuprequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
     User createduser  =userRepository.save(user);
     UserDto userdto = new UserDto();
        userdto.setId(createduser.getId());
        return userdto;
    }

    @Override
    public boolean hascustomerwithemail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
