package com.tingyun.start;

import com.tingyun.controller.JaxrsTestController;
import com.tingyun.controller.SpringMVCTestController;
import com.tingyun.controller.TransparentRPCAnnotationTestController;
import com.tingyun.controller.TransparentRPCXmlTestController;
import io.servicecomb.foundation.common.utils.BeanUtils;
import io.servicecomb.foundation.common.utils.Log4jUtils;
import org.springframework.aop.ThrowsAdvice;

public class ConsumerStart {
    public static void main(String[] args) throws Exception {
        //初始化日志， 加载Bean(包括它们的参数), 以及注册Service, 更多信息可以参见文档 : http://servicecomb.incubator.apache.org/cn/users/application-boot-process/
        Log4jUtils.init();
        BeanUtils.init();

        SpringMVCTestController restTemplateController = new SpringMVCTestController();
        restTemplateController.testRestTemplatePost();
        restTemplateController.testRpcReference();

        JaxrsTestController jaxrsTestController = new JaxrsTestController();
        jaxrsTestController.testRestTemplatePost();
        jaxrsTestController.testRpcReference();

        TransparentRPCAnnotationTestController transparentRPCAnnotationTestController = new TransparentRPCAnnotationTestController();
        transparentRPCAnnotationTestController.testRpcReference();
        transparentRPCAnnotationTestController.testXmlBeanUtils();

        TransparentRPCXmlTestController transparentRPCXmlTestController = new TransparentRPCXmlTestController();
        transparentRPCXmlTestController.testRpcReference();
        transparentRPCXmlTestController.testXmlBeanUtils();
    }
}
