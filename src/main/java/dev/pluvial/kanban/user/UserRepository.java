package dev.pluvial.kanban.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interface for generic CRUD operations on a repository for a User.
 */
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * Finds User by email address.
     * @param email The email address.
     * @return Optional<User>
     */
    Optional<User> findByEmail(String email);

}
