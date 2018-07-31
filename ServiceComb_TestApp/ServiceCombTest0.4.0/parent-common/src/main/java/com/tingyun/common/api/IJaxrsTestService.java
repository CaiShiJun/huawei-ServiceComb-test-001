package com.tingyun.common.api;

import com.tingyun.common.bean.UserInfo;

public interface IJaxrsTestService {

    public UserInfo fillInUserInfo(UserInfo userInfo);

    public String updateUsername(String username);

}
