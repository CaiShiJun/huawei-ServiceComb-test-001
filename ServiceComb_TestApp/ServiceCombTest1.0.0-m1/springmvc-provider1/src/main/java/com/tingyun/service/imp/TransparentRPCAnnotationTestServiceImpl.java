package com.tingyun.service.imp;

import com.tingyun.common.api.ITransparentRPCTestService;
import com.tingyun.common.bean.UserInfo;
import org.apache.servicecomb.provider.pojo.RpcSchema;

@RpcSchema(schemaId = "transparentRPCAnnotationTest")
public class TransparentRPCAnnotationTestServiceImpl implements ITransparentRPCTestService {
    @Override
    public UserInfo fillInUserInfo(UserInfo userInfo) {
        System.out.println("TransparentRPCAnnotationTestServiceImpl"+userInfo);
        return userInfo;
    }

    @Override
    public String updateUsername(String username) {
        System.out.println("TransparentRPCAnnotationTestServiceImpl"+username);
        return username;
    }
}
