package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.GoodDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodDAOImpl;
import com.qianfeng.fxmall.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDAO goodDAO;

    public List<WxbGood> queryGoodsByPage(Integer page){
        if(page<1){
            throw  new IndexOutOfBoundsException("页码不能小于1");
        }
        int index = (page-1) * SystemConstantsUtils.Page.PAGE_SIZE;
        List<WxbGood> goods = goodDAO.queryGoodsByPage(index);
        return goods;
    }

    @Override
    public void goodSava(WxbGood wxbGood) {

    }
}
