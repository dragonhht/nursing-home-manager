package com.github.dragonhht.manager.model;

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
public class Perssion implements Serializable {
    @Id
    private String perssion;
}
