package com.stx.controller;

import com.stx.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
/*
* 使用注解方式，定义了一个控制类。同时定义方法的访问路径。
* 方法中使用了HttpServletRequest类型，并通过该对象的getParameter()方法获取指定参数。
* 打印。
* 最后返回一个名为success的视图，spring mvc会通过视图解析器在“/WEB-INF/jsp/”路径下寻找success.jsp文件。
*
* */
//标注一个注解类。
@Controller
public class UserController {
//    把类方法标注成一个可以直接只使用的url访问地址，
//    @RequestMapping(value = "/selectUser")
    /*
    public String selectUser(HttpServletRequest request){
    一、这个方法是从前端请求从接受参数。方法里面的名字对应着前端的变量。
        String id = request.getParameter("id");
        System.out.println("id="+id);
        return "success";
    }
    */

 /*
    //二、基本数据类型的绑定。
    public String selectUser(Integer id){
        System.out.println("id=aa"+id);
        return "success";
    }*/

//    三、当前端发送的 参数 名称和后端 形参 名称不一样的时候，数据无法绑定，
//    我们可以利用@RequestParam（value）间接进行数据绑定。
    /*
    * 效果：去掉@RequestParam（value）就会user_id=null。
    * 不去掉，user_id=1。
    * public String selectUser(@RequestParam(value = "user_id") Integer id){
        System.out.println("user_id="+id);
        return "success";
    }
    *
    *  */
    /*
    * 这个处理器适配器里面的处理器。处理结果：跳转到注册页面。
    * */
    @RequestMapping("/toRegister")
   public String toRegister(){
       return "register";
   }
   /*
   * 前一个适配器处理器跳转到了，注册页面，注册页面的action跳转到这个方法里面，把数据也提交过来了。
   * 测试：前端name属性要与User类里面的属性字段一致否则接收不到，他们有着对应的名称所以能接收到。
   * */
   @RequestMapping("/registerUser")
    public String registerUser(User user){
        String username=user.getUsername();
        Integer password=user.getPassword();
       System.out.println("username="+username);
       System.out.println("password="+password);
        return "success";
   }
}
