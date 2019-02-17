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
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
      //  UserService userService = null;
/*
        List<QuestionBean> questionBean = null;
        QuestionService questionService = new QuestionServiceImpl();
        questionBean = questionService.getAllQuestion();
        Index index1 = new Index();
        index1.writeAllToIndex(questionBean);*/


        UserBean userBean = null;
        UserService userService = new UserServiceImpl();
        if (null!=request.getSession().getAttribute("userid"))
        {
            userBean = userService.getUserById((int)request.getSession().getAttribute("userid")) ;

            String head = null;
            if (null == userBean.getHead())
            {
                head = "../images/userHead.png";
            }
            else
            {
                head = userBean.getHead();
            }
            jsonObject.accumulate("userName", userBean.getUserName())
                    .accumulate("userid",userBean.getUserId())
                    .accumulate("userHead",head)
                    .accumulate("ifLogin","1");

        }
        else
        {
            jsonObject.accumulate("ifLogin","0");

        }
        out.print(jsonObject);


     /*   else
        {
            Cookie[] cookies = request.getCookies();

            for(int i = 0 ; i < cookies.length ; i++){
                String name = cookies[i].getName() ;
                String value = cookies[i].getValue() ;
                if (name.equals("user"))
                {
                    HttpSession session = request.getSession();
                    userBean =  userService.getUserById(Integer.parseInt(value));
                    session.setAttribute("user",userBean);
                    session.setMaxInactiveInterval(30*60);
                    System.out.println(userBean.getUserName());
                    jsonObject.accumulate("userName", userBean.getUserName());
                    out.print(jsonObject);
                }
                System.out.println("cookie、session都不存在");
            }
        }*/



    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
