package net.developia.restful.user;

import java.util.List;

public interface UserDAO {

	UserVO getUser(UserVO userVO);

	List<ItemVO> getWords(String term);

}
