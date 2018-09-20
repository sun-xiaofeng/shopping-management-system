package com.project.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.project.entity.Salesman;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class SalesmanDaoImpl implements SalesmanDao {

    private QueryRunner qr = new TxQueryRunner();

    @Override
    public boolean insert(Salesman s) {
        String sql = "INSERT INTO Salesman VALUES (NULL, ?, ?)";
        Object[] params = {s.getSname(), s.getSpassword()};
        try {
            return qr.update(sql, params) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Salesman s) {
        String sql = "UPDATE Salesman SET sname = ?, spassword = ? WHERE sid = ?";
        Object[] params = {s.getSname(), s.getSpassword(), s.getSid()};
        try {
            return qr.update(sql, params) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Salesman WHERE sid = ?";
        try {
            return qr.update(sql, id) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteByName(String name) {
        String sql = "DELETE FROM Salesman WHERE sname = ?";
        try {
            return qr.update(sql, name) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Salesman findById(int id) {
        String sql = "SELECT * FROM Salesman WHERE sid = ?";
        try {
            return qr.query(sql, new BeanHandler<>(Salesman.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Salesman findByName(String name) {
        String sql = "SELECT * FROM Salesman WHERE sname = ?";
        try {
            return qr.query(sql, new BeanHandler<>(Salesman.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Salesman> findAll() {
        String sql = "SELECT * FROM mydb.Salesman ORDER BY sid";
        try {
            return qr.query(sql, new BeanListHandler<>(Salesman.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Salesman> findByNameContains(String name) {
        String sql = "SELECT * FROM Salesman WHERE sname LIKE ?";
        try {
            return qr.query(sql, new BeanListHandler<>(Salesman.class), "%"+ name +"%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
