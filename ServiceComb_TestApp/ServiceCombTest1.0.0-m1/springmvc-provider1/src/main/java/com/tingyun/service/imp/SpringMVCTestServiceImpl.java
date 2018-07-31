package com.tingyun.service.imp;

import com.tingyun.common.api.ISpringMVCTestService;
import com.tingyun.common.bean.UserInfo;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.MediaType;

@RestSchema(schemaId = "springMVCTest")
@RequestMapping(path = "/springMVCTest", produces = MediaType.APPLICATION_JSON)
public class SpringMVCTestServiceImpl implements ISpringMVCTestService {

    @Override
    @RequestMapping(path = "/fillInUserInfo",method = RequestMethod.POST)
    public UserInfo fillInUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println("SpringMVCTestServiceImpl"+userInfo);
        return userInfo;
    }

    @Override
    @RequestMapping(path = "/updateUsername",method = RequestMethod.POST)
    public String updateUsername(@RequestParam(name = "username")String username) {
        System.out.println("SpringMVCTestServiceImpl"+username);
        return username;
    }


}
