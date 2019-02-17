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

@WebServlet(name = "DelCommentServlet", urlPatterns = {"/DelCommentServlet"})
public class DelCommentServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        //JSON对象
        JSONObject jsonObject = new JSONObject();
        PrintWriter out = response.getWriter();

        int cid =Integer.parseInt(request.getParameter("cid"));


        CommentService commentService = new CommentServiceImpl();
        commentService.deleteCommentById(cid);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}