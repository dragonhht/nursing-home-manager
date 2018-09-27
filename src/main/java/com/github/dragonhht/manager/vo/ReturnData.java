package com.github.dragonhht.manager.vo;

import com.github.dragonhht.manager.params.Code;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@Data
@AllArgsConstructor
public class ReturnData<T> implements Serializable {

    private static final long serialVersionUID = -7633763763750450945L;
    private int code;
    private T data;
}
