package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	/**
	 * 
	* Method : userList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	List<UserVo> userList();
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 등록
	 */
	int insertUser(UserVo userVo);

	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 회원 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : getuser
	* 작성자 : PC20
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	UserVo getuser(String userId);
	
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 수정
	 */
	int updateUser(UserVo userVo);
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	Map<String, Object> userPagingList(PageVo pageVo);
}
