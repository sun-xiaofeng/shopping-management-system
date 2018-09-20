package com.project.dao;

import com.project.entity.GSales;
import org.junit.Test;

import java.util.Date;

public class GSalesDaoTest {
    @Test
    public void testFindByDate() {
        Date d = new Date();
        GSalesDao gsd = new GSalesDaoImpl();
        for (GSales gs : gsd.findByDate(d)) {
            System.out.println(gs);
        }
    }
}
