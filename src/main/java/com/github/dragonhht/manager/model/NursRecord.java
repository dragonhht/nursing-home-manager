package com.github.dragonhht.manager.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 护理记录.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
public class NursRecord implements Serializable {
    private static final long serialVersionUID = 76970297647054932L;

    @Id
    @GeneratedValue
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date time;
    /** 护理项目. */
    @OneToOne
    @JoinColumn(name = "nursId")
    private NursProject project;
    @OneToOne
    @JoinColumn(name = "personId")
    private Person person;
}