package com.qdu.service;

import com.qdu.entity.Manager;

public interface MLoginService {

    public Manager validateLogin(String mname, String password);
//    public void updatemm(String pwd);
    public Boolean checkPwd(String pwd);
}
