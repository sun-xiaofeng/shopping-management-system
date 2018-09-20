package com.project.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.project.entity.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    private QueryRunner qr = new TxQueryRunner();

    public boolean insert(Goods g) {
        String sql = "INSERT INTO Goods VALUES (NULL, ?, ?, ?)";
        Object[] params = {g.getGname(), g.getGprice(), g.getGnum()};
        try {
            return qr.update(sql, params) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Goods g) {
        String sql = "UPDATE Goods SET gname = ?, gprice = ?, gnum = ? WHERE gid = ?";
        Object[] params = {g.getGname(), g.getGprice(), g.getGnum(), g.getGid()};
        try {
            return qr.update(sql, params) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Goods WHERE gid = ?";
        try {
            return qr.update(sql, id) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteByName(String name) {
        String sql = "DELETE FROM Goods WHERE gname = ?";
        try {
            return qr.update(sql, name) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Goods findById(int id) {
        String sql = "SELECT * FROM Goods WHERE gid = ?";
        try {
            return qr.query(sql, new BeanHandler<>(Goods.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Goods findByName(String name) {
        String sql = "SELECT * FROM Goods WHERE gname = ?";
        try {
            return qr.query(sql, new BeanHandler<>(Goods.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Goods> findAll() {
        String sql = "SELECT * FROM Goods ORDER BY gid";
        try {
            return qr.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> findAllOrderByPriceAsc() {
        String sql = "SELECT * FROM Goods ORDER BY gprice";
        try {
            return qr.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> findAllOrderByQuantityAsc() {
        String sql = "SELECT * FROM goods ORDER BY gnum";
        try {
            return qr.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> findByNameContains(String name) {
        String sql = "SELECT * FROM mydb.Goods WHERE gname LIKE ?";
        try {
            return qr.query(sql, new BeanListHandler<>(Goods.class), "%"+ name +"%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
