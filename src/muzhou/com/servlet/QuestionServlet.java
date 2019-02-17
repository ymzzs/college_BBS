package muzhou.com.servlet;

import muzhou.com.bean.Index;
import muzhou.com.bean.QuestionBean;
import muzhou.com.bean.UserBean;
import muzhou.com.service.QuestionService;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.QuestionServiceImpl;
import muzhou.com.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionServlet", urlPatterns = {"/QuestionServlet"})
public class QuestionServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        String qTitle = request.getParameter("questionTitle");
        String qContent = request.getParameter("questionContent");
        String qCategory = request.getParameter("questionCategory");
        int qIntegral = Integer.parseInt(request.getParameter("questionIntegral"));
        int userId = Integer.parseInt(request.getParameter("userid"));
        String[] qKeyword = null;
        String questionKeyword = "";


        UserService userService = new UserServiceImpl();
        UserBean userBean = userService.getUserById(userId);
        String username = userBean.getUserName();
        QuestionBean questionBean = new QuestionBean();
        questionBean.setCategory(qCategory);
        questionBean.setTitle(qTitle);
        questionBean.setContent(qContent);
        questionBean.setUserId(userId);
        questionBean.setUsername(username);
        questionBean.setIntegral(qIntegral);
        if (null != request.getParameterValues("questionKeyword")) {
            qKeyword = request.getParameterValues("questionKeyword");
            for (String keyword : qKeyword) {
                questionKeyword = questionKeyword + keyword + " ";
            }

        } else {
            questionKeyword = " ";
        }



        questionBean.setKeyword(questionKeyword);
        QuestionService questionService = new QuestionServiceImpl();
        questionService.addQuestion(questionBean);

        Index index = new Index();
        index.writeToIndex(questionBean);
        int current_qid = questionService.getLastQid();
        jsonObject.accumulate("current_qid",current_qid);
        out.print(jsonObject);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
