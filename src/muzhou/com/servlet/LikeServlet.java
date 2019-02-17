package muzhou.com.servlet;

import muzhou.com.bean.AnswerBean;
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


@WebServlet(name = "LikeServlet", urlPatterns = {"/LikeServlet"})
public class LikeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();
        PrintWriter out = response.getWriter();
        System.out.println("LikeServlet");
        int userid = Integer.parseInt(request.getParameter("userid"));
        int aid =Integer.parseInt(request.getParameter("aid"));
        String ifLike = request.getParameter("ifLike");
        int newtotal =Integer.parseInt(request.getParameter("newtotal"));
        String ifCancel = request.getParameter("ifCancel");
        AnswerBean answerBean = new AnswerBean();
        AnswerService answerService = new AnswerServiceImpl();
        if ("notCancel".equals(ifCancel))
        {
            if ("dislike".equals(ifLike))
            {

                answerService.updateDislikeCount(aid,newtotal);
                answerService.addDisLikedUserId(userid,aid);
            }
            else if ("like".equals(ifLike))
            {
                answerService.updateLikeCount(aid,newtotal);
                answerService.addLikedUserId(userid,aid);
            }
        }
        else if ("cancel".equals(ifCancel))
        {
            if ("dislike".equals(ifLike))
            {
                answerService.updateDislikeCount(aid,newtotal);
                answerService.deleteDisLikedUserId(userid,aid);

            }
            else if ("like".equals(ifLike))
            {
                answerService.updateLikeCount(aid,newtotal);
                answerService.deleteLikedUserId(userid,aid);

            }

        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}