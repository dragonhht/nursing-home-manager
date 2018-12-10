package com.github.dragonhht.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 家属实体.
 * User: huang
 * Date: 18-9-16
 */
@Entity
@Data
@ApiModel("员工实体")
public class Employee extends BaseRole implements Serializable {

    private static final long serialVersionUID = 1304993116620662268L;

}
