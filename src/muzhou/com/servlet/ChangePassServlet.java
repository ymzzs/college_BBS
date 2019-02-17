package muzhou.com.servlet;

import muzhou.com.bean.UserBean;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;import java.util.List;

@WebServlet(name = "ChangePassServlet", urlPatterns = {"/ChangePassServlet"})
public class ChangePassServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        System.out.println("1我被执行了");
        int userid = Integer.parseInt(request.getParameter("userid"));
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String password3 = request.getParameter("password3");
        System.out.println("2我被执行了");
        UserService userService = new UserServiceImpl();
        UserBean userBean = userService.getUserById(userid);
        System.out.println(password);
        System.out.println(password2);
        System.out.println(password3);
        if (password.equals(userBean.getPassWord()))
        {
            System.out.println("3我被执行了");
            jsonObject.accumulate("ifOldCorrect",1);
            if (password2.length()>=6&&password2.length()<=16)
            {
                if (password2.equals(password3))
                {
                    userService.updatePassword(userid,password2);
                    jsonObject.accumulate("ifUpdateCorrect",1);
                }
                else
                {
                    jsonObject.accumulate("ifUpdateCorrect",0);
                }
            }

        }
        else
        {
            jsonObject.accumulate("ifOldCorrect",0);
        }
        System.out.println("4我被执行了");
        out.print(jsonObject);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
