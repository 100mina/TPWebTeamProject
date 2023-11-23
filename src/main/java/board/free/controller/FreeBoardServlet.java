package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.free.model.FreeBoardDAO;
import board.free.model.FreeBoardVO;
import board.model.BoardVO;

public class FreeBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}
	
	FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시글 리스트검색은 model 역할의 클래스에게 요청.. DAO, VO, Service .. [TP01_BOARD 테이블 생성]
		
		List<FreeBoardVO> freeBoardList= freeBoardDAO.getFreeBoardList();
		
		//리다이렉트될 화면에서 게시글 리스트를 사용하기 위해 session 객체를 활용
		HttpSession session= req.getSession();
		session.setAttribute("freeBoardList", freeBoardList);			
		
		//요청 데이터 인코딩, 응답 MIME 타입 및 인코딩
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/free/boardList.jsp");
		dispatcher.forward(req, resp);
				
	}
	
	

}
