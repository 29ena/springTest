package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;

public interface IprodDao {
	
	/**
	 * 
	* Method : prodList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : prod 전체 리스트 조회
	 */
	List<ProdVo> prodList();
	
	/**
	 * 
	* Method : prodsCnt
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : prod 전체수 조회
	 */
	int prodsCnt();
	
	/**
	 * 
	* Method : prodPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	List<ProdVo> prodPagingList(PageVo pageVo);
}
