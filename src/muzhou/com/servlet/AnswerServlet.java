package muzhou.com.servlet;

import muzhou.com.bean.CollectionBean;
import muzhou.com.bean.QuestionBean;
import muzhou.com.bean.UserBean;
import muzhou.com.service.*;
import muzhou.com.service.serviceImpl.*;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AnswerServlet", urlPatterns = {"/AnswerServlet"})
public class AnswerServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        int qid = Integer.parseInt(request.getParameter("qid"));


        AnswerService answerService = new AnswerServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        List<Map<String, Object>> aList = answerService.getAnswerInfByQid(qid);
        List<Map<String,Object>> cList = commentService.getCommentInfByQid(qid);



        jsonObject.accumulate("aList",aList)
                .accumulate("cList",cList);


        out.print(jsonObject);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}