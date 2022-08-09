package com.myspring.pro30.member.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro30.member.service.MemberService;
import com.myspring.pro30.member.vo.MemberVO;



@Controller("memberController")
@EnableAspectJAutoProxy
public class MemberControllerImpl   implements MemberController {
//	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO ;
	
	
	@RequestMapping(value= "/main.do", method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;	
	}
	@Override
	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	
	//로그인 여부 확인 기능
	//1.로그인 했을때 정보가 memberVO에 있는 정보와 일치하면 main.do로 이동
	//2.로그인 했을때 정보가 일치하지 않으면 loginForm.do에 머물러있게
	@RequestMapping(value="/member/login.do", method = RequestMethod.GET)
	public ModelAndView loginDo(@ModelAttribute("member")MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.loginDO(memberVO);
		if(memberVO != null){
		HttpSession session = request.getSession();
		session.setAttribute("member", memberVO);
		session.setAttribute("LoginOn", true);
		mav.setViewName("redirect:/main.do");
		}else {
		mav.setViewName("redirect:/member/loginForm.do");	
		}
		return mav;
		
	}
	
	
	
	@RequestMapping(value="/member/loginForm.do", method = RequestMethod.GET)
	private ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;	
	}





	
}
