package com.github.dragonhht.manager.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 日志记录.
 * User: huang
 * Date: 18-10-12
 */
@Entity
@Data
public class LogRecord implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    /** 日期. */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date time;
    /** 内容. */
    private String context;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

}
