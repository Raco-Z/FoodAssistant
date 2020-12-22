package com.foodAssistant.controller;


import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserAccountService infuser;

    //利用username在数据库查找，如果存在则检查密码
    //查询一个 where = username -> Useraccount : findUserByName()
    //查询所有 List<Useraccount> : findAll()
    //持久层接口IUserDao
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("level")String level, HttpServletResponse response) throws IOException {
        //验证方法执行和数据传输
        System.out.println("userLogin done");
        System.out.println("Username:"+username);
        System.out.println("Password:"+password);
        System.out.println("Level:"+level);
        //在数据库中检查用户是否合法
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (username.equals("root"))
        {
            if (password.equals("123123"))
            {
                //管理员账号唯一且不存在于数据库中
                UserAccount user = new UserAccount();
                user.setAccountId(0);
                user.setAccountName("root");
                user.setAccountPassword("123123");
                //将用户对象传到Model域中
                ModelAndView mv = new ModelAndView();
                mv.addObject("user",user);
                mv.setViewName("../../mypage");
                return mv;
            }
            else
            {
                //弹窗报错并返回至原网页
                out.println("<script>alert('管理员密码错误');history.go(-1);</script>");
                out.flush();
                out.close();
                return null;
            }
        }
        else if(infuser.findUserByName(username)==null)
        {
            //弹窗报错并返回至原网页
            out.println("<script>alert('用户名不存在');history.go(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        UserAccount user = infuser.findUserByName(username);
        if (user.getAccountName().equals(username) && user.getAccountPassword().equals(password))
        {
            //将用户对象传到Model域中,并用设置对应视图
            ModelAndView mv = new ModelAndView();
            mv.addObject("user",user);
            mv.setViewName("../../mypage");
            return mv;
        }
        else
        {
            //弹窗报错并返回至原网页
            out.println("<script>alert('用户名或密码错误');history.go(-1);</script>");
            out.flush();
            out.close();
        }
        return null;
    }

    //注册一个新用户，不允许用户名重复
    //插入一个 userAccount -> boolean : createUser()
    @RequestMapping(value = "/userRegister")
    public ModelAndView userRegister(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("level")String level, HttpServletResponse response) throws IOException {
        //验证方法执行和数据传输
        System.out.println("userRegister done");
        System.out.println("Register Username:"+username);
        System.out.println("Register Password:"+password);
        System.out.println("Register Level:"+level);
        //通过用户名在数据库查重
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(infuser.findUserByName(username)!=null)
        {
            out.println("<script>alert('该用户已存在，请重新输入新用户名');history.go(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        //确认为新用户，则在数据库中加入用户
        UserAccount user = new UserAccount();
        //ID不用设置，数据库会自动对表项赋ID
        user.setAccountName(username);
        user.setAccountPassword(password);
        infuser.createUser(user);
        //Mybatis中插入后给user的id自动赋值，通过检查id是否为空判断数据库操作是否成功
        user.setAccountId(2);
        if(user.getAccountId()==null)
        {
            out.println("<script>alert('抱歉，注册出现错误，请重新注册');history.go(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        //注册完成后自动登录，并将用户对象存入Model域中，并设置对应视图
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("../../mypage");
        return mv;
    }
}
