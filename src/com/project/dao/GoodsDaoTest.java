package com.project.dao;

import com.project.entity.Goods;
import org.junit.Test;

import java.math.BigDecimal;

public class GoodsDaoTest {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Test
    public void testInsert() {
        Goods g = new Goods();
        g.setGname("纯牛奶");
        g.setGprice(new BigDecimal("3.5"));
        g.setGnum(1000);
        boolean success = goodsDao.insert(g);
        System.out.println(success);
    }

    @Test
    public void testQuery() {
        Goods g = goodsDao.findById(1);
        System.out.println(g);
    }

    @Test
    public void testFindAll() {
        for (Goods g : goodsDao.findAll()) {
            System.out.println(g);
        }
    }

}
