package muzhou.com.servlet;

import muzhou.com.bean.FollowBean;
import muzhou.com.service.CollectionService;
import muzhou.com.service.FollowService;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.CollectionServiceImpl;
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

@WebServlet(name = "AddFollowServlet", urlPatterns = {"/AddFollowServlet"})
public class AddFollowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        int userid = Integer.parseInt(request.getParameter("userid"));
        int followed_userid = Integer.parseInt(request.getParameter("followed_userid"));
        FollowService followService = new FollowServiceImpl();
        FollowBean followBean = new FollowBean();
        followBean.setUserid(userid);
        followBean.setFollowed_userid(followed_userid);
        followService.addFollow(followBean);

        followService.sendFollowMessage(userid,followed_userid);
        out.print(jsonObject);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
