package com.carentproject.car_rent.controller;





import com.carentproject.car_rent.dto.AuthenticationRequest;
import com.carentproject.car_rent.dto.AuthenticationResponse;
import com.carentproject.car_rent.dto.UserDto;
import com.carentproject.car_rent.entity.User;
import com.carentproject.car_rent.repository.UserRepository;
import com.carentproject.car_rent.services.auth.AuthServiceImpl;
import com.carentproject.car_rent.dto.SignUpRequest;
import com.carentproject.car_rent.services.jwt.UserService;
import com.carentproject.car_rent.services.jwt.UserServiceimpl;
import com.carentproject.car_rent.utill.JWTUtill;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;
    private final AuthenticationManager authenticationManager;
    private final UserServiceimpl userService;
    private final JWTUtill jwtUtill;
    private  final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignUpRequest signupRequest) {
        if(authService.hascustomerwithemail(signupRequest.getEmail()))
            return new ResponseEntity<>("email already exists",HttpStatus.NOT_ACCEPTABLE);
        UserDto createduserdto  =authService.createdCustomer(signupRequest);
        if(createduserdto==null) return new ResponseEntity<>(
                "customer not created", HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(createduserdto,HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public AuthenticationResponse createauthenticationtoken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException, DisabledException, UsernameNotFoundException, BadRequestException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        }catch(BadCredentialsException e){
            throw new BadRequestException("incorrect username or passoword");
        }
        final UserDetails userDetails= userService.userDetailService().loadUserByUsername(authenticationRequest.getEmail());
        System.out.print(userDetails.getUsername());
        Optional<User> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        final String jwt = jwtUtill.generateToken(userDetails);
        AuthenticationResponse  authenticationResponse= new AuthenticationResponse();
        if(optionalUser.isPresent()){
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
        }
        return authenticationResponse;

    }
}
