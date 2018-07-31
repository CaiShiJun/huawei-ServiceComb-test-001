package com.tingyun.controller;

import com.github.javafaker.Faker;
import com.tingyun.common.api.IJaxrsTestService;
import com.tingyun.common.bean.UserInfo;
import io.servicecomb.provider.pojo.RpcReference;
import io.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/jaxrsTest")
public class JaxrsTestController {

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
        String resultUserName1 = restTemplate.postForObject("cse://springmvc-provider1/jaxrsTest/updateUsername", userInfo.getUserName(), String.class);
        //Object - Object
        UserInfo resultUserInfo1 = restTemplate.postForObject("cse://springmvc-provider1/jaxrsTest/fillInUserInfo", userInfo, UserInfo.class);

        System.out.println("--------------------JaxrsTestController-----------------------");
        System.out.println(resultUserName1);
        System.out.println(resultUserInfo1);
        System.out.println("----------------------JaxrsTestController---------------------");

        return "success";
    }


    @RpcReference(microserviceName = "springmvc-provider1", schemaId = "jaxrsTest")
    private static IJaxrsTestService jaxrsTestService;

    @ResponseBody
    @RequestMapping("/testRpcReference")
    public String testRpcReference(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(Faker.instance().name().name());
        userInfo.setUserId(Faker.instance().idNumber().hashCode());
        userInfo.setUserPassword(Faker.instance().book().author());

        //String - String
        String resultUserName1 = jaxrsTestService.updateUsername(userInfo.getUserName());
        //Object - Object
        UserInfo resultUserInfo1 = jaxrsTestService.fillInUserInfo(userInfo);

        System.out.println("------------------JaxrsTestController-------------------------");
        System.out.println(resultUserName1);
        System.out.println(resultUserInfo1);
        System.out.println("-----------------JaxrsTestController--------------------------");

        return "success";
    }







}
