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

@WebServlet(name = "uploadHeadServlet", urlPatterns = {"/uploadHeadServlet"})
public class uploadHeadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        String img = request.getParameter("head");//头像的base64编码获取.
        String userid = request.getParameter("userid");
        UserService userService = new UserServiceImpl();
        UserBean userBean = userService.getUserById(Integer.parseInt(userid));
        String lastImg  = userBean.getHead();
        userService.updateHead(Integer.parseInt(userid),img);
        userBean = userService.getUserById(Integer.parseInt(userid));
        String ThisImg  = userBean.getHead();
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        if(lastImg == ThisImg){
            json.accumulate("result", "0");  //1表示上传失败
        }else{
            json.accumulate("result", "1");  //1表示上传成功
        }
        out.print(json);
        out.close();

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
