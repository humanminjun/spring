package com.myspring.pro30.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro30.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)throws Exception;
	//무조건 복습
	public ModelAndView loginDo(@ModelAttribute("member")MemberVO memberVO, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView remove(@RequestParam("id")String id,HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView add(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView read(  HttpServletRequest request, HttpServletResponse response)throws Exception;
}