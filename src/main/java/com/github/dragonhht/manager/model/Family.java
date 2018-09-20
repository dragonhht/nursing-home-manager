package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 家属实体.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
public class Family implements Serializable {

    private static final long serialVersionUID = 1304993116620662268L;
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phone;
    private String address;
    /** 老人. */
    @OneToMany
    @JoinColumn(name = "familyId")
    @JsonIgnore
    private Set<Person> persons;
    @JsonBackReference
    private String password;
    @OneToMany
    @JoinColumn(name = "familyId")
    @JsonIgnore
    private Set<ApplyForm> applys;
}
