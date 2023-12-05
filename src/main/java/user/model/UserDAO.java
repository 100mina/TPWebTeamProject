package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class UserDAO {
	
	// 커넥션 풀을 이용하여 DB와 연결
	DataSource dataSource;
	
	public UserDAO(){
		try {
			Context context = new InitialContext();
			Context envContext = (Context)context.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/oracle");
			System.out.println("오라클 DBMS의 커넥션풀이 완성되었습니다. 언제든지 Connection을 꺼내 사용할 수 있습니다.");
		} catch (NamingException e) {

			e.printStackTrace();
		} // catch..
	}// dao
	
	public void insertMember(UserVO vo) {
		try {
			Connection conn = dataSource.getConnection();
			String sql = "INSERT INTO USERS(USER_ID, USER_PW, USER_NICKNAME) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getNickName());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// insertUser Method
	public UserVO getUser(UserVO vo) {
		
		try {
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM USERS WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("USER_ID"));
				vo.setPw(rs.getString("USER_PW"));
				vo.setNickName(rs.getString("USER_NICKNAME"));
				vo.setProfilePath(rs.getString("USER_PROFILE_PATH"));
				vo.setUserLevel(rs.getString("USER_LEVEL"));
			}
			rs.close();	
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}// getUser Methods----------------------------------------------------------------------------
	
	public void updateUserProfile(UserVO vo) {
		try {
			Connection conn = dataSource.getConnection();
			String sql = "UPDATE USERS SET USER_PROFILE_PATH=? WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getProfilePath());
			pstmt.setString(2, vo.getId());
			
			pstmt.executeUpdate();
	
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// updateUserProfile..-------------------------------------------------------------------------
	
	
	
	
	

}
