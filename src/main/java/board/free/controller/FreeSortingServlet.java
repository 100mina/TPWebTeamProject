package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.free.model.FreeBoardDAO;
import board.free.model.FreeBoardVO;

@WebServlet("/sortingFreeBoard")
public class FreeSortingServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method 
		
		// 클라이언트로부터 받은 정렬 기준
        String orderBy = req.getParameter("orderBy");

        // 여기에서 orderBy를 기준으로 데이터를 가져오고 정렬하는 로직을 구현
        List<FreeBoardVO> sortedData = fetchDataAndSort(orderBy);

        // 정렬된 데이터를 HTML 형식으로 생성
        String sortedTableHTML = generateSortedTableHTML(sortedData);

        // 정렬된 데이터를 클라이언트에게 응답
        resp.getWriter().write(sortedTableHTML);
		
	}
	
	private List<FreeBoardVO> fetchDataAndSort(String orderBy) {
        // 여기에서 실제로 데이터를 가져와 정렬하는 로직을 구현
        FreeBoardDAO dao = new FreeBoardDAO();
        List<FreeBoardVO> data = dao.getFreeBoardList(); // 예시로 모든 게시글을 가져옴

        // 데이터를 orderBy 기준으로 정렬
        switch (orderBy) {
            case "latest":
                // 최신글 정렬
                // 예시로 최신글은 이미 DAO에서 ORDER BY FREE_NO DESC로 정렬되어 있으므로 따로 정렬하지 않음
                break;
            case "mostCommented":
                // 댓글 많은 글 정렬
                // 여기에 댓글 수에 따라 정렬하는 로직을 추가
                break;
            case "popular":
                // 인기글 정렬
                // 여기에 조회수 등을 기준으로 정렬하는 로직을 추가
                break;
            default:
                // 기본은 최신글 정렬
                // 아무 정렬 기준이 없을 경우, 최신글 정렬을 기본으로 설정
                break;
        }
        return data;
    }

    private String generateSortedTableHTML(List<FreeBoardVO> sortedData) {
        // 여기에서 정렬된 데이터를 HTML 형식으로 생성하는 로직을 구현
        StringBuilder tableHTML = new StringBuilder("<table>");
        for (FreeBoardVO data : sortedData) {
            // 각 데이터를 HTML로 변환하여 추가
        	tableHTML.append("<tr>");
            tableHTML.append("<td>").append(data.getFreeNo()).append("</td>");
            tableHTML.append("<td>").append(data.getFreeTitle()).append("</td>");
            tableHTML.append("<td>").append(data.getFreeCategory()).append("</td>");
            tableHTML.append("<td>").append(data.getUserNickname()).append("</td>");
            tableHTML.append("<td>").append(data.getFreeDate()).append("</td>");
            tableHTML.append("<td>").append(data.getFreeView()).append("</td>");
            // 추가된 부분: 댓글 수 및 추천 수
            tableHTML.append("<td>").append(data.getCommentCount()).append("</td>");
            tableHTML.append("<td>").append(data.getRecommendCount()).append("</td>");
            tableHTML.append("</tr>");
        }
        tableHTML.append("</table>");
        return tableHTML.toString();
    }
	
}
