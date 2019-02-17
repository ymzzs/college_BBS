package muzhou.com.servlet;

import muzhou.com.bean.FollowBean;
import muzhou.com.service.FollowService;
import muzhou.com.service.QuestionService;
import muzhou.com.service.serviceImpl.FollowServiceImpl;
import muzhou.com.service.serviceImpl.QuestionServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddVisitServlet", urlPatterns = {"/AddVisitServlet"})
public class AddVisitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("AddVisitCount被执行了");
        int qid = Integer.parseInt(request.getParameter("qid"));
        QuestionService questionService = new QuestionServiceImpl();
        questionService.addVisitCount(qid);


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
