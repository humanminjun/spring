package com.myspring.pro30.member.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//메인 페이지
	@RequestMapping(value= "/main.do", method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;	
	}
	
	//회원 목록
	@Override
	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	//회원삭제
	@Override
	@RequestMapping(value="/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView remove(@RequestParam("id")String id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		/* MemberVO remove = memberService.remove(); */
		memberService.remove(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
		
	}
	
	
	
	
	//로그인 기능구현
	@Override
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public ModelAndView loginDo(@ModelAttribute("member")MemberVO member,
			RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.loginDO(member);
		HttpSession session = request.getSession();
		if(memberVO != null){
		session.setAttribute("member", memberVO);
		session.setAttribute("isLogOn", true);
		mav.setViewName("redirect:/main.do");
		}else {
		session.setAttribute ("result","loginFailed");	
		mav.setViewName("redirect:/member/loginForm.do");	
		/*
		 * message = "<script>"; message += "alert('로그인 정보가 틀렸습니다.');"; message +=
		 * "location.href='"+request.getContextPath()+"/member/loginForm.do';"; message
		 * += "</script>";
		 */
		}
		
		return mav;
		
	}
	
	
	//로그아웃
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	private ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogon");
		session.removeAttribute("result");
		mav.setViewName("redirect:/main.do");
		
		return mav;

	}
	
	//FORM 화면으로 넘어가기
	@RequestMapping(value="/member/*Form.do", method = RequestMethod.GET)
	private ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;	
	}
	
	//회원가입 기능
	@Override
	@RequestMapping(value="/member/addMember.do", method = RequestMethod.POST )
	public ModelAndView add(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		return null;
	}

	





	
}
