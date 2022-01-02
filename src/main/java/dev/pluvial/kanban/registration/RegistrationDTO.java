package dev.pluvial.kanban.registration;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * RegistrationDTO is used to transfer the data for the registration process.
 */
public class RegistrationDTO {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String username;

    public String getEmail() {
        return email;
    }

    public RegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}
