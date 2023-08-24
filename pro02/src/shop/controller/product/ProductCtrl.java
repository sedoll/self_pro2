package shop.controller.product;

import shop.dto.Product;
import shop.dto.Review;
import shop.model.ProductDAO;
import shop.model.ReviewDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/Product.do")
public class ProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        ProductDAO dao = new ProductDAO();
        Product pro = dao.getProduct(no);
        System.out.println(pro.toString());
        request.setAttribute("pro", pro);
        ReviewDAO dao2 = new ReviewDAO();
        List<Review> revList = dao2.getReviewList(no);
        System.out.println(revList.toString());
        request.setAttribute("revList", revList);
        RequestDispatcher view = request.getRequestDispatcher("/product/getProduct.jsp");
        view.forward(request, response);
    }
}
