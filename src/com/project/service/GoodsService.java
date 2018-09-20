package com.project.service;

import com.project.dao.DaoFactory;
import com.project.dao.GoodsDao;
import com.project.entity.Goods;
import com.project.exception.GoodsServiceException;

import java.math.BigDecimal;
import java.util.List;

public class GoodsService {
    private GoodsDao goodsDao;

    public GoodsService() {
        goodsDao = DaoFactory.getGoodsDao();
    }

    public void addGoods(String gname, BigDecimal gprice, int gnum) throws GoodsServiceException {
        if (goodsDao.findByName(gname) != null) {
            throw new GoodsServiceException("添加失败，存在同名商品");
        }
        Goods goods = new Goods();
        goods.setGname(gname);
        goods.setGprice(gprice);
        goods.setGnum(gnum);
        goodsDao.insert(goods);
    }

    public void updateGoods(int gid, String gname, BigDecimal gprice, int gnum) throws GoodsServiceException {
        Goods goods = goodsDao.findById(gid);
        if (goods == null) {
            throw new GoodsServiceException("编辑失败，未找到商品");
        }
        goods.setGname(gname);
        goods.setGprice(gprice);
        goods.setGnum(gnum);
        goodsDao.update(goods);
    }


    public void deleteGoods(int id) throws GoodsServiceException {
        if (!goodsDao.delete(id)) {
            throw new GoodsServiceException("删除商品失败，未找到商品");
        }
    }

    public Goods findById(int id) {
        return goodsDao.findById(id);
    }

    public List<Goods> getAllGoods() {
        return goodsDao.findAll();
    }

    public List<Goods> findGoodsOrderByQuantityAsc() {
        return goodsDao.findAllOrderByQuantityAsc();
    }

    public List<Goods> findGoodsOrderByPriceAsc() {
        return goodsDao.findAllOrderByPriceAsc();
    }

    public List<Goods> findByNameContains(String name) {
        return goodsDao.findByNameContains(name);
    }
}
