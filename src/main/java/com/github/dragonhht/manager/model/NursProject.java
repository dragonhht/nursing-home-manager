package com.github.dragonhht.manager.model;

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
public class NursProject implements Serializable {
    private static final long serialVersionUID = 8599023660624054011L;

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    @OneToOne(mappedBy = "project")
    private NursRecord record;
}
