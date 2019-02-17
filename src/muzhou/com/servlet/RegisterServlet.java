package muzhou.com.servlet;

import muzhou.com.bean.UserBean;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="RegisterServlet", urlPatterns={"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        // 表单验证使用javascript
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("passwordConfirm");
        String register = request.getParameter("Register");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        UserService userService = new UserServiceImpl();
        UserBean user = new UserBean();
        user = userService.getUser(username);
        if (user != null) {
            jsonObject.accumulate("checkName", "0")
                    .accumulate("checkPass", "2")
                    .accumulate("checkConfirm","2");

            response.setContentType("application/json");
            out.print(jsonObject);

        }
        else if (username.equals(""))
        {
            jsonObject.accumulate("checkName", "2")
                    .accumulate("checkPass", "2")
                    .accumulate("checkConfirm", "2");

            response.setContentType("application/json");
            out.print(jsonObject);
        }
        else if (password.equals(""))
        {
            jsonObject.accumulate("checkName", "1")
                    .accumulate("checkPass", "2")
                    .accumulate("checkConfirm", "2");

            response.setContentType("application/json");
            out.print(jsonObject);

        }

        else if (password.length()<6||password.length()>16)
        {
            jsonObject.accumulate("checkName", "1")
                    .accumulate("checkPass", "0")
                    .accumulate("checkConfirm","0");

            response.setContentType("application/json");
            out.print(jsonObject);

        }
        else if (confirm.equals(""))
        {
            jsonObject.accumulate("checkName", "1")
                    .accumulate("checkPass", "1")
                    .accumulate("checkConfirm", "2");

            response.setContentType("application/json");
            out.print(jsonObject);
        }
        else if (!confirm.equals(password))
        {
            jsonObject.accumulate("checkName", "1")
                    .accumulate("checkPass", "1")
                    .accumulate("checkConfirm", "0");

            response.setContentType("application/json");
            out.print(jsonObject);

        }
        else if (register.equals("0"))
        {
            jsonObject.accumulate("checkName", "1")
                    .accumulate("checkPass", "1")
                    .accumulate("checkConfirm", "1");
            response.setContentType("application/json");
            out.print(jsonObject);
        }
        else if(register.equals("1"))
        {
            System.out.println("注册成功");

            UserBean userBean = new UserBean();
            userBean.setUserName(username);

            userBean.setPassWord(password);
            userBean.setEmail(email);
            userBean.setTelephone(telephone);

            userService.addUser(userBean); //添加用户

            jsonObject.accumulate("checkName", "1")
                    .accumulate("checkPass", "1")
                    .accumulate("checkConfirm", "1")
                    .accumulate("jump","1");
            response.setContentType("application/json");
            out.print(jsonObject);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
