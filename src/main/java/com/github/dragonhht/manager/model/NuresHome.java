package com.github.dragonhht.manager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 养老院信息表.
 * User: huang
 * Date: 2018-10-11
 */
@Entity
@Data
public class NuresHome implements Serializable {

    private static final long serialVersionUID = 3955658250696367395L;
    @Id
    @GeneratedValue
    private int id;
    /** 养老院名. */
    private String name;
    /** 详细介绍. */
    private String introduction;
    /** 入住条件. */
    private String conditions;

}
