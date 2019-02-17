package muzhou.com.servlet;

import muzhou.com.bean.CollectionBean;

import muzhou.com.service.CollectionService;

import muzhou.com.service.serviceImpl.CollectionServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DelCollectionServlet", urlPatterns = {"/DelCollectionServlet"})
public class DelCollectionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        //JSON对象
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = response.getWriter();

        int qid = Integer.parseInt(request.getParameter("qid"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        CollectionService collectionService = new CollectionServiceImpl();

        collectionService.deleteCollection(qid,userid);
        out.print(jsonObject);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
