package com.github.dragonhht.manager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 入住申请.
 * User: huang
 * Date: 18-9-20
 */
@Entity
public class ApplyForm implements Serializable {
    private static final long serialVersionUID = 2348747044382379540L;

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;
    @ManyToMany
    @JoinTable(name = "apply_person", joinColumns = {@JoinColumn(name = "applyId")},
            inverseJoinColumns = {@JoinColumn(name = "personId")})
    private Set<Person> persons;
    private String status;
}
