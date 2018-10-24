package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 护理记录.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
@ApiModel(("护理记录"))
public class NursRecord implements Serializable {
    private static final long serialVersionUID = 76970297647054932L;

    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty("时间")
    private Date time;
    @ApiModelProperty("价格")
    private int price;
    /** 护理项目. */
    @OneToOne
    @JoinColumn(name = "nursId")
    @ApiModelProperty("护理项目")
    private NursProject project;
    @OneToOne
    @JoinColumn(name = "personId")
    @ApiModelProperty("接受护理的老人")
    private Person person;
    @OneToMany
    @JoinColumn(name = "employeeId")
    @ApiModelProperty("护理员工")
    private Set<Employee> employees;
    @OneToOne
    @JoinColumn(name = "createId")
    @ApiModelProperty("记录填写人")
    private Employee employee;
}