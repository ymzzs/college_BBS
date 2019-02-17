package muzhou.com.servlet;

import muzhou.com.bean.UserBean;
import muzhou.com.service.UserService;
import muzhou.com.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name="UpdateServlet", urlPatterns={"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        System.out.println("UpdateServlet");

        // 表单验证使用javascript
        String username = request.getParameter("USERNAME");
        String school = request.getParameter("SCHOOL");
        String email = request.getParameter("EMAIL");
        String major = request.getParameter("MAJOR");
        String sex = request.getParameter("SEX");
        if (null==sex)
        {
            sex = "";
        }
        String signature = request.getParameter("SIGNATURE");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
           date = simpleDateFormat.parse(request.getParameter("UserInfoFormMap.birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Timestamp birthday = new Timestamp(date.getTime());



        System.out.println(birthday);
        String telephone = request.getParameter("TELEPHONE");
        UserService userService = new UserServiceImpl();
        int userid =(int)request.getSession().getAttribute("userid");
        UserBean sessionUser = userService.getUserById(userid);
        UserBean user = userService.getUser(username);
        if (username.equals(sessionUser.getUserName()))
        {
            UserBean userBean = new UserBean();
            userBean.setUserId(userid);
            userBean.setSchool(school);
            userBean.setUserName(username);
            userBean.setEmail(email);
            userBean.setMajor(major);
            userBean.setSex(sex);
            userBean.setBirthday(birthday);
            userBean.setTelephone(telephone);
            userBean.setSignature(signature);
            userService.updateUser(userBean);
            jsonObject.accumulate("ifSuccess","1");
        }
        else if(null == user)
        {
            UserBean userBean = new UserBean();
            userBean.setUserId(userid);
            userBean.setSchool(school);
            userBean.setUserName(username);
            userBean.setEmail(email);
            userBean.setMajor(major);
            userBean.setSex(sex);
            userBean.setBirthday(birthday);

            userBean.setTelephone(telephone);
            userBean.setSignature(signature);
            userService.updateUser(userBean);
            System.out.println("更新成功!");
            jsonObject.accumulate("ifSuccess","1");
        }
        else
        {
            jsonObject.accumulate("ifSuccess","0");
        }


        out.print(jsonObject);


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}