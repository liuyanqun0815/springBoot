package cn.abel.controller;

import cn.abel.bean.User;
import cn.abel.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/1/31
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public Object getUsers(@RequestBody User user){
        System.out.println(JSON.toJSON(user));
        return userService.getByMap(JSONObject.parseObject(JSONObject.toJSONString(user)));
    }
}
