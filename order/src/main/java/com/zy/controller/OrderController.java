package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RefreshScope
public class OrderController {

    @Value("${user.password}")
    private String password;

    @PostMapping(value = "/test")
    //@ResponseBody
    public String test(@RequestBody  @Valid User user, BindingResult bindingResult) {
        log.info("密码========={}",  password);
        StringBuffer sb = new StringBuffer();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        log.info("参数校验结果=========={}", JSONObject.toJSONString(allErrors));
        if(!CollectionUtils.isEmpty(allErrors)) {
            return allErrors.get(0).getDefaultMessage();
        }
        return password;
    }

    @RequestMapping(value = "/testA")
    //@ResponseBody
    public String testA() {
        log.info("密码========={}",  password);
        return "rpc调用成功";
    }
}
