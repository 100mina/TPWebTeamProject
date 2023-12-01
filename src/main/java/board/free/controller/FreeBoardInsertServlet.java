package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.free.model.FreeBoardService;
import board.free.model.FreeBoardVO;
import user.model.UserVO;

@WebServlet("/insertFreeBoard")
public class FreeBoardInsertServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		HttpSession session= req.getSession();
		UserVO user= (UserVO) session.getAttribute("user");
		
		String freeTitle= req.getParameter("free_title");
		String freeContent= req.getParameter("free_content");
		String freeCategory= req.getParameter("free_category");
		String freeNickname= user.getNickName();
		
		System.out.println(freeTitle);
		System.out.println(freeContent);
		System.out.println(freeCategory);
		System.out.println(freeNickname);

		
		FreeBoardVO vo= new FreeBoardVO();
		vo.setFreeTitle(freeTitle);
		vo.setFreeContent(freeContent);
		vo.setUserNickname(freeNickname);
		vo.setFreeCategory(freeCategory);
		
		FreeBoardService freeBoardService= new FreeBoardService();
		List<FreeBoardVO> freeBoardList= freeBoardService.insertFreeBoard(vo);
		
		session.setAttribute("freeBoardList", freeBoardList); //갱신된 게시글 리스트를 세션에 저장
		resp.sendRedirect("board/free/boardList.jsp");	
		
	}

}
