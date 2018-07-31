package com.tingyun.start.sevlet;

import io.servicecomb.foundation.common.utils.BeanUtils;
import io.servicecomb.foundation.common.utils.Log4jUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/startServiceCombServlet")
public class StartServiceCombServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //初始化日志， 加载Bean(包括它们的参数), 以及注册Service, 更多信息可以参见文档 : http://servicecomb.incubator.apache.org/cn/users/application-boot-process/
        try {
            Log4jUtils.init();
            BeanUtils.init();

            resp.getWriter().write("StartServiceCombServlet初始化成功");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("StartServiceCombServlet初始化失败："+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
