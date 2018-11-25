package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.dragonhht.manager.params.FormStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("床位使用记录")
public class BedRecord implements Serializable {
    private static final long serialVersionUID = -4350269062598273517L;

    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty("入住时间")
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty("退住时间")
    private Date endDate;
    /** 现在使用的记录. */
    @ApiModelProperty("是否现在使用")
    private boolean isUsed;
    @ManyToOne
    @JoinColumn(name = "bedId")
    @ApiModelProperty("床位")
    private Bed bed;
    @ManyToOne
    @JoinColumn(name = "personId")
    @ApiModelProperty("老人")
    private Person person;
    /** 是否为预约. */
    private boolean isReserve;
    /** 为预约时的状态. */
    private FormStatus status = FormStatus.PENDING;
}
