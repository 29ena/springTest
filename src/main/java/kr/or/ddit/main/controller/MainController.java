package kr.or.ddit.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 servlet
  - extends HttpServlet
  - servlet-mapping (web.xml @WebServlet)
  - service -> doXXX
  
 spring
  - pojo (Plain Old Java Object), @Controller (어노테이션 사용) 
  - @RequestMapping (class, method)
  - @RequestMapping에 설정한 url method 호출
 */
@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@RequestMapping("/main")
	public String mainView(Model model) { 
		logger.debug("mainview");
		// prifix : /WEB-INF/views/
		// suffix: .jsp
		
		// prefix + viewName + suffix
		// /WEB-INF/views/main.jsp
		
		// 아래 문장은 다음과 동일하다.
//		 request.setAttribute("mainUserId","brown");
		model.addAttribute("mainUserId", "brown");
		
		// viewName
		return "main";
	}
}
