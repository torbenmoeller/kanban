package dev.pluvial.kanban.authority;

import dev.pluvial.kanban.user.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Primary key of Authority
 * @see dev.pluvial.kanban.authority.Authority
 */
@Embeddable
public class AuthorityPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @NotNull
    private String authority = "authority";

    public User getUser() {
        return user;
    }

    public AuthorityPK setUser(User user) {
        this.user = user;
        return this;
    }

    public String getAuthority() {
        return authority;
    }

    public AuthorityPK setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
