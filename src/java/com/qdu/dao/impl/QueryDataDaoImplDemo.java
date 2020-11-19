package com.qdu.dao.impl;

import com.qdu.dao.QueryDataDaoDemo;
import com.qdu.entity.Products;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QueryDataDaoImplDemo implements QueryDataDaoDemo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Products> getDataByCondition(String name, Integer price1, Integer price2) {
        String hql = "from Products where 1=1";

        if (name != null && !name.equals("")) {
            hql += " and pname like :n";
            //query.setParameter("n", "%" + name + "%");
        }
        if (price1 != null) {
            hql += " and pprice >:p1";
            //query.setParameter("p1", price1);
        }
        if (price2 != null) {
            hql += " and pprice <:p2";
            //query.setParameter("p2", price2);
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        if (name != null && !name.equals("")) {
            System.out.println("name:" + name);
            query.setParameter("n", "%" + name + "%");
        }
        if (price1 != null) {
            System.out.println("price:" + price1);
            query.setParameter("p1", new BigDecimal(price1));
        }
        if (price2 != null) {
            query.setParameter("p2", new BigDecimal(price2));
        }
        List<Products> list = query.list();
        return list;
    }
}
