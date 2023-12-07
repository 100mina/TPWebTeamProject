package user.model;

public class FollowerVO {
	private int folNo;
	private String userId;
	private String userNickName;
	private String follwerId;
	private String userProfilePath;
	private int follwerCount;
	
	
	
	
	public int getFollwerCount() {
		return follwerCount;
	}
	public void setFollwerCount(int follwerCount) {
		this.follwerCount = follwerCount;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserProfilePath() {
		return userProfilePath;
	}
	public void setUserProfilePath(String userProfilePath) {
		this.userProfilePath = userProfilePath;
	}
	public int getFolNo() {
		return folNo;
	}
	public void setFolNo(int folNo) {
		this.folNo = folNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFollwerId() {
		return follwerId;
	}
	public void setFollwerId(String follwerId) {
		this.follwerId = follwerId;
	}
	
	
	
	
}
