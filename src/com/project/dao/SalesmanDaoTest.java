package com.project.dao;

import com.project.entity.Salesman;
import org.junit.Test;

public class SalesmanDaoTest {

    private SalesmanDao salesmanDao = new SalesmanDaoImpl();
    @Test
    public void testInsert() {
        Salesman s = new Salesman();
        s.setSname("user1");
        s.setSpassword("1234");
        salesmanDao.insert(s);
    }
    @Test
    public void testFindAll() {
        for (Salesman s : salesmanDao.findAll()) {
            System.out.println(s);
        }
    }
}
