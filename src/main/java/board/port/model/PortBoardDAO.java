package board.port.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PortBoardDAO {

	DataSource dataSource;

	public PortBoardDAO() {
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 생성자 //

	// 게시물 추가
	public void insertPort(PortBoardVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "INSERT INTO PORT_BOARD(PORT_NO, PORT_TITLE, PORT_CONTENT, USER_ID) VALUES(SEQ_PORT_NO.NEXTVAL,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPortTitle());
			pstmt.setString(2, vo.getPortContent());
			pstmt.setString(3, vo.getUserId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// 게시물 추가 //

	// 게시물 이미지 저장
	public void insertPortImg(List<PortBoardImgVO> imgList) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "INSERT INTO PORT_BOARD_IMG VALUES(SEQ_IMG_NO.NEXTVAL, ?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (PortBoardImgVO vo : imgList) {
				pstmt.setInt(1, vo.getPortNo());
				pstmt.setString(2, vo.getImgPath());

				pstmt.executeUpdate();
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // 게시물 이미지 저장 //

	// 전체 게시물 리스트 검색
	public List<PortBoardVO> getPortList() {

		List<PortBoardVO> boardList = new ArrayList<PortBoardVO>();

		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM PORT_BOARD ORDER BY PORT_NO DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PortBoardVO vo = new PortBoardVO();
				vo.setPortNo(rs.getInt("PORT_NO"));
				vo.setPortTitle(rs.getString("PORT_TITLE"));
				vo.setPortContent(rs.getString("PORT_CONTENT"));
				vo.setUserId(rs.getString("USER_ID"));
				vo.setPortDate(rs.getDate("PORT_DATE"));
				vo.setPortView(rs.getInt("PORT_VIEW"));

				boardList.add(vo);

			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardList;
	}// 전체 게시물 리스트 검색 //

	// 상세 게시물 검색
	public PortBoardVO getPort(PortBoardVO vo) {

		PortBoardVO port = null;

		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM PORT_BOARD WHERE PORT_NO=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				port = new PortBoardVO();
				port.setPortNo(rs.getInt("PORT_NO"));
				port.setPortTitle(rs.getString("PORT_TITLE"));
				port.setPortContent(rs.getString("PORT_CONTENT"));
				port.setUserId(rs.getString("USER_ID"));
				port.setPortDate(rs.getDate("PORT_DATE"));
				port.setPortView(rs.getInt("PORT_VIEW"));

			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return port;
	}// 상세 게시물 검색 //

	// 상세 게시물 클릭 시 조회수 오르기
	public void view(PortBoardVO vo) {
		try {
			Connection conn = dataSource.getConnection();

			// 기존 조회수를 검색하고 1을 더해서 조회수를 갱신
			String sql = "UPDATE PORT_BOARD SET PORT_VIEW=(SELECT PORT_VIEW FROM PORT_BOARD WHERE PORT_NO=?)+1 WHERE PORT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());
			pstmt.setInt(2, vo.getPortNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 상세 게시물 클릭 시 조회수 오르기//

	// 특정 회원의 게시물만 가져오기
	public List<PortBoardVO> getUserPort(PortBoardVO vo) {

		List<PortBoardVO> boardList = new ArrayList<PortBoardVO>();

		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT PB.*, PBI.IMG_NO, PBI.IMG_PATH " + "FROM PORT_BOARD PB " + "LEFT JOIN ( "
					+ "  SELECT PORT_NO, MIN(IMG_NO) AS MIN_IMG_NO " + "  FROM PORT_BOARD_IMG " + "  GROUP BY PORT_NO "
					+ ") MIN_IMG ON PB.PORT_NO = MIN_IMG.PORT_NO "
					+ "LEFT JOIN PORT_BOARD_IMG PBI ON MIN_IMG.MIN_IMG_NO = PBI.IMG_NO " + "WHERE PB.USER_ID = ? "
					+ "ORDER BY PB.PORT_NO DESC";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PortBoardVO vo1 = new PortBoardVO();
				vo1.setPortNo(rs.getInt("PORT_NO"));
				vo1.setPortTitle(rs.getString("PORT_TITLE"));
				vo1.setPortContent(rs.getString("PORT_CONTENT"));
				vo1.setUserId(rs.getString("USER_ID"));
				vo1.setPortDate(rs.getDate("PORT_DATE"));
				vo1.setPortView(rs.getInt("PORT_VIEW"));

				PortBoardImgVO vo2 = new PortBoardImgVO();
				vo2.setImgNo(rs.getInt("IMG_NO"));
				vo2.setImgPath(rs.getString("IMG_PATH"));

				vo1.setPortImg(vo2);

				boardList.add(vo1);

			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardList;
	}

	// 해당 게시물의 이미지들 가져오기
	public List<PortBoardImgVO> getPortImgs(PortBoardVO vo) {

		List<PortBoardImgVO> portImgList = new ArrayList<PortBoardImgVO>();

		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM PORT_BOARD_IMG WHERE PORT_NO=? ORDER BY IMG_NO";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PortBoardImgVO img = new PortBoardImgVO();
				img.setImgNo(rs.getInt("IMG_NO"));
				img.setPortNo(rs.getInt("PORT_NO"));
				img.setImgPath(rs.getString("IMG_PATH"));

				portImgList.add(img);
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return portImgList;
	}// 해당 게시물의 이미지들 가져오기 //

	// 해당 이미지 가져오기
	public PortBoardImgVO getImg(PortBoardImgVO vo) {

		PortBoardImgVO img = null;

		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM PORT_BOARD_IMG WHERE IMG_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getImgNo());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				img = new PortBoardImgVO();
				img.setImgNo(rs.getInt("IMG_NO"));
				img.setPortNo(rs.getInt("PORT_NO"));
				img.setImgPath(rs.getString("IMG_PATH"));
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return img;
	}// 해당 이미지 가져오기 //

	// 게시물 수정
	public void updatePortBoard(PortBoardVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "UPDATE PORT_BOARD SET PORT_TITLE=?, PORT_CONTENT=? WHERE PORT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPortTitle());
			pstmt.setString(2, vo.getPortContent());
			pstmt.setInt(3, vo.getPortNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 게시물 수정//

	// 게시물 이미지 수정 - 원래 있던 이미지들 삭제 -> 삽입
	public void deletePortImg(PortBoardVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "DELETE FROM PORT_BOARD_IMG WHERE PORT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // 게시물 이미지 수정 //

	// 게시물 삭제
	public void deletePortBoard(PortBoardVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "DELETE FROM PORT_BOARD WHERE PORT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // 게시물 삭제 //

	// 댓글 작성
	// TODO: 파라미터 회원정보VO로 변경
	public void insertPortCmt(PortCmtVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "INSERT INTO PORT_COMMENT(PORT_CMT_NO ,PORT_NO, USER_ID, PORT_CMT_CONTENT) VALUES(SEQ_PORT_CMT_NO.NEXTVAL,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());
			pstmt.setString(2, vo.getUserId());
			pstmt.setString(3, vo.getPortCmtContent());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// 댓글 작성//

	// 댓글 삭제
	public void deletePortCmt(PortCmtVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "DELETE FROM PORT_COMMENT WHERE PORT_CMT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortCmtNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 댓글 삭제//

	// 현재 게시물의 댓글 내역 불러오기
	public List<PortCmtVO> getPortCmtList(PortBoardVO vo) {

		List<PortCmtVO> portCmtList = new ArrayList<PortCmtVO>();

		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM PORT_COMMENT WHERE PORT_NO=? ORDER BY PORT_CMT_NO";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PortCmtVO vo1 = new PortCmtVO();
				vo1.setPortCmtNo(rs.getInt("PORT_CMT_NO"));
				vo1.setPortNo(rs.getInt("PORT_NO"));
				vo1.setUserId(rs.getString("USER_ID"));
				vo1.setPortCmtContent(rs.getString("PORT_CMT_CONTENT"));

				vo1.setPortCmtDate(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(rs.getDate("PORT_CMT_DATE")));

				portCmtList.add(vo1);
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return portCmtList;
	}// 현재 게시물의 댓글 내역 불러오기//

	// 댓글 수정
	public void updatePortCmt(PortCmtVO vo) {

		try {
			Connection conn = dataSource.getConnection();

			String sql = "UPDATE PORT_COMMENT SET PORT_CMT_CONTENT=? WHERE PORT_CMT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPortCmtContent());
			pstmt.setInt(2, vo.getPortCmtNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 댓글 수정//

	// 게시물 좋아요 ON
	public void likeOn(PortBoardVO vo) {
		try {
			Connection conn = dataSource.getConnection();

			String sql = "INSERT INTO PORT_FAVORITE VALUES(SEQ_FAV_NO.NEXTVAL, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());
			pstmt.setString(2, vo.getUserId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 게시물 좋아요 ON//

	// 게시물 좋아요 OFF
	public void likeOff(PortBoardVO vo) {
		try {
			Connection conn = dataSource.getConnection();

			String sql = "DELETE FROM PORT_FAVORITE WHERE PORT_NO=? AND USER_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());
			pstmt.setString(2, vo.getUserId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 게시물 좋아요 OFF//

	// 좋아요 갯수 카운트
	public int countFav(PortBoardVO vo) {
		int countFav = 0;
		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT COUNT(*) FROM PORT_FAVORITE WHERE PORT_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				countFav = rs.getInt(1);
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countFav;
	}// 좋아요 갯수 카운트//
	
	//좋아요 여부 검색
	public boolean isLike(PortBoardVO vo) {
		boolean isLike= false;
		
		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM PORT_FAVORITE WHERE PORT_NO=? AND USER_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());
			pstmt.setString(2, vo.getUserId());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) isLike= true;

			pstmt.close();
			conn.close();
			System.out.println(vo.getPortNo()+"."+vo.getUserId()+"."+isLike);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLike;
	}

}
