package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 老人实体.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Table(name = "person")
@Data
@ApiModel("老人实体")
public class Person implements Serializable {

    private static final long serialVersionUID = -3840212520046680586L;
    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年龄")
    private int age;
    /** 身体状况. */
    @ApiModelProperty("身体状况")
    private String physical;
    /** 家属. */
    @ManyToOne
    @JoinColumn(name = "familyId")
    @ApiModelProperty("家属")
    private Family family;
    @OneToMany
    @JoinColumn(name = "personId")
    @ApiModelProperty("床位记录")
    private Set<BedRecord> bedRecords;
    @OneToMany
    @JoinColumn(name = "personId")
    @ApiModelProperty("外出记录")
    private Set<OutingRecord> outingRecords;
    @OneToOne(mappedBy = "person")
    private NursRecord nursRecord;
    @OneToMany
    @JoinColumn(name = "personId")
    @ApiModelProperty("缴费记录")
    private Set<PayDetails> payDetails;
    @ManyToMany
    @JoinTable(name = "apply_person", joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "applyId")})
    @JsonIgnore
    @ApiModelProperty("相关申请记录")
    private Set<ApplyForm> applys;
}
