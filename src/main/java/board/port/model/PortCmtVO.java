package board.port.model;

import java.sql.Date;

public class PortCmtVO {

	private int portCmtNo;
	private int portNo;
	private String userId;
	private String portCmtContent;
	private String portCmtDate;
	
	private String userNickname;
	
	
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public int getPortCmtNo() {
		return portCmtNo;
	}
	public void setPortCmtNo(int portCmtNo) {
		this.portCmtNo = portCmtNo;
	}
	public int getPortNo() {
		return portNo;
	}
	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPortCmtContent() {
		return portCmtContent;
	}
	public void setPortCmtContent(String portCmtContent) {
		this.portCmtContent = portCmtContent;
	}
	public String getPortCmtDate() {
		return portCmtDate;
	}
	public void setPortCmtDate(String portCmtDate) {
		this.portCmtDate = portCmtDate;
	}
	
	
	
}
