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

@WebServlet(name = "DelMessageServlet", urlPatterns = {"/DelMessageServlet"})
public class DelMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();
        int mid = Integer.parseInt(request.getParameter("mid"));
        MessageService messageService = new MessageServiceImpl();
        messageService.delMessageByMid(mid);
        out.print(jsonObject);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
