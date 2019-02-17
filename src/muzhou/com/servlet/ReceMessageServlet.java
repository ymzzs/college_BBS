package muzhou.com.servlet;


import muzhou.com.service.MessageService;
import muzhou.com.service.serviceImpl.MessageServiceImpl;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ReceMessageServlet", urlPatterns = {"/ReceMessageServlet"})
public class ReceMessageServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        int userid = Integer.parseInt(request.getParameter("userid"));
        MessageService messageService = new MessageServiceImpl();

        List<Map<String, Object>> mList = messageService.getMessageList(userid);
        jsonObject.accumulate("mList",mList);
        System.out.println("userid:"+userid);
        System.out.println("mList:"+mList);

        out.print(jsonObject);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}