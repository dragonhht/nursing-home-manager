package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费明细.
 * User: huang
 * Date: 18-9-17
 */
@Entity
@Data
public class PayDetails implements Serializable {
    private static final long serialVersionUID = -1569285962477366380L;

    @Id
    @GeneratedValue
    private int id;
    /** 缴费类别(如护理、外出). */
    private String type;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date time;
    private int price;
    /** 缴费状态， true为未交费. */
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "personId")
    @JsonIgnore
    private Person person;
}
