package com.github.dragonhht.manager.util;

import com.github.dragonhht.manager.params.Salt;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 密码工具.
 * User: huang
 * Date: 18-9-23
 */
public class PasswordUtil {
    private static PasswordUtil ourInstance = new PasswordUtil();

    public static PasswordUtil getInstance() {
        return ourInstance;
    }

    private PasswordUtil() {
    }

    public String encryption(String password) {
        Md5Hash hash = new Md5Hash(password, Salt.SALT);
        return hash.toString();
    }

}
