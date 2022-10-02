package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOUser;
import model.User;

@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String r_password = request.getParameter("repeat-password");
		
		
		String msg = null;
		
		//nếu nhập chưa đầy đủ thông tin
		if(username == null 
		 || username.length()==0 
		 || password == null 
		 || password.length()==0
		 || r_password == null 
		 || r_password.length()==0){
			msg = "Vui lòng nhập đầy đủ thông tin";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
			return;
		}
		//đã nhập đầy đủ
		else {
			//kiểm tra username đã tồn tại hay chưa
			if(DAOUser.isAvailableUsername(username)) {
				msg = "Username đã tồn tại. Vui lòng nhập username khác";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
				return;
			}
			
			//kiểm tra password và r_password có khớp không
			if(!password.equals(r_password)) {
				msg = "Xác nhận mật khẩu không khớp";
				
				request.setAttribute("msg", msg);
				request.setAttribute("enteredUsername", username);
				request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
				return;
			}
			
			//thêm account vào database và thông báo
			DAOUser.insertUser(new User(username, password));
			response.sendRedirect("success-register");
		}
	}
}

