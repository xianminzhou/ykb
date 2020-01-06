package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.Yuser;
import com.seecen.dd.xxxsys.service.YuserService;
import com.seecen.dd.xxxsys.utils.RequestUtils;
import com.seecen.dd.xxxsys.utils.SendMessageUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping(value = "/auth")
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login-page";
    }

    /**
     * 个人中心
     * @return
     */
    @RequestMapping(value = "/userIndex", method = RequestMethod.GET)
    public String userindex() {
        return "user/index";
    }

    /**
     * 个人信息修改
     * @param yuser
     * @return
     */
    @RequestMapping("/userUpdateByuserId")
    @ResponseBody
    public int userUpdateByuserId(Yuser yuser){
        return yuserService.updateByPhonenumer(yuser);
    }

    //被踢出后跳转的页面
    @RequestMapping(value = "/kickout", method = RequestMethod.GET)
    public String kickOut() {
        return "kickout";
    }


    /**
     * 显示注册页面
     * @return
     */
    @RequestMapping(value ="/register",method = RequestMethod.GET)
    public String register(){
        return "register-page";
    }
    /**
     * 修改密码页面1
     * @return
     * //    @RequiresPermissions("user")
     * //    @RequiresRoles(value = {"管理员"})
     */
    @RequestMapping(value = "/ykbchange",method = RequestMethod.GET)
    public String ykbchange(){
        return "change-page";
    }
    /**
     * 修改密码页面2
     * @return
     */
    @RequestMapping("/ykbreset")
    public String ykbreset(String phonenumber, Model model){
        model.addAttribute("phonenumber",phonenumber);
        System.out.println(phonenumber);
        return "reset-page";
    }

    /**
     * 登录页面
     * @param phonenumber
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLogin(String phonenumber, String password, HttpServletRequest request) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(phonenumber, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
//            SysUser user = (SysUser) subject.getPrincipal();
            Yuser yuser = (Yuser) subject.getPrincipal();

        } catch (DisabledAccountException e) {
            request.setAttribute("msg", "账户已被禁用");
            return "login-page";
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户名或密码错误");
            return "login-page";
        }
        // 执行到这里说明用户已登录成功
        return "redirect:/auth/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String loginSuccessMessage(HttpSession session) {
        String username = "未登录";
        Yuser currentLoginUser = RequestUtils.currentLoginUser();

        if (currentLoginUser != null && StringUtils.isNotEmpty(currentLoginUser.getUserName())) {
            username = currentLoginUser.getPhonenumber();
        } else {
            return "redirect:/auth/login";
        }
        session.setAttribute("yuser", currentLoginUser);
        return "index";
    }


    @Autowired
    private YuserService yuserService;

    /**
     * 检查用户名是否相同
     * @param userName
     * @return
     */
    @RequestMapping(value = "/VerifyUsername",method = RequestMethod.POST)
    @ResponseBody
    public int VerifyUsername(String userName){
        System.out.println(userName);
        return yuserService.selectByuserName(userName);
    }

    /**
     * 生成随机数
     * @param num 位数
     * @return
     */
    public static String createRandomNum(int num){
        String randomNumStr = "";
        for(int i = 0; i < num;i ++){
            int randomNum = (int)(Math.random() * 10);
            randomNumStr += randomNum;
        }
        return randomNumStr;
    }

    /**
     * 发送短信  将验证码存入redis中
     */
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 验证手机号是否被注册
     * 发送短信
     * @param phonenumber
     * @return
     */
    @RequestMapping(value = "/VerifyPhonenumber",method = RequestMethod.POST)
    @ResponseBody
    public int VerifyPhonenumber(String phonenumber){
        /**
         * 手机号没有被注册
         * 执行发送短信
         *  2.短信已发送
         *  1.该账户已被注册
         *  3.
         */
        if (yuserService.selectByphonenumber(phonenumber) != 1){
            /**
             * 中国网建 SMS短信
             */
                int timeout = 1;
                String code = createRandomNum(6);
                Integer resultCode = SendMessageUtil.send("zxm1","d41d8cd98f00b204e980",phonenumber,"尊敬的用户，您好，您正在注册优客宝，您的验证码为："+code+"，请于"+timeout+"分钟内正确输入，如非本人操作，请忽略此短信。");
                if (resultCode>0){
                    //手机验证码发送成功。验证码存入Redis缓存
                    redisTemplate.opsForValue().set(phonenumber,code);
                    redisTemplate.expire(phonenumber,timeout, TimeUnit.MINUTES);//失效时间
                }
                System.out.println("已发送至："+phonenumber+"，验证码："+redisTemplate.opsForValue().get(phonenumber));
                System.out.println(SendMessageUtil.getMessage(resultCode));
            return 2;
        }else {
            return 1;
        }
    }

    /**
     * 先判断验证码是否正确
     * 注册功能
     * @return
     */
    @RequestMapping(value = "/ykbRegistration",method = RequestMethod.POST)
    @ResponseBody
    public int ykbRegistration(Yuser yuser){
        String salt = redisTemplate.opsForValue().get(yuser.getPhonenumber())+"";//从redis中取出验证码
        System.out.println("通过get(Object key)方法获取set(k,v)方法新增的字符串值:"+
                salt);
        if (salt.equals(yuser.getSaltValue())){//验证验证码
            String Md5String = new Md5Hash(yuser.getPassword()).toString();
            ByteSource credentsaltRondom = ByteSource.Util.bytes(yuser.getSaltValue());
            Md5String = new Md5Hash(yuser.getPassword(),credentsaltRondom,3).toString();//加密三次
            yuser.setPassword(Md5String);
            System.out.println("随机加盐后md5:" + Md5String);
            return yuserService.insertYuser(yuser);
        }else {//验证码输入错误
            return 2;
        }
    }

    /**
     * 发送修改密码验证
     * @param phonenumber
     * @return
     */
    @RequestMapping(value = "/updateByPhonenumber",method = RequestMethod.POST)
    @ResponseBody
    public int updateByPhonenumber(String phonenumber){
        /**
         * 中国网建 SMS短信
         */
        int timeout = 1;
        String code = createRandomNum(6);
        Integer resultCode = SendMessageUtil.send("pengdaya","d41d8cd98f00b204e980",phonenumber,"尊敬的用户，您好，您正在注册优客宝，您的验证码为："+code+"，请于"+timeout+"分钟内正确输入，如非本人操作，请忽略此短信。");
        if (resultCode>0){
            //手机验证码发送成功。验证码存入Redis缓存
            redisTemplate.opsForValue().set(phonenumber,code);
            redisTemplate.expire(phonenumber,timeout, TimeUnit.MINUTES);//失效时间
            return 1;
        }
        System.out.println("已发送至："+phonenumber+"，验证码："+redisTemplate.opsForValue().get(phonenumber));
        System.out.println(SendMessageUtil.getMessage(resultCode));
        return 0;
    }

    /**
     * 修改密码
     * @param yuser
     * @return
     */
    @RequestMapping(value = "/ykbupdateByPhonenumber",method = RequestMethod.POST)
    @ResponseBody
    public int ykbupdateByPhonenumber(Yuser yuser){
        String salt = redisTemplate.opsForValue().get(yuser.getPhonenumber())+"";//从redis中取出验证码
        System.out.println("通过get(Object key)方法获取set(k,v)方法新增的字符串值:"+ salt);
        if (salt.equals(yuser.getSaltValue())){//验证验证码
            String Md5String = new Md5Hash(yuser.getPassword()).toString();
            ByteSource credentsaltRondom = ByteSource.Util.bytes(yuser.getSaltValue());
            Md5String = new Md5Hash(yuser.getPassword(),credentsaltRondom,3).toString();//加密三次
            yuser.setPassword(Md5String);
            System.out.println("随机加盐后md5:" + Md5String);
            return yuserService.updateByPhonenumer(yuser);
        }else {//验证码输入错误
            return 2;
        }
    }
}
