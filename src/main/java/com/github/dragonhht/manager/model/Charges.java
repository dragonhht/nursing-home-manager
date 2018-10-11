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

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private String remarks;

}
