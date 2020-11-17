
package com.qdu.dao.impl;

import com.qdu.dao.MLoginDao;
import com.qdu.entity.Manager;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("MLoginDao")
public class MLoginDaoImpl implements MLoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Manager getOneByName(String uname) {
       
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("from Manager where aname=:username");
        query.setParameter("username", uname);
        Manager m = (Manager) query.uniqueResult(); 
        return m;
    }
    
  
    
     @Override
    public String getCurrentPwd() {
        
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("from Manager where aid=:aid");
        query.setParameter("aid", "A001");
        Manager m = (Manager) query.uniqueResult(); 
        
        return m.getApwd();
    }

//    @Override
//    public void update(String pwd) {
//
//       Query query = (Query) sessionFactory.getCurrentSession().createQuery("update Manager set apwd=:apwd where aid=:aid");
//        query.setParameter("apwd", pwd);
//        query.setParameter("aid", "A001");
//       
//        sessionFactory.getCurrentSession().getTransaction().commit(); //一定要提交事务，增删改需要在事务内执行
//       
//    }
    
    


 



}
