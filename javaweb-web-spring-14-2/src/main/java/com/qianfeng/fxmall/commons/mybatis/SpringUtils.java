package com.qianfeng.fxmall.commons.mybatis;

import com.qianfeng.fxmall.goods.service.GoodService;
import com.qianfeng.fxmall.goods.service.Impl.GoodServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

    public static GoodService getGoodService(){
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        GoodServiceImpl bean = xmlApplicationContext.getBean(GoodServiceImpl.class);
        return bean;
    }
}
