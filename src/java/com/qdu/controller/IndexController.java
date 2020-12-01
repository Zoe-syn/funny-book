package com.qdu.controller;

import com.qdu.entity.ShoppingChe;
import com.qdu.entity.Notice;
import com.qdu.entity.Merchandises;
import com.qdu.entity.PurchaseOrder;
import com.qdu.entity.Subscribers;
import com.qdu.service.ShoppingCheService;
import com.qdu.service.MnoticService;
import com.qdu.service.MerchandiseService;
import com.qdu.service.PurchaseOrderService;
import com.qdu.service.SearchService;
import com.qdu.service.SubscriberInfoService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private MerchandiseService productService;
    @Autowired
    private ShoppingCheService cartService;

    @Autowired
    private MnoticService mnoticService;
    @Autowired
    private SearchService sousuoService;
    
      @Autowired
    private PurchaseOrderService purchaseOrderService;
 
    @Autowired
    private SubscriberInfoService userInfoService;
 


    @RequestMapping({"/index", "/"})

    public String index(HttpServletRequest request, HttpServletResponse response) {
        List<Merchandises> list1 = productService.getDigitalList();
        List<Merchandises> list2 = productService.getBookList();
        List<Merchandises> list3 = productService.getMpbileMerchandisesList();
        List<Notice> list4 = mnoticService.getNoticeList();

        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        return "index";
    }

    @RequestMapping("/sousuo")
    public String Sousuo() {

        return "sousuo";
    }

    @RequestMapping("/detail")
    public String Detail() {
        return "detail";
    }

    @RequestMapping("/buy")
    public String BuyInformation() {
        return "BuyInformation";
    }

    @RequestMapping("/product")
    public String productInformation() {
        return "productInformation";
    }

    @RequestMapping("/to_product")
    public String to_product() {
        return "product_list";
    }

    @RequestMapping("/to_login")
    public String Login() {
        return "Login";
    }

    @RequestMapping("/to_cart")
    public String ShoppingChe(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Subscribers u = (Subscribers) session.getAttribute("user");
        List<ShoppingChe> list = cartService.getShoppingCheList(u.getUid());
        request.setAttribute("list", list);
        return "cart";
    }

    @RequestMapping("/fail")
    public String Fail() {
        return "fail";
    }

    @RequestMapping("/order")
    public String Order(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        return "order";
    }

     @RequestMapping("/login-1")
    public String loginindex() {
        return "login-1";
    }
    
    @RequestMapping("/welcome-1")
    public String to_welcome1() {
        return "welcome-1";
    }
  
    @RequestMapping("/404")
    public String to_404() {
        return "404";
    }
    @RequestMapping("/button")
    public String to_button() {
        return "button";
    }
   
    @RequestMapping("/editor")
    public String to_editor() {
        return "editor";
    }
    @RequestMapping("/form-step")
    public String to_formstep() {
        return "form-step";
    }
     @RequestMapping("/form")
    public String to_form() {
        return "form";
    }
     @RequestMapping("/icon-picker")
    public String to_iconpicker() {
        return "icon-picker";
    }
     @RequestMapping("/icon")
    public String to_icon() {
        return "icon";
    }
     @RequestMapping("/layer")
    public String to_layer() {
        return "layer";
    }
     @RequestMapping("/mindex")
    public String to_login1() {
        return "mindex";
    }
     
     @RequestMapping("/menu")
    public String to_menu() {
        return "menu";
    }
     @RequestMapping("/setting")
    public String to_setting() {
        return "setting";
    }
     @RequestMapping("/table-select")
    public String to_tableselect() {
        return "table-select";
    }
     @RequestMapping("/table")
    public String to_table() {
        return "table";
    }
     @RequestMapping("/upload")
    public String to_upload() {
        return "upload";
    }
     
    
    @RequestMapping("/user-setting")
    public String to_usersetting() {
        return "user-setting";
    }
    @RequestMapping("/user-password")
    public String to_userpassword() {
        return "user-password";
    }
    
     @RequestMapping("/pay")
    public String Pay() {
        return "pay";
    }
    @RequestMapping("/totalOrder")
    public String tOrder(HttpSession session) {
         PurchaseOrder order=new PurchaseOrder();
            Subscribers u = (Subscribers) session.getAttribute("user");
          
         List<PurchaseOrder> orderlist=purchaseOrderService.getPurchaseOrderListByCid(u.getUid());
            
            session.setAttribute("orderListByCid",orderlist);
        return "totalOrder";
    }

}
