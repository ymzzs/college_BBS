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

@WebServlet(name = "UAQServlet", urlPatterns = {"/UAQServlet"})
public class UAQServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        int qid = Integer.parseInt(request.getParameter("qid"));
        int uid =  Integer.parseInt(request.getParameter("userid"));
        QuestionBean questionBean = null;
        QuestionService questionService = new QuestionServiceImpl();
        questionBean = questionService.getQuestionById(qid);

        String qusername = questionBean.getUsername();
        String qtime = questionBean.getTime().toString().replace(".0","");
        String qcontent = questionBean.getContent();
        String qtitle = questionBean.getTitle();
        int qintegral = questionBean.getIntegral();
        String keyword = questionBean.getKeyword();
        int userid = questionBean.getUserId();
        System.out.println("我被执行了");
        UserService userService = new UserServiceImpl();
        UserBean userBean = userService.getUserById(userid);
        Map<String,Object> userInf = userService.getUserInf(uid);
        System.out.println(userInf);
        CollectionService collectionService = new CollectionServiceImpl();
        List<CollectionBean> colist = collectionService.getCollectionByQid(qid);

        String head = null;
        if (null == userBean.getHead())
        {
            head = "../images/userHead.png";
        }
        else
        {
            head = userBean.getHead();
        }

        String[] labels = keyword.split("\\s+");

        jsonObject.accumulate("quserName",qusername)
                .accumulate("qtime",qtime)
                .accumulate("qcontent",qcontent)
                .accumulate("qtitle",qtitle)
                .accumulate("qintegral",qintegral)
                .accumulate("userid",userid)
                .accumulate("userHead",head)
                .accumulate("labels",labels)
                .accumulate("colist",colist)
                .accumulate("userInf",userInf);


        out.print(jsonObject);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}