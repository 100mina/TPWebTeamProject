package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.free.model.FreeBoardService;
import board.free.model.FreeBoardVO;

@WebServlet("/changePage")
public class FreeBoardChangePage extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 페이지 번호를 가져옴
        String pageNoParam = request.getParameter("pageNo");
        int pageNo = pageNoParam != null ? Integer.parseInt(pageNoParam) : 1;
        int pageSize = 8;
        FreeBoardService freeBoardService= new FreeBoardService();
        
        // 게시글 목록을 가져오는 로직을 구현 (예: FreeBoardService의 getFreeBoardListPaging 메서드 활용)
        List<FreeBoardVO> pagedFreeBoardList;
		pagedFreeBoardList = freeBoardService.getFreeBoardListPaging(pageNo, pageSize);
		
        System.out.println("FreeBoardChangePage 서블릿 호출 - 페이지 번호: " + pageNo);
		
        // 가져온 데이터를 JSP로 전달
        request.setAttribute("freeBoardList", pagedFreeBoardList);

        // JSP 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("board/free/boardList.jsp");
        dispatcher.forward(request, response);
    }

}
