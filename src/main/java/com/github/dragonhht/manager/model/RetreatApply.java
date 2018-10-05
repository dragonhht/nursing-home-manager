package com.github.dragonhht.manager.model;

import com.github.dragonhht.manager.params.FormStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 退住申请.
 * User: huang
 * Date: 18-10-5
 */
@Data
@Entity
public class RetreatApply implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private FormStatus status;
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

}
