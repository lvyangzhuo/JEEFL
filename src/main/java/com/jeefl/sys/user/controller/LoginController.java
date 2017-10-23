package com.jeefl.sys.user.controller;

import com.jeefl.common.json.AjaxJson;
import com.jeefl.sys.user.domain.UserEntity;
import com.jeefl.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyz
 * @date 2017-10-17
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public AjaxJson login(UserEntity user){
        UserEntity u = userService.checkUserExits(user);
        AjaxJson j = new AjaxJson();
        if(u == null){
            j.setMsg("账号不存在");
            j.setSuccess(false);
        }
        j.setMsg("登录成功");
        j.setSuccess(true);
        return j;
    }

}
