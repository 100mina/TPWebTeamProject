package user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;
import user.model.FollowerVO;
import user.model.UserDAO;
import user.model.UserVO;



public class UserServlet extends HttpServlet{
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
		
		// 파라미터로 요청된 데이터 "/" 분리하는 코드
		String s = req.getPathInfo();
		String[] originalPath = s.split("/");
		
		// reqUserId 로 요청된 id 로 DAO Select 문 실행
		String reqUserId = originalPath[1];
		
		// 로그인한 유저의 정보
		UserVO user = (UserVO)req.getSession().getAttribute("user");
		
		PortBoardService pbService = new PortBoardService();
		List<PortBoardVO> userPortList = pbService.getPortList();
		
		// 유저가 자신의 페이지를 눌렀을 때
		if(reqUserId.equals(user.getId())) {
			req.setAttribute("userPortList", userPortList);
			resp.sendRedirect("user/userMyPage.jsp?size="+userPortList.size());
		// 다른 유저의 페이지를 눌렀을 때	
		}else {
			req.setAttribute("userPortList", userPortList);
			resp.sendRedirect("user/userMyPage.jsp?size="+userPortList.size());
		}
	}
}
