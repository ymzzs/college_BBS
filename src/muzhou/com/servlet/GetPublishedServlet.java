package muzhou.com.servlet;

import muzhou.com.bean.PageBean;
import muzhou.com.bean.QuestionBean;
import muzhou.com.service.QuestionService;
import muzhou.com.service.serviceImpl.QuestionServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetPublishedServlet", urlPatterns = {"/GetPublishedServlet"})
public class GetPublishedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        String page = request.getParameter("page");
        int userid = Integer.parseInt(request.getParameter("userid"));
        QuestionService questionService = new QuestionServiceImpl();

        PageBean<QuestionBean> pageBean = questionService.getPublishedByPageAndUid(Integer.parseInt(page),userid);
        long totalCount = pageBean.getTotalCount();
        int totalPage = pageBean.getTotalPage();
        int currentPage = pageBean.getCurrentPage();
        List list = pageBean.getList();


        jsonObject.accumulate("totalPage",totalPage)
                .accumulate("totalCount",totalCount)
                .accumulate("currentPage",currentPage)
                .accumulate("list",list);
        out.print(jsonObject);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
