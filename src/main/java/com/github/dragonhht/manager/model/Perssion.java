package com.github.dragonhht.manager.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 权限表.
 * User: huang
 * Date: 18-9-23
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("权限实体")
public class Perssion implements Serializable {
    @Id
    @ApiModelProperty("权限")
    private String perssion;
}
