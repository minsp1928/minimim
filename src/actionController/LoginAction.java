package actionController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;
import serviece.UserService;
import serviece.UserServiceImpl;

public class LoginAction implements Action {
	UserService us = new UserServiceImpl();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionId = null;
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		try {
			int result = us.loginchk(user_id, user_pw);
			if(result == 1 ) {
				session.setAttribute(sessionId, user_id);
				response.sendRedirect("ControllerServlet?command=index");
			}else
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
