package shop.controller.api;

import org.json.JSONObject;
import shop.dto.Test;
import shop.model.TestDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Api2")
public class Api2Ctrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //CORS(Cross Origin Resource Sharing) 해제
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println("api2 실행 확인");

        int no = Integer.parseInt(request.getParameter("no"));

        TestDAO dao = new TestDAO();
        Test result = dao.getTest(no);

        JSONObject json = new JSONObject();
        json.put("no", result.getNo());
        json.put("name", result.getName());
        json.put("point", result.getPoint());
        PrintWriter out = response.getWriter();
        out.println(json);
    }
}
