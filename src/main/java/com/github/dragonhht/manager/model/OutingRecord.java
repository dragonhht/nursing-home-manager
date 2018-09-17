package com.github.dragonhht.manager.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 外出记录.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
public class OutingRecord implements Serializable {

    private static final long serialVersionUID = -5620514748648156158L;

    @Id
    @GeneratedValue
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date startTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date endTime;
    private String address;
    private int price;
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;
}
