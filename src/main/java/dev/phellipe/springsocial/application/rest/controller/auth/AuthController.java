package dev.phellipe.springsocial.application.rest.controller.auth;

import dev.phellipe.springsocial.application.rest.domain.request.auth.LoginRequest;
import dev.phellipe.springsocial.application.rest.domain.request.auth.SignUpRequest;
import dev.phellipe.springsocial.application.rest.domain.response.ApiResponse;
import dev.phellipe.springsocial.application.rest.domain.response.auth.AuthResponse;
import dev.phellipe.springsocial.domain.usecase.auth.Login;
import dev.phellipe.springsocial.domain.usecase.auth.Register;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final Login login;

    private final Register register;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new AuthResponse(login.execute(loginRequest.getEmail(), loginRequest.getPassword())));
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        var result = register.execute(signUpRequest.toEntity());

        var location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}