package muzhou.com.servlet;

import muzhou.com.service.FollowService;

import muzhou.com.service.MessageService;
import muzhou.com.service.serviceImpl.FollowServiceImpl;
import muzhou.com.service.serviceImpl.MessageServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DelFollowServlet", urlPatterns = {"/DelFollowServlet"})
public class DelFollowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        int userid = Integer.parseInt(request.getParameter("userid"));
        int followed_userid = Integer.parseInt(request.getParameter("followed_userid"));
        String type = "follow";
        FollowService followService = new FollowServiceImpl();
        followService.deleteFollow(userid,followed_userid);
        MessageService messageService = new MessageServiceImpl();
        messageService.delMessageBySidAndRidAndType(userid,followed_userid,type);
        out.print(jsonObject);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
