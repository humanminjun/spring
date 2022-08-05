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
//@EnableAspectJAutoProxy
public class MemberControllerImpl   implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO ;
	
	@RequestMapping(value = { "/","/main.do"}, method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/listMembers.do" ,method = RequestMethod.GET) 
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception { //오버라이드 받은 부분
		request.setCharacterEncoding("utf-8");//UTF-8로 된 값을 받는다
		response.setContentType("html/text;charset=utf-8");//내용타입을 UTF-8로 된 값을 전달받는다 브라우저마다 default값이 다르기때문에 Character 말고 Content도 써준다
		String viewName = (String)request.getAttribute("viewName");//viewName의 타입값을 String으로 지정해준뒤 가져온다
		List membersList = memberService.listMembers(); //List 타입의 memberList = memberService안의 listMembers
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList); // view의 전달할 키 값을 membersList 와 membersList로 지정
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, //member 값을 MemberVO 에있는 member으로 전해준다
			//ModelAttribute란 뭘까? ModelAttribute를 사용하지 않았다면 requestParam으로
			//값을 받고 set을 사용해서 값을 넣어준다 하지만 ModelAttribute 가 알아서 해준다
			//@ModelAttribute("member")생략가능
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int result = memberService.addMember(member); // 결과값을 member로 설정 
		ModelAndView mav = new ModelAndView( "redirect:/member/listMembers.do" );
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{ // 오버라이드 받은 부분
		request.setCharacterEncoding("utf-8"); // UTF-8 로 된값을 받는다
		memberService.removeMember(id); // memberService 에 있는 아이디 값
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do"); //listMembers.do로 
		return mav;
	}
	/*
	@RequestMapping(value = { "/member/loginForm.do", "/member/memberForm.do" }, method =  RequestMethod.GET)
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/
	
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception { //오버라이드 받은 부분
	ModelAndView mav = new ModelAndView();  // ModelAndView 를 mav로 사용하겠다
	memberVO = memberService.login(member); //
	if(memberVO != null) { //만약 입력 값이 memberVO 에 저장된 값에 없지 않다면
	    HttpSession session = request.getSession();//세션을 생성하여 얻는다
	    session.setAttribute("member", memberVO);//세션이 유지되는동안 member 의 memberVO값을 저장한다
	    session.setAttribute("isLogOn", true);//세션이 유지되는동안 isLogOn 의 true값을 저장한다
	    //mav.setViewName("redirect:/member/listMembers.do");
	    String action = (String)session.getAttribute("action"); //return타입이 Object 이므로 String으로 형 변환
	    //action값을 세션에 저장 
	    session.removeAttribute("action"); //action값에 해당하는 정보 삭제
	    if(action!= null) { //acction 값이 널값이 아니라면  
	       mav.setViewName("redirect:"+action);
	    }else { // 하지만 action값을 삭제 했으니까 listMembers.do 로 이동
	       mav.setViewName("redirect:/member/listMembers.do");	
	    }

	}else { //입력 값이 memberVO에 저장된 값이 아니라면
	   rAttr.addAttribute("result","loginFailed"); //결과와 loginFailed를 일화성 값으로 보내준다
	   mav.setViewName("redirect:/member/loginForm.do"); //mav의 셋뷰네임으로 로그인폼두로 사용자를 보내준다
	}
	return mav; //mav값을 돌려준다
	}

	@Override
	@RequestMapping(value = "/member/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); // 세션값 생성후 가져오기
		session.removeAttribute("member"); // 멤버라는 세션에 저장된 값을 삭제
		session.removeAttribute("isLogOn"); // isLogon 도 삭제
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}	

	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,//jsp에서 받은 result를 result에 저장
							  @RequestParam(value= "action", required=false) String action,//listArticles.jsp에서 받은 action 값을 action에 저장 
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception { // 오버라이드 
		String viewName = (String)request.getAttribute("viewName"); //viewName을 가져온다 
		HttpSession session = request.getSession();// 세션값 생성후 가져온다
		session.setAttribute("action", action); //세션에 엑션을 저장
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("result",result);//view에 전달할 result 를 설정
		mav.setViewName(viewName);//응답할 주소를 설정해준다
		return mav;
	}
	

	/*
	 * private String getViewName(HttpServletRequest request) throws Exception {
	 * String contextPath = request.getContextPath(); String uri = (String)
	 * request.getAttribute("javax.servlet.include.request_uri"); if (uri == null ||
	 * uri.trim().equals("")) { uri = request.getRequestURI(); }
	 * 
	 * int begin = 0; if (!((contextPath == null) || ("".equals(contextPath)))) {
	 * begin = contextPath.length(); }
	 * 
	 * int end; if (uri.indexOf(";") != -1) { end = uri.indexOf(";"); } else if
	 * (uri.indexOf("?") != -1) { end = uri.indexOf("?"); } else { end =
	 * uri.length(); }
	 * 
	 * String viewName = uri.substring(begin, end); if (viewName.indexOf(".") != -1)
	 * { viewName = viewName.substring(0, viewName.lastIndexOf(".")); } if
	 * (viewName.lastIndexOf("/") != -1) { viewName =
	 * viewName.substring(viewName.lastIndexOf("/", 1), viewName.length()); } return
	 * viewName; }
	 */


}
