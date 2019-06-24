package kr.or.ddit.aop;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IboardService;

@Configuration // <context:annotation-config/> 역활을 @configuration에서 담당
//@ComponentScan(basePackages = { "kr.or.ddit" }, // <context:component-scan/> 이부분
//		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Aspect.class)
//		,excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)) // <context:include-filter
		
		
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy/> 이부분

public class AopScanConfig {
	
	@Bean
	public IboardDao boardDao() {
		return new BoardDao();
	}
	@Bean 
	public IboardService boardService() {
		return new BoardService();
	}
}
