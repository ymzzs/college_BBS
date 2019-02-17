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

@WebServlet(name = "SigninServlet", urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        String userid = request.getParameter("userid");
        UserService userService = new UserServiceImpl();
        UserBean userBean = userService.getUserById(Integer.parseInt(userid));
        int status = userBean.getSignin();
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        if(0==status){
            userService.updateSignInStatus(Integer.parseInt(userid));
            json.accumulate("status", "完成签到");
        }else{
            json.accumulate("status","已签到");
        }
        out.print(json);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}