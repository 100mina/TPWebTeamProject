package board.free.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.free.model.FreeBoardDAO;
import board.free.model.FreeBoardVO;

@WebServlet("/getFreeBoardByCategory")
public class FreeBoardCategory extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트에서 전달한 카테고리 정보 받기
		
		System.out.println("카테고리별 게시글 분류를 요청하셨습니다");
		String encodedCategory = request.getParameter("category");
		String category = URLDecoder.decode(encodedCategory, "UTF-8");
        System.out.println("요청한 카테고리 : "+category);
        
        FreeBoardDAO freeBoardDao = new FreeBoardDAO();

        // 카테고리에 해당하는 게시글 목록을 데이터베이스에서 가져오는 로직 수행 (예시)
        List<FreeBoardVO> freeBoardList = freeBoardDao.getFreeBoardListByCategory(category);
        
        System.out.println(freeBoardList.size()+"text");
        // 데이터를 request에 attribute로 추가
        request.setAttribute("freeBoardList", freeBoardList);

        // JSP로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("board/free/boardList.jsp");
        dispatcher.forward(request, response);
    }
}
