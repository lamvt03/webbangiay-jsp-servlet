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

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// get data
		String inpTxt = request.getParameter("inpTxt");
		List<Product> PList = DAOProduct.getProductsBySearchInput(inpTxt);
		List<Category> CList = DAOCategory.getAllCategories();
		Product lastProduct = DAOProduct.getLastProduct();
		int resultLength = PList.size();

		// set data to request
		request.setAttribute("PList", PList);
		request.setAttribute("CList", CList);
		request.setAttribute("LastProduct", lastProduct);
		request.setAttribute("resultLength", resultLength);
		request.setAttribute("inpTxt", inpTxt);

		request.getRequestDispatcher("/views/home.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
