package com.tingyun.common.api;

import com.tingyun.common.bean.UserInfo;

public interface ITransparentRPCTestService {

    public UserInfo fillInUserInfo(UserInfo userInfo);

    public String updateUsername(String username);

}
