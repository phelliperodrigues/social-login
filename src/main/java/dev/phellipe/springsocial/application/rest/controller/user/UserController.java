package dev.phellipe.springsocial.application.rest.controller.user;

import dev.phellipe.springsocial.application.rest.domain.request.user.UserRequest;
import dev.phellipe.springsocial.application.rest.domain.response.user.UserResponse;
import dev.phellipe.springsocial.domain.usecase.user.GetCurrentUser;
import dev.phellipe.springsocial.infrastructure.security.domain.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final GetCurrentUser getCurrentUser;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserResponse> getCurrentUser(@CurrentUser UserRequest request) {
        return ResponseEntity.ok(UserResponse.from(getCurrentUser.execute(request.getId())));
    }
}