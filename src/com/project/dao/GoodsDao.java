package com.project.dao;

import com.project.entity.Goods;

import java.util.List;

public interface GoodsDao {
    boolean insert(Goods goods);
    boolean update(Goods goods);
    boolean delete(int id);
    boolean deleteByName(String name);
    Goods findById(int id);
    Goods findByName(String name);
    List<Goods> findAll();
    List<Goods> findAllOrderByPriceAsc();
    List<Goods> findAllOrderByQuantityAsc();
    List<Goods> findByNameContains(String name);
}
