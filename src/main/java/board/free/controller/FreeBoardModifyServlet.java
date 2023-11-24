package board.free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.free.model.FreeBoardService;
import board.free.model.FreeBoardVO;

@WebServlet("/modifyFreeBoard")
public class FreeBoardModifyServlet extends HttpServlet{
	
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
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String freeNo= req.getParameter("free_no");
		String freeTitle= req.getParameter("free_title");
		String freeContent= req.getParameter("free_content");		
		
		// 여기까지 데이터 확인!!
		System.out.println(freeTitle);
		System.out.println(freeContent);
		System.out.println(freeNo);
				
		// insert 에 필요한 데이터들을 VO 객체로 묶기
		FreeBoardVO vo= new FreeBoardVO();
		vo.setFreeNo(Integer.parseInt(freeNo));  //글번호
		vo.setFreeTitle(freeTitle);              //제목
		vo.setFreeContent(freeContent);          //내용
				
		//2. 비니지스 로직
		FreeBoardService freeBoardService= new FreeBoardService();
		FreeBoardVO board= freeBoardService.updateFreeBoard(vo);  //수정된 글 정보를 리턴받기
				
		//3. 화면 구현
		HttpSession session= req.getSession();
		session.setAttribute("board", board); //갱신된 게시글을 세션에 저장
				
		resp.sendRedirect("board/free/boardDetail.jsp"); //게시글 상세 화면으로 이동.
		
	}

}
