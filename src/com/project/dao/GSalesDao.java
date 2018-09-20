package com.project.dao;

import com.project.entity.GSales;
import com.project.entity.Goods;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GSalesDao {
    boolean insert(GSales gSales);
    boolean update(GSales gSales);
    boolean delete(int id);
    GSales findById(int id);
    List<GSales> findByGid(int gid);
    List<GSales> findBySid(int sid);
    List<GSales> findByDate(Date date);
    List<GSales> findAll();
}
