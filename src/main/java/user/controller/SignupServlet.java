package user.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import user.model.UserDAO;
import user.model.UserVO;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id"); 
		String pw = req.getParameter("pw"); 
		String nickName = req.getParameter("nickName");
//		Part part = req.getPart("profileImg");
//		
//		if (req.getPart("profileImg")!=null && part.getSize() > 0) {
//			String fileName = part.getSubmittedFileName().toString();
//			String savePath = "D:TeamProject/"+id+"/profile";
//			File file = new File(savePath);
//			if (!file.exists()) {
//				file.mkdirs();
//			}
//			// 저장 경로
//			String filePath = savePath+"/"+System.currentTimeMillis()+fileName;
//			// 실제 저장
//			part.write(filePath);
//			UserVO vo = new UserVO();
//			vo.setId(id);
//			vo.setPw(pw);
//			vo.setNickName(nickName);
//			vo.setProfilePath(filePath);
//			
//			UserDAO dao = new UserDAO();
//			dao.updateUserProfile(vo);
//			
//			PrintWriter wt = resp.getWriter();
//			wt.println("<!DOCTYPE html>");
//			wt.println("<html>");
//			wt.println("<head>");
//			wt.println("<script>");
//			wt.println("alert('프로필 설정이 완료 됐습니다!')");
//			wt.println("location.href='./index.jsp';");
//			wt.println("</script>");
//			wt.println("</head>");
//			wt.println("</html>");
//				
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setNickName(nickName);
			
			
			UserDAO dao = new UserDAO();
			dao.insertMember(vo);
			
			HttpSession session = req.getSession();
			session.setAttribute("userInfo", vo);
			resp.sendRedirect("user/profile_selectForm.jsp");
		}
	}

}
