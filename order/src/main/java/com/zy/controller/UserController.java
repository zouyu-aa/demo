package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class UserController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestBody  @Valid User user, BindingResult bindingResult) {
        StringBuffer sb = new StringBuffer();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        log.info("参数校验结果=========={}", JSONObject.toJSONString(allErrors));
        if(!CollectionUtils.isEmpty(allErrors)) {
            return allErrors.get(0).getDefaultMessage();
        }
        return user.getName();
    }
}
