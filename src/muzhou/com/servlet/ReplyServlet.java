package muzhou.com.servlet;
import muzhou.com.bean.AnswerBean;
import muzhou.com.bean.UserBean;
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

@WebServlet(name = "ReplyServlet", urlPatterns = {"/ReplyServlet"})
public class ReplyServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");
        int userid = Integer.parseInt(request.getParameter("userid"));
        int qid =Integer.parseInt(request.getParameter("qid"));

        QuestionService questionService = new QuestionServiceImpl();
        int rece_userid = questionService.getUserIdByQid(qid);

        AnswerBean answerBean = new AnswerBean();
        answerBean.setContent(content);
        answerBean.setQid(qid);
        answerBean.setUserId(userid);
        AnswerService answerService = new AnswerServiceImpl();
        answerService.addAnswer(answerBean);

        answerService.sendAnswerMessage(userid,rece_userid,qid);
        out.print(jsonObject);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}