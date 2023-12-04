package board.port.model;
import java.util.List;
import java.sql.Date;

public class PortBoardVO {

	private int portNo;
	private String portTitle;
	private String portContent;
	private String userId;
	private Date portDate;
	private int portView;
	
	private String userNickname;
	

	// 해당 게시물의 첨부파일 리스트
	private List<PortBoardImgVO> portImgList;

	// 해당 게시물 작성자의 모든 게시글 리스트
	private List<PortBoardVO> userPort;

	// 해당 게시물의 첨부파일 1개
	private PortBoardImgVO portImg;

	// 해당 게시물의 댓글 리스트
	private List<PortCmtVO> portCmtList;
	
	//댓글 수
	private int countCmt; 

	// 로그인 중인 유저의 해당 게시물 좋아요 여부
	private boolean isLike;
	
	// 해당 게시물의 좋아요 수
	private int countFav;
	
	
	
	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public boolean getIsLike() {
		return isLike;
	}

	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}

	public int getCountFav() {
		return countFav;
	}

	public void setCountFav(int countFav) {
		this.countFav = countFav;
	}

	public int getCountCmt() {
		return countCmt;
	}

	public void setCountCmt(int countCmt) {
		this.countCmt = countCmt;
	}

	public List<PortBoardVO> getUserPort() {
		return userPort;
	}

	public void setUserPort(List<PortBoardVO> userPort) {
		this.userPort = userPort;
	}

	public List<PortCmtVO> getPortCmtList() {
		return portCmtList;
	}

	public void setPortCmtList(List<PortCmtVO> portCmtList) {
		this.portCmtList = portCmtList;
		this.countCmt = portCmtList.size();
	}

	public PortBoardImgVO getPortImg() {
		return portImg;
	}

	public void setPortImg(PortBoardImgVO portImg) {
		this.portImg = portImg;
	}

	public List<PortBoardImgVO> getPortImgList() {
		return portImgList;
	}

	public void setPortImgList(List<PortBoardImgVO> portImgList) {
		this.portImgList = portImgList;
	}

	public int getPortNo() {
		return portNo;
	}

	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}

	public String getPortTitle() {
		return portTitle;
	}

	public void setPortTitle(String portTitle) {
		this.portTitle = portTitle;
	}

	public String getPortContent() {
		return portContent;
	}

	public void setPortContent(String portContent) {
		this.portContent = portContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPortDate() {
		return portDate;
	}

	public void setPortDate(Date portDate) {
		this.portDate = portDate;
	}

	public int getPortView() {
		return portView;
	}

	public void setPortView(int portView) {
		this.portView = portView;
	}
}
/*<<<<<<< HEAD

public class PortBoardVO {
	
	private int portNo;
	private String portTitle;
	private String portContent;
	private String userId;
	private Date portDate;
	private int portView;
	private String imgPath;
	private int portFavNo;
	
	public int getPortNo() {
		return portNo;
	}

	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}

	public String getPortTitle() {
		return portTitle;
	}

	public void setPortTitle(String portTitle) {
		this.portTitle = portTitle;
	}

	public String getPortContent() {
		return portContent;
	}

	public void setPortContent(String portContent) {
		this.portContent = portContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPortDate() {
		return portDate;
	}

	public void setPortDate(Date portDate) {
		this.portDate = portDate;
	}

	public int getPortView() {
		return portView;
	}

	public void setPortView(int portView) {
		this.portView = portView;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getPortFavNo() {
		return portFavNo;
	}

	public void setPortFavNo(int portFavNo) {
		this.portFavNo = portFavNo;
	}


	
	
	
=======
>>>>>>> refs/heads/민아

=======

*/
