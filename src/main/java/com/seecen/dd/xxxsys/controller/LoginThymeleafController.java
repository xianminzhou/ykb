package com.seecen.dd.xxxsys.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.seecen.dd.xxxsys.service.YuserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * 修改密码
 * 生成验证
 */
@Controller
@RequestMapping(value = "/kapt")
public class LoginThymeleafController {

    @Autowired
    private DefaultKaptcha captchaProducer;

    /**
     * 获取验证码 的 请求路径
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @Autowired
    private YuserService yuserService;

    /**
     * 验证的方法
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    @ResponseBody
    public int imgvrifyControllerDefaultKaptcha(String phonenumber, String vrifyCode, HttpServletRequest httpServletRequest){
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+vrifyCode);

        if (captchaId.equals(vrifyCode)) {//验证码  验证成功
            return yuserService.selectByphonenumber(phonenumber);
        } else {//失败
          return 3;
        }
    }



}
