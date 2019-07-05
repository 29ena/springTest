package kr.or.ddit.ajax.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@RequestMapping("/ajax")
@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Resource(name = "userService")
	private IuserService userService;
	
	/**
	 * 
	* Method : view
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : ajax 호출용 view
	 */
	@RequestMapping("/view")
	public String view() {
		
		return"tiles.ajaxView";
	}
	
	@RequestMapping("/requestData")
	public String requestData(Model model) {
		
		model.addAttribute("pageVo", new PageVo(5, 10));
//		model.addAttribute("pageVo2", new PageVo(5, 10));
//		List<String> rangers = new ArrayList<String>();
//		rangers.add("brown");
//		rangers.add("sally");
//		rangers.add("cony");
//		model.addAttribute("rangers", rangers);
		/*
		 *{ pageVo : {page :5, pageSize: 10}}
		 *{ pageVo : {page :5, pageSize: 10},{ pageVo2 : {page :5, pageSize: 10}} 
		 *{ pageVo : {page :5, pageSize: 10},{ pageVo2 : {page :5, pageSize: 10}, rangers :["brown","sally","cony"]} 
		 */
		
		return "jsonView";
	}
	
	@RequestMapping("/requestDataResponseBody")
	@ResponseBody	// 응답내용을 responseBody에다가 작성
	public PageVo requestDataResponseBody() {
		return new PageVo(5, 10);	// 지정하지 않으면 기본형으로 json이 리턴
	}
	
	@RequestMapping("/user")
	public String user(String userId, Model model) {
		
		UserVo userVo = userService.getuser(userId);
		model.addAttribute("userVo", userVo);
		// {userVo : {userId : brown', name : '브라운', alias : '곰' .......}}
		
		return "jsonView";
	}
	
	@RequestMapping("/userHtml")
	public String userHtml(String userId, Model model) {
		
		UserVo userVo = userService.getuser(userId);
		model.addAttribute("userVo", userVo);
		
		return "user/userHtml";
	}
	
	@RequestMapping(path = "/requestBody",
			
					// consumes : content-type 제한
					consumes = {"application/json"},
					
					//produces : 메소드가 생성 가능한 타입(accept 헤더 확인)
					produces = {"application/json","application/xml"})			
	@ResponseBody
	public UserVo requestBody(@RequestBody UserVo userVo) {
		logger.debug("userVo : {}", userVo);
		userVo.setUserId(userVo.getUserId() + "_MODIFY");
		userVo.setPass(userVo.getPass() + "_MODIFY");
		
		return userVo;
	}
}
