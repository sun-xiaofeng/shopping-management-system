package com.project.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.project.entity.GSales;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.*;

public class GSalesDaoImpl implements GSalesDao {
    private QueryRunner qr = new TxQueryRunner();

    @Override
    public boolean insert(GSales gSales) {
        String sql = "INSERT INTO GSales VALUES (NULL, ?, ?, ?, ?)";
        Object[] params = {gSales.getGid(), gSales.getSid(), new java.sql.Date(gSales.getSdate().getTime()), gSales.getSnum()};
        try {
            return qr.update(sql, params) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(GSales gs) {
        String sql = "UPDATE GSales SET gid = ?, sid = ?, sdate = ?, snum = ? WHERE gsid = ?";
        Object[] params = {gs.getGid(), gs.getSid(), new java.sql.Date(gs.getSdate().getTime()), gs.getSnum(), gs.getGsid()};
        try {
            return qr.update(sql, params) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM GSales WHERE gsid = ?";
        try {
            return qr.update(sql, id) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GSales findById(int id) {
        String sql = "SELECT * FROM GSales WHERE gsid = ?";
        try {
            return qr.query(sql, new BeanHandler<>(GSales.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GSales> findByGid(int gid) {
        String sql = "SELECT * FROM GSales WHERE gid = ?";
        try {
            return qr.query(sql, new BeanListHandler<>(GSales.class), gid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GSales> findBySid(int sid) {
        String sql = "SELECT * FROM GSales WHERE sid = ?";
        try {
            return qr.query(sql, new BeanListHandler<>(GSales.class), sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GSales> findByDate(java.util.Date date) {
        String sql = "SELECT GSales.gid, Goods.gname, Goods.gprice, Goods.gnum, sum(GSales.snum) AS gsnum " +
                "FROM GSales INNER JOIN Goods ON GSales.gid = Goods.gid WHERE sdate = ? GROUP BY gid";
        try {
            return qr.query(sql, new BeanListHandler<>(GSales.class), new java.sql.Date(date.getTime()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<GSales> findAll() {
        String sql = "SELECT * FROM GSales ORDER BY gsid";
        try {
            return qr.query(sql, new BeanListHandler<>(GSales.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
