package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false); // 세션이 없으면 새로 생성하지 않음

        if (session != null) {
            session.invalidate(); // 세션 무효화
        }

        // 로그인 페이지로 리다이렉트 또는 다른 작업을 수행할 수 있음
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
		
		
		
		
	}
}
