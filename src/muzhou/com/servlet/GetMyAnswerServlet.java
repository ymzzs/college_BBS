package muzhou.com.servlet;

import muzhou.com.bean.PageBean;
import muzhou.com.service.AnswerService;
import muzhou.com.service.serviceImpl.AnswerServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetMyAnswerServlet", urlPatterns = {"/GetMyAnswerServlet"})
public class GetMyAnswerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        String page = request.getParameter("page");
        int userid = Integer.parseInt(request.getParameter("userid"));
        AnswerService answerService = new AnswerServiceImpl();
        PageBean<Map<String,Object>> pageBean = answerService.getMyAnswerByPageAndUid(Integer.parseInt(page),userid);
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
