package user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import user.model.UserVO;

@WebServlet("/fileLoad")
public class FileOutputStreamServlet extends HttpServlet{	
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        // 이미지 파일 경로
	    	UserVO user = (UserVO)req.getSession().getAttribute("user");
	        String imagePath = user.getProfilePath();
	    	String contentType = getServletContext().getMimeType(imagePath);
	    	resp.setContentType(contentType);
	    	
	        // 이미지 파일을 읽어옴
	        File imageFile = new File(imagePath);
	        try (FileInputStream fis = new FileInputStream(imageFile);
	                OutputStream os = resp.getOutputStream()) {

	            // 이미지 파일을 읽어서 response로 전송
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                os.write(buffer, 0, bytesRead);
	            }
	        }
	    }
} 

/*
	 * else { // 요청된 아이디에 해당하는 프로필 사진 찾기 UserVO reqUser = new UserVO();
	 * reqUser.setId(reqUserId); UserDAO dao = new UserDAO(); reqUser =
	 * dao.getUser(reqUser);
	 * 
	 * String imgPath = reqUser.getProfilePath(); File imageFile = new
	 * File(imgPath); FileInputStream fileInputStream = new
	 * FileInputStream(imageFile); OutputStream oStream = resp.getOutputStream();
	 * 
	 * byte[] buffer = new byte[1024];
	 * 
	 * int byteRead; while ((byteRead = fileInputStream.read(buffer)) != -1) {
	 * oStream.write(buffer, 0, byteRead);
	 */

			