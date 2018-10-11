package com.github.dragonhht.manager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 收费标准.
 * User: huang
 * Date: 2018-10-11
 */
@Entity
@Data
public class Charges implements Serializable {

    private static final long serialVersionUID = 4280584470932045644L;
    @Id
    @GeneratedValue
    private int id;
    /** 收费项目. */
    private String name;
    /** 价格. */
    private int price;
    /** 备注. */
    private String remarks;

}
