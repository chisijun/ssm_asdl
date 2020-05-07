package org.study.asdl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.entity.TokenModel;
import org.study.asdl.service.TokenManager;
import org.study.asdl.service.UserService;

import javax.annotation.Resource;

/**
 * @date    2020-04-26
 * @desc    用户登录拦截器
 */
@Controller
@RequestMapping("/login")
public class TokenController {

    @Resource
    private UserService userService;

    @Resource
    private TokenManager tokenManager;

    @ResponseBody
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public JsonResult login(@RequestParam String name, @RequestParam String password)throws Throwable{
        User user =  userService.login(name, password);
        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.get(user.getId());
        if (model == null) {
            model = tokenManager.createToken(user.getId());
        }
        return new JsonResult(true, "登录成功", model);
    }

    /**
     * 注销
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    public JsonResult logout(@CurrentUser User user) {
        tokenManager.deleteToken(user.getId());
        return  new JsonResult(true, "退出成功", "");
    }


}
