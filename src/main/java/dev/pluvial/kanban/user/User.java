package dev.pluvial.kanban.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity class of User
 * Contains all attributes of a user.
 * The database table is also used for login
 * @see dev.pluvial.kanban.security.ApplicationSecurityConfig
 * For roles of a user look at Authority
 * @see dev.pluvial.kanban.authority.Authority
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
