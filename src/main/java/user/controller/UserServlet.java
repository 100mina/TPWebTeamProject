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

import user.model.UserVO;

@WebServlet("userPage")

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
		
		UserVO user = (UserVO)req.getSession().getAttribute("user");
		// PortBoardVO pbVO;
		// BoardDAO bDAO; bDAO.getUserPosting
		class PBVO {
			String userNickName= "홍길동";
			String profilePath= user.getProfilePath();
			int viewCount= 999;
			int like = 999;
			String thumbnailImgPath;
		}
		List<PBVO> pbvos = new ArrayList<PBVO>();
		for(int i=0;i<20;i++){
			pbvos.add(new PBVO());
		}
		
		req.setAttribute("userPortPost", pbvos);
		resp.sendRedirect("user/userMyPage.jsp?size="+pbvos.size());
		
	}
}
