package user.model;

import java.util.List;

import board.port.model.PortBoardDAO;
import board.port.model.PortBoardService;

public class UserService {
	private UserDAO userDao;
	private UserVO userVo;
	private FollowerVO folVo;
	private PortBoardService pbService;
	private PortBoardDAO pbDao;
	
	public void loadUserMyPage(){
		pbDao.getUserPort(null);
		
		
	}
	
	
	
}
