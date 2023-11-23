package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserDAO;
import user.model.UserVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		if(user!=null) {
			HttpSession session = req.getSession();
//			session.setAttribute("user", user);
//			
//			resp.sendRedirect("index.jsp");
			PrintWriter wt = resp.getWriter();
			wt.println("<!DOCTYPE html>");
			wt.println("<html>");
			wt.println("<head>");
			wt.println("<script>");
			wt.println("location.href='./index.jsp';");
			wt.println("</script>");
			wt.println("</head>");
			wt.println("</html>");
			
		}else {
			PrintWriter wt = resp.getWriter();
			wt.println("<!DOCTYPE html>");
			wt.println("<html>");
			wt.println("<head>");
			wt.println("<script>");
			wt.println("alert('잘못된 회원정보 입니다.')");
			wt.println("location.href='user/loginForm.jsp';");
			wt.println("</script>");
			wt.println("</head>");
			wt.println("</html>");
		}
		
		
		
	}
	
	
}
