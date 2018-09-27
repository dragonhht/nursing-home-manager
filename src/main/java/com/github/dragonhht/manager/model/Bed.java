package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * 床位.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
@ApiModel("床位实体")
public class Bed implements Serializable {

    private static final long serialVersionUID = 4065724995532316672L;
    @Id
    @ApiModelProperty("床位编号")
    private String id;
    /** 是否双人间. */
    @ApiModelProperty("是否双人间")
    private boolean isDouble;
    /** 是否入住. */
    @ApiModelProperty("是否已使用")
    private boolean isUsed;
    @OneToMany
    @JoinColumn(name = "bedId")
    @JsonIgnore
    @ApiModelProperty("床位使用记录")
    private Set<BedRecord> bedRecords;
    /** 费用. */
    @ApiModelProperty("价格")
    private int price;
}
