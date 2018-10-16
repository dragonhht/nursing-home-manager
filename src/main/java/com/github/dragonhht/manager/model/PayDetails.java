package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("缴费明细")
public class PayDetails implements Serializable {
    private static final long serialVersionUID = -1569285962477366380L;

    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    /** 缴费类别(如护理、外出). */
    @ApiModelProperty("类型(如外出、护理)")
    private String type;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @ApiModelProperty("时间")
    private Date time;
    @ApiModelProperty("费用")
    private int price;
    /** 缴费状态， true为未交费. */
    @ApiModelProperty("是否缴费")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "personId")
    @ApiModelProperty("老人")
    private Person person;
}
