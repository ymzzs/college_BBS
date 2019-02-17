package muzhou.com.servlet;

import muzhou.com.service.AnswerService;
import muzhou.com.service.QuestionService;
import muzhou.com.service.serviceImpl.AnswerServiceImpl;
import muzhou.com.service.serviceImpl.QuestionServiceImpl;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChooseBestServlet", urlPatterns = {"/ChooseBestServlet"})
public class ChooseBestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        int qid = Integer.parseInt(request.getParameter("qid"));
        int aid = Integer.parseInt(request.getParameter("aid"));
        int send_userid = Integer.parseInt(request.getParameter("send_userid"));


        QuestionService questionService = new QuestionServiceImpl();
        questionService.setBestAnswer(qid,aid);

        AnswerService answerService = new AnswerServiceImpl();
        int rece_userid = answerService.getUserIdByAid(aid);

        questionService.updateIntegral(send_userid,rece_userid,qid);
        questionService.sendBestMessage(send_userid,rece_userid,qid);

        out.print(jsonObject);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
