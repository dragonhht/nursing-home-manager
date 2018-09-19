package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 床位记录.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
public class BedRecord implements Serializable {
    private static final long serialVersionUID = -4350269062598273517L;

    @Id
    @GeneratedValue
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    /** 现在使用的记录. */
    private boolean isUsed;
    @OneToOne
    @JoinColumn(name = "bedId")
    private Bed bed;
    @OneToOne
    @JoinColumn(name = "personId")
    @JsonIgnore
    private Person person;

}
