package com.tingyun.service.imp;

import com.tingyun.common.api.ITransparentRPCTestService;
import com.tingyun.common.bean.UserInfo;

//使用xml配置
public class TransparentRPCXmlTestServiceImpl implements ITransparentRPCTestService {
    @Override
    public UserInfo fillInUserInfo(UserInfo userInfo) {
        System.out.println("TransparentRPCXmlTestServiceImpl"+userInfo);
        return userInfo;
    }

    @Override
    public String updateUsername(String username) {
        System.out.println("TransparentRPCXmlTestServiceImpl"+username);
        return username;
    }
}
