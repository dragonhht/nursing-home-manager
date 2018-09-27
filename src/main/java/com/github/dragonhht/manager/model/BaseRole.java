package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-22
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ApiModel("基础角色实体")
public class BaseRole implements Serializable {

    private static final long serialVersionUID = 7943266551465403227L;
    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private Long id;
    @JsonBackReference
    @ApiModelProperty("密码")
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    @ApiModelProperty("角色")
    private Set<Role> roles;
    @ManyToMany
    @JoinTable(name = "user_perssion", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "perssionId")})
    @ApiModelProperty("权限")
    private Set<Perssion> perssions;
}
