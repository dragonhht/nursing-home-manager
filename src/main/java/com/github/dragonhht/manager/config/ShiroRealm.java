package com.github.dragonhht.manager.config;

import com.github.dragonhht.manager.params.Salt;
import com.github.dragonhht.manager.repository.BaseRoleRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private BaseRoleRepository roleRepository;

    /**
     * 授权.
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long id = (Long) principals.getPrimaryPrincipal();
        Set<String> roles = getRolesById(id);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        // TODO 未添加权限
        return info;
    }

    /**
     * 认证.
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userId = (String) token.getPrincipal();
        long id = Long.parseLong(userId);
        String password = getPasswordById(id);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(String.valueOf(id), password, "shiroRealm");
        info.setCredentialsSalt(ByteSource.Util.bytes(Salt.SALT));
        return info;
    }

    private String getPasswordById(long id) {
        return roleRepository.findPasswordById(id);
    }

    private Set<String> getRolesById(long id) {
        return roleRepository.findRolesById(id);
    }
}
