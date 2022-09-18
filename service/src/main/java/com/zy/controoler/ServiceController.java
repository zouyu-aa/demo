package com.zy.controoler;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import com.zy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RefreshScope
public class ServiceController {

    @Value("${user.password}")
    private String password;

    @Autowired
    private OrderService orderService;

    
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
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

    @RequestMapping(value = "/rpc", method = RequestMethod.POST)
    @ResponseBody
    public String rpc(@RequestBody  @Valid User user, BindingResult bindingResult) {
        log.info("密码========={}",  password);
        StringBuffer sb = new StringBuffer();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        log.info("参数校验结果=========={}", JSONObject.toJSONString(allErrors));
        if(!CollectionUtils.isEmpty(allErrors)) {
            return allErrors.get(0).getDefaultMessage();
        }
        //return password;
        String test = orderService.test();
        return test;
    }


}
