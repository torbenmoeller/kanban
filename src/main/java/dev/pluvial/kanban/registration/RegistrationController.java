package dev.pluvial.kanban.registration;

import dev.pluvial.kanban.authority.*;
import dev.pluvial.kanban.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * REST interface for user registration with POST '/users'
 */
@RestController
public class RegistrationController {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    RegistrationController(
            UserRepository userRepository,
            AuthorityRepository authorityRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }
    /**
     * Registers a new user
     * @param registrationDto with parameters email, password and username.
     *                        Email, password and username are necessary.
     * @see RegistrationDTO
     * @return Data of logged-in user.
     * @throws ResponseStatusException with HttpStatus.CONFLICT, if email already exists for a user.
     * @throws ResponseStatusException with HttpStatus.BAD_REQUEST, if email is not an email or password is blank.
     */
    @PostMapping("/users")
    public UserDTO postNewUser(@Valid @RequestBody RegistrationDTO registrationDto) {
        //throw exception, if user is already registered
        if (userRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Already Exists");
        }
        var newUser = new User()
                .setUsername(registrationDto.getUsername())
                .setEmail(registrationDto.getEmail())
                .setPassword(passwordEncoder.encode(registrationDto.getPassword()))
                .setEnabled(true);
        userRepository.save(newUser);
        var authority = new Authority().setAuthorityPK(
                new AuthorityPK()
                        .setAuthority("Default")
                        .setUser(newUser)
        );
        authorityRepository.save(authority);
        return new UserDTO()
                .setUsername(newUser.getUsername())
                .setEmail(newUser.getEmail());
    }

}
