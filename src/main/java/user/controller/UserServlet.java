package user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.port.model.PortBoardDAO;
import board.port.model.PortBoardVO;
import user.model.UserDAO;
import user.model.UserVO;



public class UserServlet extends HttpServlet{
	// user/signup
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String userId= req.getParameter("user_id");
		
		UserVO vo= new UserVO();
		vo.setId(userId);
		
		PortBoardDAO dao= new PortBoardDAO();
		UserVO user= dao.getUser(vo);
		System.out.println(user.getNickName()+","+user.getId());
		
		PortBoardVO boardvo= new PortBoardVO();
		boardvo.setUserId(userId);
		
		user.setUserPort(dao.getUserPort(boardvo));
		
		UserDAO userDao= new UserDAO();
		user.setTotalFav(userDao.totalFav(vo));
		
		HttpSession session= req.getSession();
		session.setAttribute("userPage", user);
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("user/userMyPage.jsp");
		dispatcher.forward(req, resp);		
	}
}
