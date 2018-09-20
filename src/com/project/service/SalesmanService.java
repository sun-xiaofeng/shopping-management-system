package com.project.service;

import com.project.dao.DaoFactory;
import com.project.dao.SalesmanDao;
import com.project.entity.Salesman;
import com.project.exception.SalesmanServiceException;

import java.util.List;

public class SalesmanService {
    private SalesmanDao salesmanDao;

    public SalesmanService() {
        salesmanDao = DaoFactory.getSalesmanDao();
    }

    public void addSalesman(String name, String password) throws SalesmanServiceException {
        if (salesmanDao.findByName(name) != null) {
            throw new SalesmanServiceException("用户名已存在！");
        }
        Salesman salesman = new Salesman();
        salesman.setSname(name);
        salesman.setSpassword(password);

        salesmanDao.insert(salesman);
    }

    public void updateSalesman(int sid, String sname, String spassword) throws SalesmanServiceException {
        Salesman salesman = salesmanDao.findById(sid);
        if (salesman == null) {
            throw new SalesmanServiceException("编辑售货员失败，未找到售货员");
        }
        salesman.setSname(sname);
        salesman.setSpassword(spassword);
        salesmanDao.update(salesman);
    }

    public void deleteById(int id) throws SalesmanServiceException {
        if (!salesmanDao.delete(id)) {
            throw new SalesmanServiceException("删除售货员失败，未找到售货员");
        }
    }


//    public void deleteSalesman(String name) throws SalesmanServiceException {
//        if (salesmanDao.deleteByName(name)) {
//            throw new SalesmanServiceException("删除售货员失败，未找到售货员");
//        }
//    }

    public List<Salesman> getAllSalesman() {
        return salesmanDao.findAll();
    }

    public Salesman findById(int id) { return salesmanDao.findById(id);}

    public Salesman findByName(String name) { return salesmanDao.findByName(name); }

    public List<Salesman> findByNameContains(String name) {
        return salesmanDao.findByNameContains(name);
    }

    public boolean validatePassword(String username, String password) {
        Salesman salesman = salesmanDao.findByName(username);
        return salesman != null && salesman.getSpassword().equals(password);
    }

}
