package net.developia.restful.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public UserVO getUser(UserVO userVO) throws Exception {
		UserVO userInfo = userDAO.getUser(userVO);
		if (userInfo == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 틀립니다.");
			}
		return userInfo;
	}

	public List<ItemVO> getWords(String term)  {
		return userDAO.getWords(term);
	}

}
