package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-22
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseRole implements Serializable {

    private static final long serialVersionUID = 7943266551465403227L;
    @Id
    @GeneratedValue
    private Long id;
    @JsonBackReference
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<Role> roles;
    @ManyToMany
    @JoinTable(name = "user_perssion", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "perssionId")})
    private Set<Perssion> perssions;
}
