package com.seecen.dd.xxxsys.secutity;

import com.seecen.dd.xxxsys.dao.domain.Yuser;
import com.seecen.dd.xxxsys.service.YroleService;
import com.seecen.dd.xxxsys.service.YuserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MyShiroRealm extends AuthorizingRealm {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    //如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
    @Autowired
    private YroleService roleService;
    @Autowired
    private YuserService userService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String phonenumer = token.getUsername();
        String password = String.valueOf(token.getPassword());
        Yuser user = new Yuser();
        user.setPhonenumber(phonenumer);
//        user.setPassword(password);
        // 从数据库获取对应用户名密码的用户
        Yuser sysUser = userService.getUser(user);
        System.out.println(sysUser);
        if (sysUser != null) {
            // 用户为禁用状态
            if (sysUser.getStatus() != 1) {
                throw new DisabledAccountException();
            }
            logger.info("---------------- Shiro 凭证认证成功 ----------------------");
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    sysUser, //用户名
                    sysUser.getPassword(), //密码sysUser.getPassword()  password
                    ByteSource.Util.bytes(sysUser.getSaltValue()),//salt=username+salt
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof Yuser) {
            Yuser sysUser = (Yuser) principal;
            System.out.println(sysUser);
            Set<String> roles = roleService.findRoleNameByUserId(sysUser.getRoleId());
            System.out.println(roles.iterator().next());
            authorizationInfo.addRoles(roles);

            Set<String> permissions = userService.findPermissionsByUserId(sysUser.getRoleId());
            System.out.println(permissions.iterator().next());
            authorizationInfo.addStringPermissions(permissions);
        }
        logger.info("---- 获取到以下权限 ----");
        logger.info(authorizationInfo.getStringPermissions().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }

}
