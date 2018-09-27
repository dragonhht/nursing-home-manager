package com.github.dragonhht.manager.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 入住申请.
 * User: huang
 * Date: 18-9-20
 */
@Entity
@ApiModel("申请表")
public class ApplyForm implements Serializable {
    private static final long serialVersionUID = 2348747044382379540L;

    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    @ManyToOne
    @JoinColumn(name = "familyId")
    @ApiModelProperty("申请家属")
    private Family family;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年龄")
    private int age;
    /** 身体状况. */
    @ApiModelProperty("身体状况")
    private String physical;
    @ApiModelProperty("审核状态")
    private String status;
}
