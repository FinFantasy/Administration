package com.system.realm;

import com.system.po.Role;
import com.system.po.Userlogin;
import com.system.service.RoleService;
import com.system.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm {

    @Resource(name = "userLoginServiceImpl")
    private UserLoginService userLoginService;

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);

        Role role = null;

        try {
            Userlogin userlogin = userLoginService.findByName(username);
            role = roleService.findById(userlogin.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if (role != null) {
            r.add(role.getRolename());
            info.setRoles(r);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();

        Userlogin userlogin = null;
        try {
            userlogin = userLoginService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userlogin == null) {
            throw new UnknownAccountException();
        }

        String password = userlogin.getPassword();

        AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());

        return info;
    }

    //一般情况下，用户正常退出和非正常退出（如关闭浏览器）都会自动清空缓存
    //但有时需要手动清除缓存，如修改用户权限，本项目未使用此方法
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
