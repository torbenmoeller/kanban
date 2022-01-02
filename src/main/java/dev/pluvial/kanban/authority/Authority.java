package dev.pluvial.kanban.authority;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity class of Authority
 * Maps roles to a user
 * @see dev.pluvial.kanban.user.User
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    @EmbeddedId
    private AuthorityPK authorityPK;

    public AuthorityPK getAuthorityPK() {
        return authorityPK;
    }

    public Authority setAuthorityPK(AuthorityPK authorityPK) {
        this.authorityPK = authorityPK;
        return this;
    }

}
