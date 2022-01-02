package dev.pluvial.kanban.authority;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a repository for an Authority.
 */
public interface AuthorityRepository extends CrudRepository<Authority, String> {

}
