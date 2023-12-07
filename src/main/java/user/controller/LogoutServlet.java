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
			
        // 세션을 얻어옵니다.
        HttpSession session = req.getSession(false);

        // 세션이 존재하면 세션을 무효화하고 로그인 페이지로 이동합니다.
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath());
    }
}

