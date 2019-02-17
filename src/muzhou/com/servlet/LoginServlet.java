package muzhou.com.servlet;

import muzhou.com.bean.UserBean;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();



        UserService userService = new UserServiceImpl();
        UserBean user = new UserBean();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Login = request.getParameter("Login");
        user = userService.getUser(username);

       if (username.equals(""))
        {
            jsonObject.accumulate("checkName", "2").accumulate("checkPass", "1");
            out.print(jsonObject);
        }
       else if (user == null) {

           jsonObject.accumulate("checkName", "0").accumulate("checkPass", "1");
           out.print(jsonObject);

       }
        else if (!user.getPassWord().equals(password)) {
            jsonObject.accumulate("checkName", "1").accumulate("checkPass","0");
            out.print(jsonObject);

        } else if (user.getPassWord().equals(password)) {
            if (Login.equals("1")) {

                // 登录成功，将用户存储到session
                HttpSession session = request.getSession();
                session.setAttribute("userid", user.getUserId());
                session.setMaxInactiveInterval(30*60);
            /*    // 添加cookie，cookie信息为 user:id
                Cookie cookie = new Cookie("user", Integer.toString(user.getUserId()));
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);*/
                jsonObject.accumulate("checkName", "1")
                        .accumulate("checkPass", "1");



                out.print(jsonObject);

            } else {
                jsonObject.accumulate("checkName", "1").accumulate("checkPass", "1");
                out.print(jsonObject);

            }

        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
