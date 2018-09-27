package com.github.dragonhht.manager.util;

import com.github.dragonhht.manager.params.Code;
import com.github.dragonhht.manager.vo.ReturnData;

/**
 * 返回数据工具类.
 * User: huang
 * Date: 18-9-27
 */
public class ReturnDataUtils {

    public static <T> ReturnData<T> returnDate(Code code, T data) {
        return new ReturnData<>(code.getValue(), data);
    }

}
