package user.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import user.model.UserDAO;
import user.model.UserVO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
		maxFileSize = 1024 * 1024 * 5, // 5 MB
		maxRequestSize = 1024 * 1024 * 5 * 5 // 25 MB
)
@WebServlet("/updateProfile")
public class UserProfileselectServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");

		Part part = req.getPart("profileImg");
		UserVO userInfo = (UserVO) req.getSession().getAttribute("user");

		if (req.getPart("profileImg") != null && part.getSize() > 0) {
			String fileName = part.getSubmittedFileName().toString();
			String savePath = "C:/Users/user1/Desktop/img/TeamProject/" + userInfo.getId() + "/profile";
			File file = new File(savePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 저장 경로
			String filePath = savePath + "\\" + System.currentTimeMillis() + fileName;
			// 실제 저장
			part.write(filePath);
			UserDAO dao = new UserDAO();
			userInfo.setProfilePath(filePath);
			dao.updateUserProfile(userInfo);
		}
		System.out.println(userInfo.getProfilePath());
		PrintWriter wt = resp.getWriter();
		wt.println("<!DOCTYPE html>");
		wt.println("<html>");
		wt.println("<head>");
		wt.println("<meta charset=\"UTF-8\">");
		wt.println("<script>");
		wt.println("alert('프로필 설정이 완료 됐습니다!')");
		wt.println("location.href='./index.jsp';");
		wt.println("</script>");
		wt.println("</head>");
		wt.println("</html>");
		
		

	}
}
