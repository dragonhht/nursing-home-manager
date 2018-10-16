package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 家属实体.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Getter
@Setter
@ApiModel("家属实体")
public class Family extends BaseRole implements Serializable {

    private static final long serialVersionUID = 1304993116620662268L;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("地址")
    private String address;
    /** 老人. */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "familyId")
    @JsonIgnore
    @ApiModelProperty("关联的老人")
    private Set<Person> persons;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "familyId")
    @JsonIgnore
    @ApiModelProperty("提交的申请")
    private Set<ApplyForm> applys;
}
