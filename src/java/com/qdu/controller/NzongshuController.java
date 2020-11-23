
package com.qdu.controller;

import com.qdu.service.MwelcomCountService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class NzongshuController {
    
    @Autowired
    MwelcomCountService mwelcomCountService;
    
    @RequestMapping("/sl")
    public String a(HttpSession session) {
        Long a=mwelcomCountService.getddsl();
        session.setAttribute("ddsll", a);
        
         Long b=mwelcomCountService.getspsl();
        session.setAttribute("spsll", b);
        
         Long c=mwelcomCountService.getyhsl();
        session.setAttribute("yhsll", c);
        
//         Long d=mwelcomCountService.getfwsl();
//         
//        session.setAttribute("fwsll", d);
        return "welcome-1";
    }
    
//    @PostMapping("/sps")
//    public String b(HttpSession session) {
//         Long b=mwelcomCountService.getspsl();
//        session.setAttribute("spsll", b);
//        return "welcome-1";
//        
//    }
//    
//    @PostMapping("/yhs")
//    public String c(HttpSession session) {
//        Long c=mwelcomCountService.getyhsl();
//        session.setAttribute("yhsll", c);
//        return "welcome-1";
//    }
    
}
