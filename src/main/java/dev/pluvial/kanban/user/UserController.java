package dev.pluvial.kanban.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * REST interface for reading user data with GET '/users'
 */
@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Reads data of the current logged-in user.
     * @return Data of Logged-in user.
     * @throws ResponseStatusException with HttpStatus.NOT_FOUND, if user is not found
     */
    @GetMapping("/users")
    public UserDTO getById() {
        final var currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository
                .findById(currentUserName)
                .map(user -> new UserDTO()
                        .setEmail(user.getEmail())
                        .setUsername(user.getUsername())
                )
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
