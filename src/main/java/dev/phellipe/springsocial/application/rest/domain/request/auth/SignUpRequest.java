package dev.phellipe.springsocial.application.rest.domain.request.auth;

import dev.phellipe.springsocial.domain.entity.auth.SignUp;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public SignUp toEntity() {
        return SignUp.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

}
