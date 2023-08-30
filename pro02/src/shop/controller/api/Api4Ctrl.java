package shop.controller.api;

//import org.json.JSONObject;
import net.sf.json.*;
import shop.dto.Test;
import shop.model.TestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@WebServlet("/Api4")
public class Api4Ctrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //CORS(Cross Origin Resource Sharing) 해제
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        int no = Integer.parseInt(request.getParameter("no"));

        TestDAO dao = new TestDAO();
        List<Test> data = new ArrayList<>();

        PrintWriter out = response.getWriter();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", data);

        JSONObject json = new JSONObject();
        json.putAll(map); // list -> array
        out.println(json.toString());
    }
}
