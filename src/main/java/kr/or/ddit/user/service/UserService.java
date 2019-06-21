package kr.or.ddit.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements IuserService {
	
	@Resource(name = "userDao")
	private IuserDao userDao;
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 회원 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
		
		
	}

}
