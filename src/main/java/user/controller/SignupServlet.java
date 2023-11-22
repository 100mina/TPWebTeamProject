package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.UserDAO;
import user.model.UserVO;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id"); 
		String pw = req.getParameter("pw"); 
		String nickName = req.getParameter("nickName");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setNickName(nickName);
		
		
		UserDAO dao = new UserDAO();
		dao.insertMember(vo);
		
		resp.sendRedirect("user/loginForm.jsp");
	}

}
