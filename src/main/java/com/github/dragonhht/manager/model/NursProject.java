package com.github.dragonhht.manager.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 护理项目.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
@ApiModel("护理项目实体")
public class NursProject implements Serializable {
    private static final long serialVersionUID = 8599023660624054011L;

    @Id
    @GeneratedValue
    @ApiModelProperty("编号")
    private int id;
    @ApiModelProperty("项目名")
    private String name;
    @ApiModelProperty("价格")
    private int price;
    @OneToOne(mappedBy = "project")
    @ApiModelProperty("护理记录")
    private NursRecord record;
}
