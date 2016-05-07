package tk.zhangh.action;

import tk.zhangh.service.AlgorithmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基础action,提供模板方法
 * Created by ZhangHao on 16/4/30.
 */
public abstract class BaseAction extends HttpServlet{
    private AlgorithmService algorithmService;

    public void setAlgorithmService(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    public AlgorithmService getAlgorithmService() {
        return algorithmService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numStr = req.getParameter("num");
        boolean result = isPrime(numStr);
        if (result){
            req.getRequestDispatcher("yes.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("no.jsp").forward(req,resp);
        }
    }

    abstract boolean isPrime(String numStr);
}
