package com.project.dao;

import com.project.entity.Salesman;


import java.util.List;

public interface SalesmanDao {
    boolean insert(Salesman salesman);
    boolean update(Salesman salesman);
    boolean delete(int id);
    boolean deleteByName(String name);
    Salesman findById(int id);
    Salesman findByName(String name);
    List<Salesman> findAll();
    List<Salesman> findByNameContains(String name);
}
