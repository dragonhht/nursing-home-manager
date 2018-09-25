package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 老人实体.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Table(name = "person")
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = -3840212520046680586L;
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String sex;
    private int age;
    /** 身体状况. */
    private String physical;
    /** 家属. */
    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;
    @OneToMany
    @JoinColumn(name = "personId")
    private Set<BedRecord> bedRecords;
    @OneToMany
    @JoinColumn(name = "personId")
    private Set<OutingRecord> outingRecords;
    @OneToOne(mappedBy = "person")
    private NursRecord nursRecord;
    @OneToMany
    @JoinColumn(name = "personId")
    private Set<PayDetails> payDetails;
    @ManyToMany
    @JoinTable(name = "apply_person", joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "applyId")})
    @JsonIgnore
    private Set<ApplyForm> applys;
}
