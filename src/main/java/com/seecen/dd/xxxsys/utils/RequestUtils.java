package com.seecen.dd.xxxsys.utils;

import com.seecen.dd.xxxsys.dao.domain.Yuser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtils {

    private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 获取当前登录的用户，若用户未登录，则返回未登录 json
     *
     * @return
     */
    public static Yuser currentLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            Object principal = subject.getPrincipals().getPrimaryPrincipal();
            if (principal instanceof Yuser) {
                return (Yuser) principal;
            }
        }
        return null;
    }
}
