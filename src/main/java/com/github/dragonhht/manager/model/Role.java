package com.github.dragonhht.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 角色表.
 * User: huang
 * Date: 18-9-22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 5020634880144766316L;

    @Id
    private String role;
}
