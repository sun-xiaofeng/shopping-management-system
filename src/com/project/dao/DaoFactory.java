package com.project.dao;


import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    private static Properties properties;
    static {
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static GoodsDao getGoodsDao() {
        String daoClassName = properties.getProperty("com.project.dao.GoodsDao");

        try {
            Class clazz = Class.forName(daoClassName);
            return (GoodsDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static GSalesDao getGSalesDao() {
        String daoClassName = properties.getProperty("com.project.dao.GSalesDao");
        try {
            Class clazz = Class.forName(daoClassName);
            return (GSalesDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SalesmanDao getSalesmanDao() {
        String daoClassName = properties.getProperty("com.project.dao.SalesmanDao");
        try {
            Class clazz = Class.forName(daoClassName);
            return (SalesmanDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
