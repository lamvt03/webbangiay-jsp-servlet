package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOUser;
import model.User;

@WebServlet(urlPatterns = {"/sign-in"})
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/sign-in.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User loginedUser = null;
		String msg = null;
		
		//nếu nhập chưa đầy đủ thông tin
		if(username == null 
		 || username.length()==0 
		 || password == null 
		 || password.length()==0) {
			msg = "Vui lòng nhập đầy đủ thông tin";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/views/sign-in.jsp").forward(request, response);
		}
		//đã nhập đầy đủ
		else {
			loginedUser = DAOUser.findUserByUsernameAndPassword(username, password);
			
			//đăng nhập thành công
			if(loginedUser != null) {
				//lưu user vào session
				HttpSession session = request.getSession();
				session.setAttribute("user", loginedUser);
				
				response.sendRedirect("home");
			}
			//không tồn tại
			else {
				msg = "Tài khoản hoặc mật khẩu không đúng";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/views/sign-in.jsp").forward(request, response);
			}
		}
		
		
	}

}
