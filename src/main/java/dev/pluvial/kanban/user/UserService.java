package dev.pluvial.kanban.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Service for task handling.
 */
@Service
public class UserService {

    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }
    
    public User getLoggedInUser(){
        final var currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findById(currentUserName).orElseThrow();
    }

}
