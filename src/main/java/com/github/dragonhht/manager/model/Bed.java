package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * 床位.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
public class Bed implements Serializable {

    private static final long serialVersionUID = 4065724995532316672L;
    @Id
    private String id;
    /** 是否双人间. */
    private boolean isDouble;
    /** 是否入住. */
    private boolean isUsed;
    @OneToOne(mappedBy = "bed")
    @JsonIgnore
    private BedRecord record;
    /** 费用. */
    private int price;
}
