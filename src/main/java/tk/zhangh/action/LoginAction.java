package tk.zhangh.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZhangHao on 16/5/16.
 */
public class LoginAction extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username").toString();
        String password = req.getParameter("password").toString();
        if ("qiangjinxin".equals(name) && "qiangjinxin".equals(password)){
            req.setAttribute("logined", "true");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getAttribute("username").toString();
        String password = req.getAttribute("password").toString();
        if ("qiangjinxin".equals(name) && "qiangjinxin".equals(password)){
            req.setAttribute("logined", "true");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
