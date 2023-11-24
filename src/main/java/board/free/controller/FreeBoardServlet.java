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
import board.free.model.FreeBoardService;
import board.free.model.FreeBoardVO;

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
		
		//요청 데이터 인코딩, 응답 MIME 타입 및 인코딩
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//1. 요청 파라미터 확인 - RESTful 기법을 위한 데이터들..
		String method= req.getParameter("method");
		String freeNo= req.getParameter("free_no");
		System.out.println("method : " + method);
		System.out.println("boardNo: " + freeNo);
		
		FreeBoardService freeBoardService= new FreeBoardService();
		
		if(method==null || method.equals("GET")) { //글 검색 요청
			if(freeNo==null) {
				System.out.println("전체 게시글 리스트 검색을 요청하셨습니다.");
				
				List<FreeBoardVO> freeBoardList= freeBoardService.getFreeBoardList();
				
				//리다이렉트될 화면에서 게시글 리스트를 사용하기 위해 session 객체를 활용
				HttpSession session= req.getSession();
				session.setAttribute("freeBoardList", freeBoardList);				
				
				//화면구현은 별도의 JSP 이동
				resp.sendRedirect("board/free/boardList.jsp");
			}else {
				System.out.println("상세 게시글 검색을 요청하셨습니다.");
				
				//전달받은 게시글 번호를 통해 상세글 요청..
				FreeBoardVO vo= new FreeBoardVO();
				vo.setFreeNo(Integer.parseInt(freeNo));
				
				FreeBoardVO freeBoard= freeBoardService.getFreeBoard(vo);
				
				//리다이렉트될 화면에 게시글 정보를 사용하기 위해 세션에 저장
				HttpSession session= req.getSession();
				session.setAttribute("freeBoard", freeBoard);
				
				resp.sendRedirect("board/free/boardDetail.jsp"); //상세글 화면으로 이동				
			}
			
		}else if(method.equals("POST")) { //새글 등록
			System.out.println("새로운 게시글 삽입을 요청하셨습니다.");
			
			//사용자 요청 데이터 받기.. 파일도 있음. 코드가 많겠죠... 그걸 이 조건문에서 작성하면 다소 정신없음.
			//그래서 다른 서블릿에게 처리를 넘기기.. forward .. BoardInsertServlet.java....
			RequestDispatcher dispatcher= req.getRequestDispatcher("insertFreeBoard");
			dispatcher.forward(req, resp);
			
		}else if(method.equals("PUT")) { //게시글 수정
			System.out.println("게시글 수정을 요청하셨습니다.");
			
			// 글 수정도 저장할 것들이 많아서 복잡할 수 있음..그래서 별도의 서블릿에게 요청을 위임...forward.. BoardModifyServlet.java
			RequestDispatcher dispatcher= req.getRequestDispatcher("modifyFreeBoard");
			dispatcher.forward(req, resp);
			
			
		}else if(method.equals("DELETE")) { //게시글 삭제
			System.out.println("게시글 삭제를 요청하셨습니다.");
			
			FreeBoardVO vo= new FreeBoardVO();
			vo.setFreeNo(Integer.parseInt(freeNo));
			
			List<FreeBoardVO> boardList= freeBoardService.deleteFreeBoard(vo); //삭제 후 갱신된 게시글 리스트를 리턴해 줌
			
			HttpSession session= req.getSession();
			session.setAttribute("freeBoardList", boardList);
			resp.sendRedirect("board/free/boardList.jsp");				
			
		}	
					
		
	}
		

}
