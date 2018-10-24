package com.github.dragonhht.manager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Description.
 * User: huang
 * Date: 2018-10-24
 */
@Entity
@Data
public class WorkTable implements Serializable {
    private static final long serialVersionUID = 5020634880144766317L;

    @Id
    private Integer id;
    private String file;

}
