
package user.model;

import java.util.List;

import board.port.model.PortBoardVO;

public class UserVO {
	
	private String id;
	private String pw;
	private String nickName;
	private String profilePath;
	private String userLevel;
	private int followerCount;
	
	//총 좋아요
	private int totalFav;
	//즐겨찾기
	private int totalFollow;
	//이 회원의 게시물 목록
	private List<PortBoardVO> userPort;
	
	
	public List<PortBoardVO> getUserPort() {
		return userPort;
	}
	public void setUserPort(List<PortBoardVO> userPort) {
		this.userPort = userPort;

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getTotalFav() {
		return totalFav;
	}
	public void setTotalFav(int totalFav) {
		this.totalFav = totalFav;
	}
	public int getTotalFollow() {
		return totalFollow;
	}
	public void setTotalFollow(int totalFollow) {
		this.totalFollow = totalFollow;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public int getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}
	
	
	
}
