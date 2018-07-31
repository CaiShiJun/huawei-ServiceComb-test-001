package com.tingyun.controller;

import com.github.javafaker.Faker;
import com.tingyun.common.api.ITransparentRPCTestService;
import com.tingyun.common.bean.UserInfo;
import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/transparentRPCAnnotationTest")
public class TransparentRPCAnnotationTestController {

    @RpcReference(microserviceName = "springmvc-provider1", schemaId = "transparentRPCAnnotationTest")
    private static ITransparentRPCTestService transparentRPCTestService;

    @ResponseBody
    @RequestMapping("/testRpcReference")
    public String testRpcReference(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(Faker.instance().name().name());
        userInfo.setUserId(Faker.instance().idNumber().hashCode());
        userInfo.setUserPassword(Faker.instance().book().author());

        //String - String
        String resultUserName1 = transparentRPCTestService.updateUsername(userInfo.getUserName());
        //Object - Object
        UserInfo resultUserInfo1 = transparentRPCTestService.fillInUserInfo(userInfo);

        System.out.println("-------------------TransparentRPCAnnotationTestController------------------------");
        System.out.println(resultUserName1);
        System.out.println(resultUserInfo1);
        System.out.println("-------------------TransparentRPCAnnotationTestController------------------------");

        return "success";
    }

    @ResponseBody
    @RequestMapping("/testXmlBeanUtils")
    public String testXmlBeanUtils(){

        ITransparentRPCTestService transparentRPCTestService = BeanUtils.getBean("transparentRPCAnnotationXmlBeanUtils");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(Faker.instance().name().name());
        userInfo.setUserId(Faker.instance().idNumber().hashCode());
        userInfo.setUserPassword(Faker.instance().book().author());

        //String - String
        String resultUserName1 = transparentRPCTestService.updateUsername(userInfo.getUserName());
        //Object - Object
        UserInfo resultUserInfo1 = transparentRPCTestService.fillInUserInfo(userInfo);

        System.out.println("------------------TransparentRPCAnnotationTestController-------------------------");
        System.out.println(resultUserName1);
        System.out.println(resultUserInfo1);
        System.out.println("--------------------TransparentRPCAnnotationTestController-----------------------");

        return "success";

    }


}
