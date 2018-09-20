package com.project.service;

import cn.itcast.jdbc.JdbcUtils;
import com.project.dao.*;
import com.project.entity.GSales;
import com.project.entity.Goods;
import com.project.entity.Salesman;
import com.project.exception.GSalesServiceException;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class GSalesService {
    private GSalesDao gSalesDao;
    private GoodsDao goodsDao;
    private SalesmanDao salesmanDao;

    public GSalesService() {
        gSalesDao = DaoFactory.getGSalesDao();
        goodsDao = DaoFactory.getGoodsDao();
        salesmanDao = DaoFactory.getSalesmanDao();
    }

    public void addGSales(String sname, String gname, int snum) throws GSalesServiceException {
        Goods goods = goodsDao.findByName(gname);
        if (goods == null) {
            throw new GSalesServiceException("更新库存失败，找不到商品！");
        }
        if (goods.getGnum() < snum) {
            throw new GSalesServiceException("商品库存不足！");
        }
        Salesman salesman = salesmanDao.findByName(sname);
        if (salesman == null) {
            throw new GSalesServiceException("更新库存失败，找不到售货员！");
        }
        goods.setGnum(goods.getGnum() - snum);
        GSales gSales = new GSales();
        gSales.setGid(goods.getGid());
        gSales.setSid(salesman.getSid());
        gSales.setSdate(new Date());
        gSales.setSnum(snum);
        try {
            JdbcUtils.beginTransaction();
            goodsDao.update(goods);
            gSalesDao.insert(gSales);
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                throw new GSalesServiceException("更新库存失败，数据库错误！");
            }
            throw new GSalesServiceException("更新库存失败，数据库错误！");
        }
    }

    public List<GSales> findGoodsSoldByDate(Date date) {
        return gSalesDao.findByDate(date);
    }
}
