package dev.pluvial.kanban.user;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * DTO class of User
 * Used as data object in HTTP requests
 */
public class UserDTO implements Serializable {

    @Id
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

}
