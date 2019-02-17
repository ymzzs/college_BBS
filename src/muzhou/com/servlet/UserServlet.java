package muzhou.com.servlet;

import muzhou.com.bean.FollowBean;
import muzhou.com.bean.UserBean;
import muzhou.com.service.FollowService;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.FollowServiceImpl;
import muzhou.com.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Date;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        int userid = Integer.parseInt(request.getParameter("userid"));
        UserService userService = new UserServiceImpl();
        UserBean userBean = userService.getUserById(userid);
        if ("1".equals(request.getParameter("otherUser")))
        {
            FollowService followService = new FollowServiceImpl();
            List<FollowBean> fList = followService.getFollowByUserid(userid);
            jsonObject.accumulate("fList",fList);
        }
        else
        {
            FollowService followService = new FollowServiceImpl();
            List<FollowBean> fList = followService.getFollowByLoginUserid(userid);
            jsonObject.accumulate("fList",fList);
        }

        jsonObject.accumulate("user",userBean);

        out.print(jsonObject);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
