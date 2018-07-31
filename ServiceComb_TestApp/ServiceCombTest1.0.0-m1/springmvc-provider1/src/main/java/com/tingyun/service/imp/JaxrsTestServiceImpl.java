package com.tingyun.service.imp;

import com.tingyun.common.api.IJaxrsTestService;
import com.tingyun.common.bean.UserInfo;
import org.apache.servicecomb.provider.rest.common.RestSchema;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestSchema(schemaId = "jaxrsTest")
@Path("/jaxrsTest")
@Produces(MediaType.APPLICATION_JSON)
public class JaxrsTestServiceImpl implements IJaxrsTestService {

    @Path("/fillInUserInfo")
    @POST
    @Override
    public UserInfo fillInUserInfo(UserInfo userInfo) {
        System.out.println("JaxrsTestServiceImpl"+userInfo);
        return userInfo;
    }

    @Path("/updateUsername")
    @POST
    @Override
    public String updateUsername(String username) {
        System.out.println("JaxrsTestServiceImpl"+username);
        return username;
    }
}
