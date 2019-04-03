package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.GoodDAO;
import com.qianfeng.fxmall.goods.mapper.GoodMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MyBatis的商品数据访问层
 *
 * 注意：
 * 异常在dao层不要捕获
 */
@Component
public class GoodDAOImpl implements GoodDAO {


    @Autowired
    private SqlSession session;

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) {
        GoodMapper mapper = session.getMapper(GoodMapper.class);
        List<WxbGood> goods = mapper.queryGoodsByPage(page, SystemConstantsUtils.Page.PAGE_SIZE);
        return goods;
    }

    @Override
    public void goodSava(WxbGood wxbGood) {

    }
}
