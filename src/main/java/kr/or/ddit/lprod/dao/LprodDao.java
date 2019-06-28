package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

@Repository
public class LprodDao implements IlprodDao {

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		return sqlSession.selectList("lprod.lprodList");
	}

	/**
	 * 
	* Method : lprodsCnt
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	 */
	@Override
	public int lprodsCnt() {
		return sqlSession.selectOne("lprod.lprodsCnt");
	}
	
	/**
	 * 
	* Method : lprodList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 조회
	 */
	@Override
	public List<LprodVo> lprodList() {
		return sqlSession.selectList("lprod.lprodList");
	}
}
