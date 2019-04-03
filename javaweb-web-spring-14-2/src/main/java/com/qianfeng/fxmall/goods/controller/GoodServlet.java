package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.mybatis.SpringUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodServlet extends HttpServlet {

    private GoodService goodService  = SpringUtils.getGoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        pageStr = pageStr == null?"1":pageStr;
        List<WxbGood> goodList = goodService.queryGoodsByPage(Integer.parseInt(pageStr));
        req.setAttribute("goodList",goodList);
        req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
    }


//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
//    }
//
//    @Autowired
//    private GoodService goodService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
