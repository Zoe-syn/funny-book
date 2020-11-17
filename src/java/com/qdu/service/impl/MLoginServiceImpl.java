
package com.qdu.service.impl;


import com.qdu.dao.MLoginDao;
import com.qdu.entity.Manager;
import com.qdu.service.MLoginService;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class  MLoginServiceImpl implements MLoginService {

    @Resource
    private MLoginDao mLoginDao;


    @Override
    public Manager validateLogin(String name, String pwd) {
        Manager m =  mLoginDao.getOneByName(name);
        if (null != m && pwd.equals(m.getApwd())) {
            return m;
        }
        return null;
    }

    @Override
    public Boolean checkPwd(String pwd) {
       String a= mLoginDao.getCurrentPwd();
       if(a.equals(pwd)){
           return true;
       }else{
           return false;
       }
    }

//    @Override
//    public void updatemm(String pwd) {
//        mLoginDao.update(pwd);
//    }

    
}

