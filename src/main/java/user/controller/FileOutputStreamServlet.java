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
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // 이미지 파일 경로
	    	UserVO user = (UserVO)req.getSession().getAttribute("user");
	    	String reqUserId = req.getParameter("userId");
	    	if (user.getId().equals(reqUserId) && user.getId()!=null) {
		        String imagePath = user.getProfilePath();
		    	String contentType = getServletContext().getMimeType(imagePath);
		    	resp.setContentType(contentType);
		    	System.out.println("aaaaa"+user.getId()+"");
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
			} else {
		        String imagePath = req.getParameter("imgPath");
		    	String contentType = getServletContext().getMimeType(imagePath);
		    	resp.setContentType(contentType);
		    	System.out.println("imgimgimg"+imagePath);
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
	    
	    
} 
