package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.BoardService;

@Configuration
public class ApplicationIocConfig {
	
//	<bean id="boardDao" class="kr.or.ddt.board.dao.BoardDao"/>
	
	@Bean
	public IboardDao boardDao() {
		return new BoardDao();
	}
	
	
//	<bean id="boardService" class="kr.or.ddit.board.service.BoardService">
//	<!-- boardService의 filed, property -->
//	<!-- setter injection -->
//	<property name="boardDao" ref="boardDao"></property>
//	</bean>
	
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		boardService.setName("brown");	// spring에서 관리되는 bean을 주입하려면 이렇게
		boardService.setBoardDao(boardDao());	// 새로 만들어진 것을 주입하려면 이렇게
		return boardService ;
	}
}
