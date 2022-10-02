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

@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data
		String id = request.getParameter("id");
		List<Product> PList = DAOProduct.getAllProductsByCateID(id);
		List<Category> CList = DAOCategory.getAllCategories();
		Product lastProduct = DAOProduct.getLastProduct();

		// set data to request
		request.setAttribute("PList", PList);
		request.setAttribute("CList", CList);
		request.setAttribute("LastProduct", lastProduct);
		request.setAttribute("flat", id);

		// forward
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
