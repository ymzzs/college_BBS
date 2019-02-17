package muzhou.com.servlet;

import muzhou.com.bean.PageBean;
import muzhou.com.service.FollowService;
import muzhou.com.service.serviceImpl.FollowServiceImpl;
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

@WebServlet(name = "FollowServlet", urlPatterns = {"/FollowServlet"})
public class FollowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        int page =Integer.parseInt(request.getParameter("page"));
        int userid =Integer.parseInt(request.getParameter("userid"));
        String type = request.getParameter("type");
        FollowService followService = new FollowServiceImpl();

        if (type.equals("follow"))
        {
            PageBean<Map<String,Object>> pageBean = followService.getFollowByPageAndUserId(page,userid);
            long totalCount = pageBean.getTotalCount();
            int totalPage = pageBean.getTotalPage();
            int currentPage = pageBean.getCurrentPage();
            List list = pageBean.getList();


            jsonObject.accumulate("totalPage",totalPage)
                    .accumulate("totalCount",totalCount)
                    .accumulate("currentPage",currentPage)
                    .accumulate("list",list);

        }

        else
        {
            PageBean<Map<String,Object>> pageBean = followService.getFansByPageAndUserId(page,userid);
            long totalCount = pageBean.getTotalCount();
            int totalPage = pageBean.getTotalPage();
            int currentPage = pageBean.getCurrentPage();
            List list = pageBean.getList();
            List fList = followService.getFollowByLoginUserid(userid);




            jsonObject.accumulate("totalPage",totalPage)
                    .accumulate("totalCount",totalCount)
                    .accumulate("currentPage",currentPage)
                    .accumulate("list",list)
                    .accumulate("fList",fList);
        }

        out.print(jsonObject);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
