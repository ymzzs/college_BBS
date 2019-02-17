package muzhou.com.servlet;

import com.mchange.v1.db.sql.CBPCursor;
import muzhou.com.bean.CommentBean;
import muzhou.com.service.CommentService;
import muzhou.com.service.serviceImpl.CommentServiceImpl;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        //JSON对象
        JSONObject jsonObject = new JSONObject();
        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");
        int userid =Integer.parseInt(request.getParameter("userid"));
        int aid = Integer.parseInt(request.getParameter("aid"));
        int qid = Integer.parseInt(request.getParameter("qid"));

        CommentBean commentBean = new CommentBean();
        if (!"".equals(request.getParameter("recid")) )
        {
            int recid = Integer.parseInt(request.getParameter("recid"));
            commentBean.setRecId(recid);
        }
        CommentService commentService = new CommentServiceImpl();
        commentBean.setAid(aid);
        commentBean.setQid(qid);
        commentBean.setUserId(userid);
        commentBean.setContent(content);
        commentService.addComment(commentBean);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}