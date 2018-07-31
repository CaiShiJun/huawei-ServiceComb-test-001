package com.tingyun.start.main;

import io.servicecomb.foundation.common.utils.BeanUtils;
import io.servicecomb.foundation.common.utils.Log4jUtils;

public class ProviderStart {
    public static void main(String[] args) throws Exception {
        //初始化日志， 加载Bean(包括它们的参数), 以及注册Service, 更多信息可以参见文档 : http://servicecomb.incubator.apache.org/cn/users/application-boot-process/
        Log4jUtils.init();
        BeanUtils.init();

    }
}
