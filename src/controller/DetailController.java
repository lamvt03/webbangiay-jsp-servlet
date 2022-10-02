package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCategory;
import dao.DAOProduct;
import model.Category;
import model.Product;


@WebServlet(urlPatterns = {"/detail"})
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Product p = DAOProduct.getProductsByID(id);
		List<Category> CList = DAOCategory.getAllCategories();
		Product lastProduct = DAOProduct.getLastProduct();
		
		request.setAttribute("p", p);
		request.setAttribute("CList", CList);
		request.setAttribute("LastProduct", lastProduct);
		
		request.getRequestDispatcher("views/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
