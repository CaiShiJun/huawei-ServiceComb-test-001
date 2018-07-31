package com.tingyun.controller;

import com.github.javafaker.Faker;
import com.tingyun.common.api.ISpringMVCTestService;
import com.tingyun.common.bean.UserInfo;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/springMVCTest")
public class SpringMVCTestController {

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    @ResponseBody
    @RequestMapping("/testRestTemplatePost")
    public String testRestTemplatePost(){

        // Post 请求测试。
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(Faker.instance().name().name());
        userInfo.setUserId(Faker.instance().idNumber().hashCode());
        userInfo.setUserPassword(Faker.instance().book().author());

        //String - String
        String resultUserName1 = restTemplate.postForObject("cse://springmvc-provider1/springMVCTest/updateUsername?username="+userInfo.getUserName(), null, String.class);
        //Object - Object
        UserInfo resultUserInfo1 = restTemplate.postForObject("cse://springmvc-provider1/springMVCTest/fillInUserInfo", userInfo, UserInfo.class);

        System.out.println("-----------------SpringMVCTestController--------------------------");
        System.out.println(resultUserName1);
        System.out.println(resultUserInfo1);
        System.out.println("--------------------SpringMVCTestController-----------------------");

        return "success";
    }

    @RpcReference(microserviceName = "springmvc-provider1", schemaId = "springMVCTest")
    private static ISpringMVCTestService SpringMVCTestService;

    @ResponseBody
    @RequestMapping("/testRpcReference")
    public String testRpcReference(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(Faker.instance().name().name());
        userInfo.setUserId(Faker.instance().idNumber().hashCode());
        userInfo.setUserPassword(Faker.instance().book().author());

        //String - String
        String resultUserName1 = SpringMVCTestService.updateUsername(userInfo.getUserName());
        //Object - Object
        UserInfo resultUserInfo1 = SpringMVCTestService.fillInUserInfo(userInfo);

        System.out.println("-----------------SpringMVCTestController--------------------------");
        System.out.println(resultUserName1);
        System.out.println(resultUserInfo1);
        System.out.println("-------------------SpringMVCTestController------------------------");

        return "success";
    }

}
