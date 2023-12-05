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
import board.free.model.FreeCommentVO;
import user.model.UserVO;

@WebServlet("/addFreeCmt")
public class FreeCmtAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session= req.getSession();
		UserVO user= (UserVO) session.getAttribute("user");
		    
        // 가져온 데이터를 FreeCommentVO에 설정
        String freeNo = req.getParameter("free_no");
        String userId = (user != null) ? user.getId() : null; // user가 null이면 userId도 null로 설정
        String freeCmtContent = req.getParameter("free_cmt_content");

        // FreeBoardService를 이용하여 댓글 추가
        if (user != null) {
            // 가져온 데이터를 FreeCommentVO에 설정
            FreeCommentVO vo = new FreeCommentVO();
            vo.setFreeNo(Integer.parseInt(freeNo));
            vo.setUserId(userId);
            vo.setFreeCmtContent(freeCmtContent);

            // FreeBoardService를 이용하여 댓글 추가
            FreeBoardService freeBoardService = new FreeBoardService();
            freeBoardService.addComment(vo);

            List<FreeCommentVO> freeCmtList = freeBoardService.getFreeCmtList(vo);
            session.setAttribute("freeCmtList", freeCmtList);

            System.out.println("댓글이 등록되었습니다");

            // 댓글 등록 후, 다시 상세 페이지로 리다이렉트
            resp.sendRedirect("board/free/boardDetail.jsp?free_no=" + freeNo);
        }else {
        	System.out.println("로그인후 댓글을 작성해주세요");
        	resp.sendRedirect("user/loginForm.jsp");
        }
        
        
        
        
		
	}
	
}
