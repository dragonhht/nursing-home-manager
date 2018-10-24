package com.github.dragonhht.manager.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 外出记录.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
@ApiModel("外出记录")
public class OutingRecord implements Serializable {

    private static final long serialVersionUID = -5620514748648156158L;

    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @ApiModelProperty("出发时间")
    private Date startTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("外出目的地")
    private String address;
    @ApiModelProperty("花费")
    private int price;
    @ManyToOne
    @JoinColumn(name = "personId")
    @ApiModelProperty("老人")
    private Person person;
    @OneToMany
    @JoinColumn(name = "employeeId")
    @ApiModelProperty("陪同员工")
    private Set<Employee> employees;
    @OneToOne
    @JoinColumn(name = "createId")
    @ApiModelProperty("记录填写人")
    private Employee employee;
}
